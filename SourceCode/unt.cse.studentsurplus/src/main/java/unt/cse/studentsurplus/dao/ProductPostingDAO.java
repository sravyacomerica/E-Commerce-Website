/**
 * 
 */
package unt.cse.studentsurplus.dao;

import java.util.List;

import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;
import unt.cse.studentsurplus.model.User;

/**
 * @author Aboubakar Mountapmbeme provides interface for saving and retrieving
 *         products from DB
 */
public interface ProductPostingDAO {

	public boolean addProduct(Product pdt);

	public List<Product> getAvailableProducts();

	public Product getProduct(int productId);

	public List<Product> getAvailableProductsByOwner(int owner);

	public List<ProductImage> getProductImages(int pid);

	public boolean addProductImage(ProductImage img);

	public List<Product> getSoldProductsByOwner(int owner);

	public List<Product> getAllProductsByOwner(int owner);

	public List<Product> getProductsBySearchString(String search);

}
