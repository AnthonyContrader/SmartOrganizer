package it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Bill.
 */
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer")
    private String customer;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "numberbill")
    private Integer numberbill;

    @Column(name = "price")
    private Float price;

    @OneToOne
    @JoinColumn(unique = true)
    private Location location;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public Bill customer(String customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getData() {
        return data;
    }

    public Bill data(LocalDate data) {
        this.data = data;
        return this;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getNumberbill() {
        return numberbill;
    }

    public Bill numberbill(Integer numberbill) {
        this.numberbill = numberbill;
        return this;
    }

    public void setNumberbill(Integer numberbill) {
        this.numberbill = numberbill;
    }

    public Float getPrice() {
        return price;
    }

    public Bill price(Float price) {
        this.price = price;
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public Bill location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bill bill = (Bill) o;
        if (bill.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bill{" +
            "id=" + getId() +
            ", customer='" + getCustomer() + "'" +
            ", data='" + getData() + "'" +
            ", numberbill=" + getNumberbill() +
            ", price=" + getPrice() +
            "}";
    }
}
