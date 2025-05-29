package br.com.doa.facil.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "donations")
public class Donations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "donorId", referencedColumnName = "id")
    private Users donor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "recipientId", referencedColumnName = "id")
    private Users recipient;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Column(name = "dateD")
    private LocalDate date;

    @NotNull
    @Size(max = 50)
    private String product;

    @Size(max = 70)
    @Column(name = "pickupLocation")
    private String pickupLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getDonor() {
        return donor;
    }

    public void setDonor(Users donor) {
        this.donor = donor;
    }

    public Users getRecipient() {
        return recipient;
    }

    public void setRecipient(Users recipient) {
        this.recipient = recipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Donations other = (Donations) obj;
        return Objects.equals(id, other.id);
    }
}
