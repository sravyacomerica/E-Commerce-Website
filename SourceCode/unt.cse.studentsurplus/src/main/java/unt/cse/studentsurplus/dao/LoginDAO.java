package unt.cse.studentsurplus.dao;
/**
 * 
 * @author haidi chen 
 *
 */
import unt.cse.studentsurplus.model.LoginCredential;

public interface LoginDAO {

	public LoginCredential getLoginCredential(String email);
}
