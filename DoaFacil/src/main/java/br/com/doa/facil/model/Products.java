package br.com.doa.facil.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private Integer amount;

    @NotNull
    @Column(name = "validity")
    @JsonFormat(pattern =  "dd/MM/yyyy")
    private LocalDate validity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeProduct type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ConservationStatus conservation;

	@NotNull
    private Double size;
	
	@NotNull
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }
    
    public ConservationStatus getConservation() {
		return conservation;
	}

	public void setConservation(ConservationStatus conservation) {
		this.conservation = conservation;
	}
    
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
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
        Products other = (Products) obj;
        return Objects.equals(id, other.id);
    }
}
