package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Workgroup entity.
 */
public class WorkgroupDTO implements Serializable {

    private Long id;

    private String name;

    private String members;

    private String responsible;

    private String work;

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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkgroupDTO workgroupDTO = (WorkgroupDTO) o;
        if (workgroupDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), workgroupDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WorkgroupDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", members='" + getMembers() + "'" +
            ", responsible='" + getResponsible() + "'" +
            ", work='" + getWork() + "'" +
            "}";
    }
}
