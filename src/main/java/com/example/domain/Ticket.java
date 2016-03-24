package com.example.domain;


import com.example.domain.enumeration.Status;
import com.example.domain.enumeration.TicketType;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Ticket.
 */
@Entity
@Audited
@Table(name = "ticket")
//TODO all methods that depend only on the data in this object should be put right here in this domain object
public class Ticket extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private long version;

    @NotNull
    @Min(value = 0)
    @Column(name = "price", precision=10, scale=2, nullable = false)
    private BigDecimal price;

    @NotNull
    @Size(min = 2)
    @Column(name = "group_id", nullable = false)
    private String groupId;

    @Column(name = "count")
    private Long count;

    @NotNull
    @Min(value = 0)
    @Column(name = "sold", nullable = false)
    private Long sold;

    @NotNull
    @Min(value = 0)
    @Column(name = "reserved", nullable = false)
    private Long reserved;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(name = "ticket_ticket_route",
               joinColumns = @JoinColumn(name="tickets_id", referencedColumnName="ID"),
               inverseJoinColumns = @JoinColumn(name="ticket_routes_id", referencedColumnName="ID"))
    private Set<Route> ticket_routes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getReserved() {
        return reserved;
    }

    public void setReserved(Long reserved) {
        this.reserved = reserved;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Route> getTicket_routes() {
        return ticket_routes;
    }

    public void setTicket_routes(Set<Route> routes) {
        this.ticket_routes = routes;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "id=" + id +
            ", price='" + price + "'" +
            ", groupId='" + groupId + "'" +
            ", count='" + count + "'" +
            ", sold='" + sold + "'" +
            ", reserved='" + reserved + "'" +
            ", ticketType='" + ticketType + "'" +
            ", status='" + status + "'" +
            '}';
    }
}
