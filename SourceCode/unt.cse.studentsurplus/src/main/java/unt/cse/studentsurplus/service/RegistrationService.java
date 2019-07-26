package unt.cse.studentsurplus.service;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Interface for registration service
 *
 */
import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;

public interface RegistrationService {

	public boolean add(User user);
	public User edit(User user);
	public void delete(int user_id);
	public User getUser(int user_id);
	public boolean addLogin_Cred(LoginCredential login);
	public void editLogin_Cred(LoginCredential login);
	public void deleteLogin_Cred(int credential_id);
	public LoginCredential getLoginId(int credential_id);
	public boolean addAddress(Address address);
	public Address editAddress(Address address);
	public void deleteAddress(int address_id);
	public Address getAddress(int address_id);
	public User getByEmail(String email);
	public Address getAddressofUser(int userId);
	
}
