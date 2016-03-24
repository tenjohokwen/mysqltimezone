package com.example.domain;


import com.example.domain.enumeration.OrderStatus;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A TicketOrder.
 */
@Entity
@Audited
@Table(name = "ticket_order")
public class TicketOrder extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "agent_id")
    private String agentId;

    @NotNull
    @Column(name = "payment_deadline", nullable = false)
    private LocalDateTime paymentDeadline;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "item_count")
    private Integer itemCount;

    @NotNull
    @Min(value = 0)
    @Column(name = "total_amount", precision=10, scale=2, nullable = false)
    private BigDecimal totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public LocalDateTime getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDateTime paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketOrder ticketOrder = (TicketOrder) o;
        return Objects.equals(id, ticketOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TicketOrder{" +
            "id=" + id +
            ", orderStatus='" + orderStatus + "'" +
            ", agentId='" + agentId + "'" +
            ", paymentDeadline='" + paymentDeadline + "'" +
            ", purchaseDate='" + purchaseDate + "'" +
            ", itemCount='" + itemCount + "'" +
            ", totalAmount='" + totalAmount + "'" +
            '}';
    }
}
