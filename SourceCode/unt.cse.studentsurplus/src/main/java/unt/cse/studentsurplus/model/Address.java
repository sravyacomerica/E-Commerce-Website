package unt.cse.studentsurplus.model;

/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 *         Model class for address table
 */
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	int user_id;
	@Column
	Timestamp date_last_modified = new java.sql.Timestamp(new java.util.Date().getTime());;
	@DateTimeFormat
	@Column
	Timestamp date_created = new java.sql.Timestamp(new java.util.Date().getTime());;
	@DateTimeFormat
	@Column
	String date_deleted;
	@Id
	@Column
	int address_id;
	@Column
	String apartment;
	@Column
	String street;
	@Column
	String city;
	@Column
	String state;
	@Column
	String zip_code;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getDate_deleted() {
		return date_deleted;
	}

	public void setDate_deleted(String date_deleted) {
		this.date_deleted = date_deleted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getzip_code() {
		return zip_code;
	}

	public void setzip_code(String zipcode) {
		this.zip_code = zipcode;
	}
}
