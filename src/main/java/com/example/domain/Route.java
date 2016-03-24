package com.example.domain;



import com.example.domain.enumeration.Status;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Route.
 */
@Entity
@Audited
@Table(name = "route")
public class Route extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "business_id")
    private String businessId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "end_terminal_id")
    private Terminal endTerminal;

    @ManyToOne
    @JoinColumn(name = "start_terminal_id")
    private Terminal startTerminal;

    @ManyToMany
    @JoinTable(name = "route_intermediate_terminal",
               joinColumns = @JoinColumn(name="routes_id", referencedColumnName="ID"),
               inverseJoinColumns = @JoinColumn(name="intermediate_terminals_id", referencedColumnName="ID"))
    private Set<Terminal> intermediateTerminals = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Terminal getEndTerminal() {
        return endTerminal;
    }

    public void setEndTerminal(Terminal terminal) {
        this.endTerminal = terminal;
    }

    public Terminal getStartTerminal() {
        return startTerminal;
    }

    public void setStartTerminal(Terminal terminal) {
        this.startTerminal = terminal;
    }

    public Set<Terminal> getIntermediateTerminals() {
        return intermediateTerminals;
    }

    public void setIntermediateTerminals(Set<Terminal> terminals) {
        this.intermediateTerminals = terminals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Route{" +
            "id=" + id +
            ", businessId='" + businessId + "'" +
            ", status='" + status + "'" +
            '}';
    }
}
