package it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Location.
 */
@Entity
@Table(name = "location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "typeoflocation")
    private String typeoflocation;

    @Column(name = "worktype")
    private String worktype;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public Location address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public Location city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTypeoflocation() {
        return typeoflocation;
    }

    public Location typeoflocation(String typeoflocation) {
        this.typeoflocation = typeoflocation;
        return this;
    }

    public void setTypeoflocation(String typeoflocation) {
        this.typeoflocation = typeoflocation;
    }

    public String getWorktype() {
        return worktype;
    }

    public Location worktype(String worktype) {
        this.worktype = worktype;
        return this;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
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
        Location location = (Location) o;
        if (location.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), location.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Location{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", typeoflocation='" + getTypeoflocation() + "'" +
            ", worktype='" + getWorktype() + "'" +
            "}";
    }
}
