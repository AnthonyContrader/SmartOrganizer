package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Prova entity.
 */
public class ProvaDTO implements Serializable {

    private Long id;

    private String prova;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProvaDTO provaDTO = (ProvaDTO) o;
        if (provaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), provaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProvaDTO{" +
            "id=" + getId() +
            ", prova='" + getProva() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
