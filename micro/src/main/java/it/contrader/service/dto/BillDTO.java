package it.contrader.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Bill entity.
 */
public class BillDTO implements Serializable {

    private Long id;

    private String customer;

    private LocalDate date;

    private Integer numberbill;

    private Float price;

    private Long locationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNumberbill() {
        return numberbill;
    }

    public void setNumberbill(Integer numberbill) {
        this.numberbill = numberbill;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BillDTO billDTO = (BillDTO) o;
        if (billDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), billDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BillDTO{" +
            "id=" + getId() +
            ", customer='" + getCustomer() + "'" +
            ", date='" + getDate() + "'" +
            ", numberbill=" + getNumberbill() +
            ", price=" + getPrice() +
            ", location=" + getLocationId() +
            "}";
    }
}
