package com.example.domain;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	Integer postId;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="POST_DATE")
	Date postDate;

    @Column(name="VALID_DATE")
    ZonedDateTime validDate;

    @Column(name="EXPIRY_DATE")
    LocalDateTime expiryDate;

    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime", parameters = { @Parameter(name = "databaseZone", value = "America/New_York"),
            @Parameter(name = "javaZone", value = "America/New_York")})
    ZonedDateTime modifiedDate;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

    public ZonedDateTime getValidDate() {
        return validDate;
    }

    public void setValidDate(ZonedDateTime validDate) {
        this.validDate = validDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
