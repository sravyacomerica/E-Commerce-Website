/**
 * 
 */
package unt.cse.studentsurplus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unt.cse.studentsurplus.model.Product;
import unt.cse.studentsurplus.model.ProductImage;
import unt.cse.studentsurplus.model.User;

/**
 * @author Aboubakar Mountapmbeme
 *
 *         Implements the methods for saving and retrieving products from the DB
 */

@Repository
public class ProductPostingDAOImpl implements ProductPostingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.dao.ProductPostingDAO#addProduct(unt.cse.
	 * studentsurplus.model.Product)
	 */
	@Override
	public boolean addProduct(Product pdt) {

		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(pdt);
		} catch (Exception e) {

			System.out.println("DASH: error saving product \n");
			// e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean addProductImage(ProductImage img) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(img);
		} catch (Exception e) {

			System.out.println("DASH: error saving product image \n");
			e.printStackTrace();

			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.dao.ProductPostingDAO#getAvailableProducts()
	 */
	@Override
	public List<Product> getAvailableProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList();

		Query<Product> qry = session.createQuery("from Product where isAvailable=1 order by dateCreated desc",
				Product.class);

		try {
			products = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting list of available products");
			e.printStackTrace();
			return null;
		}
		return products;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unt.cse.studentsurplus.dao.ProductPostingDAO#getProduct(int)
	 */
	@Override
	public Product getProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();

		Product pdt = new Product();

		try {

			pdt = session.get(Product.class, productId);
		} catch (Exception e) {
			System.out.println("DASH: Error getting a product");
			e.printStackTrace();
			return null;
		}
		return pdt;
	}

	@Override
	public List<Product> getAvailableProductsByOwner(int owner) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList();

		Query<Product> qry = session.createQuery(
				"from Product where isAvailable=1 and userId=:uid order by dateCreated desc", Product.class);

		qry.setParameter("uid", owner);
		try {
			products = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting list of available products by owner");
			e.printStackTrace();
			return null;
		}
		return products;
	}

	@Override
	public List<ProductImage> getProductImages(int pid) {
		Session session = sessionFactory.getCurrentSession();
		List<ProductImage> images = new ArrayList();

		Query<ProductImage> qry = session.createQuery("from ProductImage where productId=:prodId", ProductImage.class);

		qry.setParameter("prodId", pid);
		try {
			images = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting product images");
			e.printStackTrace();
			return null;
		}
		return images;
	}

	@Override
	public List<Product> getSoldProductsByOwner(int owner) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList();

		Query<Product> qry = session.createQuery(
				"from Product where isAvailable=0 and userId=:uid order by dateCreated desc", Product.class);

		qry.setParameter("uid", owner);
		try {
			products = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting list of sold products by owner");
			e.printStackTrace();
			return null;
		}
		return products;
	}

	@Override
	public List<Product> getAllProductsByOwner(int owner) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList();

		Query<Product> qry = session.createQuery("from Product where userId=:uid order by dateCreated desc",
				Product.class);

		qry.setParameter("uid", owner);
		try {
			products = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting list of all products by owner");
			e.printStackTrace();
			return null;
		}
		return products;
	}

	public List<Product> getProductsBySearchString(String search) {

		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList();

		Query<Product> qry = session.createQuery("FROM Product p WHERE p.isAvailable=1 AND"
				+ " (p.category LIKE :searchString OR p.description LIKE :searchString) order by dateCreated desc",
				Product.class);

		qry.setParameter("searchString", "%" + search + "%");
		try {
			products = qry.getResultList();
		} catch (Exception e) {
			System.out.println("DASH: Error getting list of search products");
			e.printStackTrace();
			return null;
		}

		return products;

	}

}
