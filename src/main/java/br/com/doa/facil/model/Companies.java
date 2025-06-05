package br.com.doa.facil.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "companies")
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 60)
    private String registered_Name;

    @NotNull
    @Size(max = 60)
    private String fantasy_Name;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 11)
    private String telephone;

    @OneToOne
    @JoinColumn(name = "user_Resp", referencedColumnName = "id")
    private Users user_Resp;
    
    @NotNull
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistered_Name() {
        return registered_Name;
    }

    public void setRegistered_Name(String social_Name) {
        this.registered_Name = social_Name;
    }

    public String getFantasy_Name() {
        return fantasy_Name;
    }

    public void setFantasy_Name(String fantasy_Name) {
        this.fantasy_Name = fantasy_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        Companies other = (Companies) obj;
        return Objects.equals(id, other.id);
    }
}
