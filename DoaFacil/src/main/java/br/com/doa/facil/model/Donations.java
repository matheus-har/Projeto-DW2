package br.com.doa.facil.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @OneToOne
    @JoinColumn(name = "product_Id", referencedColumnName = "id")
    private Products product_Id;

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

    
    public Products getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(Products product_Id) {
		this.product_Id = product_Id;
	}

	public void setRecipient(Users recipient) {
		this.recipient = recipient;
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
