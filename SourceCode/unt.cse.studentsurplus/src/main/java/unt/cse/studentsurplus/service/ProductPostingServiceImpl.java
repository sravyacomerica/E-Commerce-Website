/**
 * 
 */
package unt.cse.studentsurplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unt.cse.studentsurplus.dao.ProductPostingDAO;
import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;

/**
 * @author Aboubakar Mountapmbeme implements interface for communication with
 *         DAO objects
 * 
 */

@Service
public class ProductPostingServiceImpl implements ProductPostingService {

	@Autowired
	private ProductPostingDAO productPostingDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.service.ProductPostingService#addProduct(unt.cse.
	 * studentsurplus.model.Product)
	 */
	@Override
	@Transactional
	public boolean addProduct(Product pdt) {
		System.out.println("DASH: function does not return \n");
		return productPostingDAO.addProduct(pdt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * unt.cse.studentsurplus.service.ProductPostingService#getAvailableProducts()
	 */
	@Override
	@Transactional
	public List<Product> getAvailableProducts() {
		List<Product> availableProducts = productPostingDAO.getAvailableProducts();

		return this.setProductsImage(availableProducts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.service.ProductPostingService#getProduct(int)
	 */
	@Override
	@Transactional
	public Product getProduct(int productId) {

		Product prod = productPostingDAO.getProduct(productId);
		return this.setProductImageName(prod);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.service.ProductPostingService#
	 * getAvailableProductsByOwner(int)
	 */
	@Override
	@Transactional
	public List<Product> getAvailableProductsByOwner(int owner) {
		return this.setProductsImage(productPostingDAO.getAvailableProductsByOwner(owner));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * unt.cse.studentsurplus.service.ProductPostingService#getProductImages(int)
	 */
	@Override
	@Transactional
	public List<ProductImage> getProductImages(int pid) {
		return productPostingDAO.getProductImages(pid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * unt.cse.studentsurplus.service.ProductPostingService#addProductImage(unt.cse.
	 * studentsurplus.model.ProductImage)
	 */
	@Override
	@Transactional
	public boolean addProductImage(ProductImage img) {
		return productPostingDAO.addProductImage(img);
	}

	@Override
	@Transactional
	public List<Product> getSoldProductsByOwner(int owner) {
		List<Product> availableProducts = productPostingDAO.getSoldProductsByOwner(owner);

		return this.setProductsImage(availableProducts);
	}

	@Override
	@Transactional
	public List<Product> getAllProductsByOwner(int owner) {
		List<Product> availableProducts = productPostingDAO.getAllProductsByOwner(owner);

		return this.setProductsImage(availableProducts);
	}

	@Override
	@Transactional
	public List<Product> getProductsBySearchString(String search) {
		List<Product> availableProducts = productPostingDAO.getProductsBySearchString(search);

		return this.setProductsImage(availableProducts);
	}

	/*
	 * Helper function to attache images to each product in the list of products
	 * (non-Javadoc)
	 * 
	 * @see
	 * unt.cse.studentsurplus.service.ProductPostingService#setProductsImage(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public List<Product> setProductsImage(List<Product> products) {
		List<Product> availableProducts = products;

		for (Product prod : availableProducts) {
			List<ProductImage> imgList = productPostingDAO.getProductImages(prod.getProductId());

			if (imgList.isEmpty() || imgList == null) {
				prod.setImageName("default.jpg");
			} else {
				prod.setImageName(imgList.get(0).getImageName() + ".jpg");
			}
		}

		return availableProducts;
	}

	/**
	 * sets the imageName for a product
	 */
	@Override
	@Transactional
	public Product setProductImageName(Product prod) {
		List<ProductImage> imgList = productPostingDAO.getProductImages(prod.getProductId());

		if (imgList.isEmpty() || imgList == null) {
			prod.setImageName("default.jpg");
		} else {
			prod.setImageName(imgList.get(0).getImageName() + ".jpg");
		}

		return prod;
	}

}
