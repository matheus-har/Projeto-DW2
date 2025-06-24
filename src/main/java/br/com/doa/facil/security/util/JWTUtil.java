package br.com.doa.facil.security.util;

import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JWTUtil {

    private static final String SECRET_KEY = "secreta-para-jwt-nao-compartilhar";
    private static final long EXPIRATION_TIME = 86400000; // 1 dia em milissegundos

    @Autowired
    private UsersRepository usersRepository;

    public String generateToken(String email) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", user.getPermissions().stream().map(p -> p.getDescription()).toList());
        claims.put("scope", "read write");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            return (username != null && expirationDate.after(new Date()));
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    @SuppressWarnings("unchecked")
	public List<String> getRoles(String token) {
        Claims claims = getClaims(token);
        return claims.get("authorities", List.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
