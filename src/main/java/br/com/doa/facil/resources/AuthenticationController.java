package br.com.doa.facil.resources;

import br.com.doa.facil.model.Gender;
import br.com.doa.facil.model.Users;
import br.com.doa.facil.repository.UsersRepository;
import br.com.doa.facil.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

            authenticationManager.authenticate(authToken);

            Users user = usersRepository.findByEmail(request.getEmail()).orElseThrow();

            String token = jwtUtil.generateToken(user.getEmail());
            List<String> permissions = user.getPermissions().stream().map(p -> p.getDescription()).toList();

            return ResponseEntity.ok(new LoginResponse(token, permissions));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (usersRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já cadastrado.");
        }

        Users user = new Users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setGender(Gender.valueOf(request.getGender()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        user.setBirthDate(LocalDate.parse(request.getBirthDate(), formatter));
        user.setTelephone(request.getTelephone());
        user.setActive(request.getActive());

        usersRepository.save(user);

        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }

    // ===== DTOs internos =====

    static class LoginRequest {
        private String email;
        private String password;
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    static class RegisterRequest {
        private String name;
        private String email;
        private String password;
        private String gender;
        private String birthDate;
        private String telephone;
        private Boolean active;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getBirthDate() { return birthDate; }
        public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
        public String getTelephone() { return telephone; }
        public void setTelephone(String telephone) { this.telephone = telephone; }
        public Boolean getActive() { return active; }
        public void setActive(Boolean active) { this.active = active; }
    }

    static class LoginResponse {
        private final String token;
        private final List<String> permissions;

        public LoginResponse(String token, List<String> permissions) {
            this.token = token;
            this.permissions = permissions;
        }

        public String getToken() { return token; }
        public List<String> getPermissions() { return permissions; }
    }
}
