package it.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "fiscalcode")
    private String fiscalcode;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Workgroup workgroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Employee name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Employee surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public Employee fiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
        return this;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public String getPosition() {
        return position;
    }

    public Employee position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Workgroup getWorkgroup() {
        return workgroup;
    }

    public Employee workgroup(Workgroup workgroup) {
        this.workgroup = workgroup;
        return this;
    }

    public void setWorkgroup(Workgroup workgroup) {
        this.workgroup = workgroup;
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
        Employee employee = (Employee) o;
        if (employee.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", fiscalcode='" + getFiscalcode() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }
}
