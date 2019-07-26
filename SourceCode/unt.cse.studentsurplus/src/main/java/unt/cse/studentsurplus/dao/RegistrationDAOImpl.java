package unt.cse.studentsurplus.dao;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Implementation for registration
 *
 */
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;
/**
 * @author Sri Sravya Tirupachur Comerica
 * Date: 10/21/2018
 *
 *         Implements the methods for saving and retrieving users from the DB
 */
@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public boolean add(User user) {
		try {
			session.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User edit(User user) {
		Query query = session.getCurrentSession().createQuery(
				"UPDATE User SET first_name=:first_name, middle_name= :middle_name, last_name= :last_name, email = :email, phone_number= :phone_number  WHERE user_id= :user_id");
		query.setParameter("first_name", user.getFirst_name());
		query.setParameter("middle_name", user.getMiddle_name());
		query.setParameter("last_name", user.getLast_name());
		query.setParameter("email", user.getEmail());
		query.setParameter("phone_number", user.getPhone_number());
		query.setParameter("user_id", user.getUser_id());
		try {
			int result = query.executeUpdate();
		} catch (Exception e) {
			System.out.println("hello");
		}
		return user;

	}

	@Override
	public void delete(int user_id) {
		session.getCurrentSession().delete(getUser(user_id));

	}

	@Override
	public User getUser(int user_id) {

		Session currentSession = session.getCurrentSession();
		Query qry = currentSession.createQuery("from User where user_id=:userId");
		qry.setParameter("userId", user_id);
		return (User) qry.getSingleResult();


	}

	@Override
	public User getByEmail(String email) {
		Query query = session.getCurrentSession().createQuery("from User where email= :email");
		query.setParameter("email", email);
		return (User) query.getSingleResult();

	}

	@Override
	public boolean addLogin_Cred(LoginCredential login) {
		String hashedPassword = DigestUtils.sha256Hex(login.getPassword());
		login.setPassword(hashedPassword);
		session.getCurrentSession().save(login);
		return true;
	}

	@Override
	public void editLogin_Cred(LoginCredential login) {
		session.getCurrentSession().update(login);

	}

	@Override
	public void deleteLogin_Cred(int credential_id) {
		session.getCurrentSession().delete(getLoginId(credential_id));

	}

	@Override
	public LoginCredential getLoginId(int credential_id) {

		return (LoginCredential) session.getCurrentSession().get(LoginCredential.class, credential_id);

	}

	@Override
	public boolean addAddress(Address address) {
		session.getCurrentSession().save(address);
		return true;

	}

	@Override
	public Address editAddress(Address address) {
		Query query = session.getCurrentSession().createQuery(
				"UPDATE Address SET street=:street, apartment= :apartment, city= :city, zip_code = :zipcode, state= :state  WHERE user_id= :user_id");
		query.setParameter("street", address.getStreet());
		query.setParameter("apartment", address.getApartment());
		query.setParameter("city", address.getCity());
		query.setParameter("zipcode", address.getzip_code());
		query.setParameter("state", address.getState());
		query.setParameter("user_id", address.getUser_id());
		try {
			int result = query.executeUpdate();
		} catch (Exception e) {
			System.out.println("hello");
		}
		return address;

	}

	@Override
	public void deleteAddress(int address_id) {
		session.getCurrentSession().delete(getLoginId(address_id));

	}

	@Override
	public Address getAddress(int address_id) {
		return (Address) session.getCurrentSession().get(Address.class, address_id);
	}

	@Override
	public void getLogin_id(String email, String Password) {

	}

	@Override
	public Address getAddressofUser(int userId) {

		Session currentSession = session.getCurrentSession();
		Query qry = currentSession.createQuery("from Address where user_id=:userId");
		qry.setParameter("userId", userId);
		return (Address) qry.getSingleResult();

	}
}
