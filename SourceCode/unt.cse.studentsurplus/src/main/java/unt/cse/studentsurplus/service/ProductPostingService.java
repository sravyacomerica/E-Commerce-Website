package unt.cse.studentsurplus.service;

import java.util.List;

import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;

/**
 * @author Aboubakar Mountapmbeme provides interface for communication with DAO
 *         objects
 */

public interface ProductPostingService {

	public boolean addProduct(Product pdt);

	public List<Product> getAvailableProducts();

	public Product getProduct(int productId);

	public List<Product> getAvailableProductsByOwner(int owner);

	public List<ProductImage> getProductImages(int pid);

	public boolean addProductImage(ProductImage img);

	public List<Product> getSoldProductsByOwner(int owner);

	public List<Product> getAllProductsByOwner(int owner);

	public List<Product> getProductsBySearchString(String search);

	public List<Product> setProductsImage(List<Product> products);

	public Product setProductImageName(Product pdt);

}
