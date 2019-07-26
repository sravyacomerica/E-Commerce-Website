package unt.cse.studentsurplus.controller;
/**
 * 
 * @author Aboubakar Mountapmbeme
 *              // implements image upload functionality
 *
 */
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	//change to your absolute path
	private final String absolute_path = "C:\\git\\Software-Engineering-Project\\SourceCode\\unt.cse.studentsurplus\\src\\main\\webapp\\resources\\images\\";
	private String real_path;
	
	
	public void uploadPicture(HttpServletRequest request, MultipartFile picture, int user_id) {
	
			real_path = request.getSession().getServletContext().getRealPath("/resources/images");
			
			if(!new File(absolute_path).exists()) {
				new File(absolute_path).mkdirs();
			}
			
			if(!new File(real_path).exists()) {
				new File(real_path).mkdirs();
			}
			
			try {
				
				//picture.transferTo(new File(real_path + user_id + ".jpg"));
				
				picture.transferTo(new File(absolute_path + user_id + ".jpg"));
				System.out.println("DASH:uplaod called");

			}
			catch(IOException ex) {
				System.out.println("DASH: error uploading image");
			}
	
	}
	
	
	public boolean uploadProductPicture(HttpServletRequest request,
			MultipartFile picture, String pictureName) {
		
		real_path = request.getSession().getServletContext().getRealPath("/resources/images");
		
		if(!new File(absolute_path).exists()) {
			new File(absolute_path).mkdirs();
		}
		
		if(!new File(real_path).exists()) {
			new File(real_path).mkdirs();
		}
		
		try {
			
			//picture.transferTo(new File(real_path + pictureName + ".jpg"));
			
			picture.transferTo(new File(absolute_path + pictureName + ".jpg"));
			System.out.println("DASH:uplaod productImage called");

		}
		catch(IOException ex) {
			System.out.println("DASH: error uploading product image");
			
			return false;
		}
		
		return true;
	}
}