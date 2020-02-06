package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Tool entity.
 */
public class ToolDTO implements Serializable {

    private Long id;

    private String toolname;

    private String rawmaterial;

    private Integer lifetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getRawmaterial() {
        return rawmaterial;
    }

    public void setRawmaterial(String rawmaterial) {
        this.rawmaterial = rawmaterial;
    }

    public Integer getLifetime() {
        return lifetime;
    }

    public void setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ToolDTO toolDTO = (ToolDTO) o;
        if (toolDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), toolDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ToolDTO{" +
            "id=" + getId() +
            ", toolname='" + getToolname() + "'" +
            ", rawmaterial='" + getRawmaterial() + "'" +
            ", lifetime=" + getLifetime() +
            "}";
    }
}
