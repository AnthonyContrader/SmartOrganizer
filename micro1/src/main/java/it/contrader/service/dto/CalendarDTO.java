package it.contrader.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Calendar entity.
 */
public class CalendarDTO implements Serializable {

    private Long id;

    private LocalDate date;

    private String checkin;

    private String checkout;

    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CalendarDTO calendarDTO = (CalendarDTO) o;
        if (calendarDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), calendarDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", checkin='" + getCheckin() + "'" +
            ", checkout='" + getCheckout() + "'" +
            ", employee=" + getEmployeeId() +
            "}";
    }
}
