package com.example.domain;



import com.example.domain.enumeration.Status;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Terminal.
 */
@Entity
@Audited
@Table(name = "terminal")
public class Terminal extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "area", length = 60, nullable = false)
    private String area;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        Terminal terminal = (Terminal) o;
        return Objects.equals(id, terminal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Terminal{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", area='" + area + "'" +
            ", status='" + status + "'" +
            '}';
    }
}
