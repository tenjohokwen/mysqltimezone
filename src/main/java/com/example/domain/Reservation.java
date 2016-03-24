package com.example.domain;


import com.example.domain.enumeration.ReservationStatus;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Reservation.
 */
@Entity
@Audited
@Table(name = "reservation")
public class Reservation extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @NotNull
    @Column(name = "txn_id", nullable = false)
    private String txnId;

    @NotNull
    @Column(name = "time_to_reserve", nullable = false)
    private Integer timeToReserve;

    @NotNull
    @Min(value = 0)
    @Column(name = "ticket_price", precision=10, scale=2, nullable = false)
    private BigDecimal ticketPrice;

    @NotNull
    @Column(name = "travel_date", nullable = false)
    private ZonedDateTime travelDate;

    @Lob
    @Column(name = "qr_code")
    private byte[] qrCode;

    @Column(name = "qr_code_content_type")        private String qrCodeContentType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "ticket_order_id")
    private TicketOrder ticketOrder;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public Integer getTimeToReserve() {
        return timeToReserve;
    }

    public void setTimeToReserve(Integer timeToReserve) {
        this.timeToReserve = timeToReserve;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ZonedDateTime getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(ZonedDateTime travelDate) {
        this.travelDate = travelDate;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCodeContentType() {
        return qrCodeContentType;
    }

    public void setQrCodeContentType(String qrCodeContentType) {
        this.qrCodeContentType = qrCodeContentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketOrder getTicketOrder() {
        return ticketOrder;
    }

    public void setTicketOrder(TicketOrder ticketOrder) {
        this.ticketOrder = ticketOrder;
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
        Reservation reservation = (Reservation) o;
        return Objects.equals(id, reservation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "id=" + id +
            ", reservationStatus='" + reservationStatus + "'" +
            ", txnId='" + txnId + "'" +
            ", timeToReserve='" + timeToReserve + "'" +
            ", ticketPrice='" + ticketPrice + "'" +
            ", travelDate='" + travelDate + "'" +
            ", qrCode='" + qrCode + "'" +
            ", qrCodeContentType='" + qrCodeContentType + "'" +
            '}';
    }
}
