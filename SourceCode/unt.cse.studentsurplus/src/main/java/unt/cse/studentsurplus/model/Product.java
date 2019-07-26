/**
 * 
 */
package unt.cse.studentsurplus.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Aboubakar Mountapmbeme Maps data of a product to the database table
 *         product
 */

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "negotiable")
	private String negotiable;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "description")
	private String description;

	@Column(name = "isAvailable")
	private int isAvailable;

	@Column(name = "months_used")
	private int monthsUsed;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "date_last_modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastModified;

	@Column(name = "date_deleted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeleted;

	@Transient
	private MultipartFile picture;

	@Transient
	private String imageName;

	public Product() {
		this.dateCreated = new Date();
		this.dateLastModified = new Date();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public String getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(String negotiable) {
		this.negotiable = negotiable;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getMonthsUsed() {
		return monthsUsed;
	}

	public void setMonthsUsed(int monthsUsed) {
		this.monthsUsed = monthsUsed;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	@Transient
	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", negotiable="
				+ negotiable + ", price=" + price + ", description=" + description + ", isAvailable=" + isAvailable
				+ ", monthsUsed=" + monthsUsed + ", userId=" + userId + ", dateCreated=" + dateCreated
				+ ", dateLastModified=" + dateLastModified + ", dateDeleted=" + dateDeleted + ", picture=" + picture
				+ ", imageName=" + imageName + "]";
	}

}
