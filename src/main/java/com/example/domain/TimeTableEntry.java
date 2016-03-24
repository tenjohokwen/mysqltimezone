package com.example.domain;



import com.example.domain.enumeration.Status;
import com.example.domain.enumeration.WeekDay;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TimeTableEntry.
 */
@Entity
@Audited
@Table(name = "time_table_entry")
public class TimeTableEntry extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Min(value = 0)
    @Max(value = 1439)
    @Column(name = "departure_time", nullable = false)
    private Integer departureTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "week_day", nullable = false)
    private WeekDay weekDay;

    @NotNull
    @Column(name = "guaranteed_dep_time", nullable = false)
    private Boolean guaranteedDepTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    @Column(name = "duration", nullable = false)
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Boolean getGuaranteedDepTime() {
        return guaranteedDepTime;
    }

    public void setGuaranteedDepTime(Boolean guaranteedDepTime) {
        this.guaranteedDepTime = guaranteedDepTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimeTableEntry timeTableEntry = (TimeTableEntry) o;
        return Objects.equals(id, timeTableEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TimeTableEntry{" +
            "id=" + id +
            ", departureTime='" + departureTime + "'" +
            ", weekDay='" + weekDay + "'" +
            ", guaranteedDepTime='" + guaranteedDepTime + "'" +
            ", status='" + status + "'" +
            ", duration='" + duration + "'" +
            '}';
    }
}
