package com.example.domain;

import com.example.domain.enumeration.Status;
import com.example.domain.enumeration.VehicleType;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Agency.
 */
@Entity
@Audited
@Table(name = "agency")
public class Agency extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "name", length = 60, nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "headquarters", length = 60, nullable = false)
    private String headquarters;

    @NotNull
    @Min(value = 2)
    @Max(value = 100)
    @Column(name = "cutoff_time", nullable = false)
    private Integer cutoffTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType;

    @NotNull
    @Size(min = 6, max = 255)
    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "tele")
    private Long tele;

    @Size(min = 2, max = 60)
    @Column(name = "contact_person", length = 60)
    private String contactPerson;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

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

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Integer getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Integer cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTele() {
        return tele;
    }

    public void setTele(Long tele) {
        this.tele = tele;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agency agency = (Agency) o;
        return Objects.equals(id, agency.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Agency{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", headquarters='" + headquarters + "'" +
            ", cutoffTime='" + cutoffTime + "'" +
            ", vehicleType='" + vehicleType + "'" +
            ", email='" + email + "'" +
            ", tele='" + tele + "'" +
            ", contactPerson='" + contactPerson + "'" +
            ", status='" + status + "'" +
            '}';
    }
}
