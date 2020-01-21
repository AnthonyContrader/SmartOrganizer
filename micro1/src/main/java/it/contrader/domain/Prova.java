package it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Prova.
 */
@Entity
@Table(name = "prova")
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prova")
    private String prova;

    @Column(name = "name")
    private String name;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProva() {
        return prova;
    }

    public Prova prova(String prova) {
        this.prova = prova;
        return this;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getName() {
        return name;
    }

    public Prova name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
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
        Prova prova = (Prova) o;
        if (prova.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), prova.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Prova{" +
            "id=" + getId() +
            ", prova='" + getProva() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
