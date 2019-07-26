package unt.cse.studentsurplus.service;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Implementation of registration service 
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unt.cse.studentsurplus.dao.RegistrationDAO;
import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDAO registrationDAO;
	
	@Transactional
	public boolean addLogin_Cred(LoginCredential login) {
		registrationDAO.addLogin_Cred(login);
		return true;
	}

	@Transactional
	public void editLogin_Cred(LoginCredential login) {
		registrationDAO.editLogin_Cred(login);

	}

	@Transactional
	public void deleteLogin_Cred(int credential_id) {
		registrationDAO.deleteLogin_Cred(credential_id);

	}

	@Transactional
	public LoginCredential getLoginId(int credential_id) {
		// TODO Auto-generated method stub
		return registrationDAO.getLoginId(credential_id);
	}


	@Transactional
	public boolean add(User user) {
		boolean result = registrationDAO.add(user);
		return result;

	}

	@Transactional
	public User edit(User user) {
		return registrationDAO.edit(user);

	}

	@Transactional
	public void delete(int user_id) {
		registrationDAO.delete(user_id);

	}

	@Transactional
	public User getUser(int user_id) {
		return registrationDAO.getUser(user_id);
	}

	@Transactional
	public boolean addAddress(Address address) {
		registrationDAO.addAddress(address);
		return true;
	}

	@Transactional
	public Address editAddress(Address address) {
		return registrationDAO.editAddress(address);
		
	}

	@Transactional
	public void deleteAddress(int address_id) {
		registrationDAO.deleteAddress(address_id);
		
	}

	@Transactional
	public Address getAddress(int address_id) {
		return registrationDAO.getAddress(address_id);
	}
	
	@Transactional
	public Address getAddressofUser(int userId) {
		
		return registrationDAO.getAddressofUser(userId);
	}

    @Transactional
	public User getByEmail(String email) {
		
		return registrationDAO.getByEmail(email);
	}

}
