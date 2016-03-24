package com.example.domain;


import com.example.domain.enumeration.IdType;
import com.example.domain.enumeration.Gender;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Customer.
 */
@Entity
@Audited
@Table(name = "customer")
public class Customer extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "id_type", nullable = false)
    private IdType idType;

    @Column(name = "tele")
    private Long tele;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "id_no")
    private Long idNo;

    @NotNull
    //@Past
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public Long getTele() {
        return tele;
    }

    public void setTele(Long tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + id +
            ", firstName='" + firstName + "'" +
            ", lastName='" + lastName + "'" +
            ", idType='" + idType + "'" +
            ", tele='" + tele + "'" +
            ", email='" + email + "'" +
            ", idNo='" + idNo + "'" +
            ", dateOfBirth='" + dateOfBirth + "'" +
            ", gender='" + gender + "'" +
            '}';
    }
}
