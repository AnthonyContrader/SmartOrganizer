package it.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Tool.
 */
@Entity
@Table(name = "tool")
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "toolname")
    private String toolname;

    @Column(name = "rawmaterial")
    private String rawmaterial;

    @Column(name = "lifetime")
    private Integer lifetime;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolname() {
        return toolname;
    }

    public Tool toolname(String toolname) {
        this.toolname = toolname;
        return this;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getRawmaterial() {
        return rawmaterial;
    }

    public Tool rawmaterial(String rawmaterial) {
        this.rawmaterial = rawmaterial;
        return this;
    }

    public void setRawmaterial(String rawmaterial) {
        this.rawmaterial = rawmaterial;
    }

    public Integer getLifetime() {
        return lifetime;
    }

    public Tool lifetime(Integer lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public void setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Tool employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        Tool tool = (Tool) o;
        if (tool.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tool.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tool{" +
            "id=" + getId() +
            ", toolname='" + getToolname() + "'" +
            ", rawmaterial='" + getRawmaterial() + "'" +
            ", lifetime=" + getLifetime() +
            "}";
    }
}
