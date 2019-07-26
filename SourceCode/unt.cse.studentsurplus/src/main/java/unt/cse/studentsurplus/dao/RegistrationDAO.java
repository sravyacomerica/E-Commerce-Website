package unt.cse.studentsurplus.dao;
import unt.cse.studentsurplus.model.Address;
import unt.cse.studentsurplus.model.LoginCredential;
import unt.cse.studentsurplus.model.User;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Interface for registration
 *
 */
public interface RegistrationDAO {

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
	public void getLogin_id(String email, String Password);
	
	//get address of a particular user
	public Address getAddressofUser(int userId);
	User getByEmail(String email);

	
}
