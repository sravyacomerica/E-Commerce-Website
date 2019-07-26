package unt.cse.studentsurplus.model;
/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 * 
 */
import javax.enterprise.inject.Model;

@Model
public class Search {

	String searchString;
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

}
