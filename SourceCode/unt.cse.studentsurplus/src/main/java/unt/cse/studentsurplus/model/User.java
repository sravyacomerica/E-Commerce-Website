package unt.cse.studentsurplus.model;

/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 *   */
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "user")
public class User {

	int user_id;
	@Column
	String first_name;
	@Column
	String middle_name;
	@Column
	String last_name;
	@Column
	String phone_number;
	@Column
	String email;
	@DateTimeFormat
	@Column
	java.sql.Timestamp date_last_modified = new java.sql.Timestamp(new java.util.Date().getTime());
	@DateTimeFormat
	@Column
	java.sql.Timestamp date_created = new java.sql.Timestamp(new java.util.Date().getTime());
	@DateTimeFormat
	@Column
	Date date_deleted;

	private MultipartFile picture;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDate_last_modified() {
		return date_last_modified;
	}

	public void setDate_last_modified(Timestamp date_last_modified) {
		this.date_last_modified = date_last_modified;
	}

	public Timestamp getDate_created() {
		return date_created;
	}

	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}

	public Date getDate_deleted() {
		return date_deleted;
	}

	public void setDate_deleted(Date date_deleted) {
		this.date_deleted = date_deleted;
	}

	@Transient
	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

}
