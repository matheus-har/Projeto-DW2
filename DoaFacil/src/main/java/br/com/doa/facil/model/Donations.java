package br.com.doa.facil.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @JoinColumn(name = "donor_Id", referencedColumnName = "id")
    private Users donor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "recipient_Id", referencedColumnName = "id")
    private Users recipient;

    @NotNull
    @JsonFormat(pattern =  "dd/MM/yyyy")
    private LocalDate date;

    @NotNull
    private Long product_Id;

    @Size(max = 70)
    @Column(name = "pickup_Location")
    private String pickup_Location;
    
    @NotNull
    private Boolean active;

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

    public void setRecipient_Id(Users recipient) {
        this.recipient = recipient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Long product_Id) {
        this.product_Id = product_Id;
    }

    public String getPickup_Location() {
        return pickup_Location;
    }

    public void setPickup_Location(String pickup_Location) {
        this.pickup_Location = pickup_Location;
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
        Donations other = (Donations) obj;
        return Objects.equals(id, other.id);
    }
}
