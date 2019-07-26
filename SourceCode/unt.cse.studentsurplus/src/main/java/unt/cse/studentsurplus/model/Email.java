package unt.cse.studentsurplus.model;

/**
 * @author Sri Sravya Tirupachur Comerica
 * 
 *
 *         
 */
import javax.enterprise.inject.Model;

@Model
public class Email {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
