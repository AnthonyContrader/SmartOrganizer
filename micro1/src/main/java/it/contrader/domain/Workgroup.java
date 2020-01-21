package it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Workgroup.
 */
@Entity
@Table(name = "workgroup")
public class Workgroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "members")
    private String members;

    @Column(name = "responsible")
    private String responsible;

    @Column(name = "jhi_work")
    private String work;

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

    public Workgroup name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public Workgroup members(String members) {
        this.members = members;
        return this;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getResponsible() {
        return responsible;
    }

    public Workgroup responsible(String responsible) {
        this.responsible = responsible;
        return this;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getWork() {
        return work;
    }

    public Workgroup work(String work) {
        this.work = work;
        return this;
    }

    public void setWork(String work) {
        this.work = work;
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
        Workgroup workgroup = (Workgroup) o;
        if (workgroup.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), workgroup.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Workgroup{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", members='" + getMembers() + "'" +
            ", responsible='" + getResponsible() + "'" +
            ", work='" + getWork() + "'" +
            "}";
    }
}
