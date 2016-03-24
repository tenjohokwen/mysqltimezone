package com.example.domain;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A MessageTranslation.
 */
@Entity
@Audited
@Table(name = "message_translation")
public class MessageTranslation extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(name = "language_code", length = 2, nullable = false)
    private String languageCode;

    @NotNull
    @Size(min = 2)
    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageTranslation messageTranslation = (MessageTranslation) o;
        return Objects.equals(id, messageTranslation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MessageTranslation{" +
            "id=" + id +
            ", languageCode='" + languageCode + "'" +
            ", text='" + text + "'" +
            '}';
    }
}
