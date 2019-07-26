package unt.cse.studentsurplus.model;

/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 * 
 */
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "login_credential")
public class LoginCredential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362161134391583962L;

	@Id
	@Column(name = "credential_id")
	int cid;

	@Column(name = "user_id")
	int uid;

	@Column(name = "login_id")
	String login_id;

	@Column(name = "password")
	String password;

	@Column(name = "role")
	int role;

	@Column(name = "date_created")
	@DateTimeFormat
	Timestamp dateCreated;

	@Column(name = "date_last_modified")
	@DateTimeFormat
	Timestamp dateLastModified;

	@Column(name = "date_deleted")
	@DateTimeFormat
	Timestamp dateDeleted;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Column(unique = true)
	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Timestamp dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public Timestamp getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Timestamp dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public LoginCredential() {
		dateCreated = new java.sql.Timestamp(new java.util.Date().getTime());
		dateLastModified = new java.sql.Timestamp(new java.util.Date().getTime());
	}

	@Override
	public String toString() {
		return "LoginCredential [cid=" + cid + ", uid=" + uid + ", login_id=" + login_id + ", password=" + password
				+ ", role=" + role + ", dateCreated=" + dateCreated + ", dateLastModified=" + dateLastModified
				+ ", dateDeleted=" + dateDeleted + "]";
	}

	@Override
	public boolean equals(Object obj) {
		LoginCredential lc = (LoginCredential) obj;

		if (lc.getCid() == this.getCid()) {
			return true;
		}

		return false;
	}

}
