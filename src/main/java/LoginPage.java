import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LoginPage {

	private Map<String, String> db;
	
	public LoginPage(){
		
		db = new HashMap<>();
		
		db.put("admin@gmail.com", "12345");
				
		db.put("user1@gmail.com", "123456");
		
		db.put("user2@gmail.com","1234567");
		
		
	}
	
	
	public void forgotPassword(String email) {
		
		if(isValidEmailId(email) && db.containsKey(email)) {
			System.out.println("Email sent to : "+email);
		}
		else if(!isValidEmailId(email)) {
			System.out.println("Invalid Email Id it is!");
		
		}else {
			System.out.println("Email Id not registered!");
		}
		
		
		
	}
	
	
	public boolean isValidEmailId(String email) {
		try {
			InternetAddress emailAddress = new InternetAddress(email);
			emailAddress.validate();
			return true;
		}catch(AddressException ex) {
			return false;
		}
	}
	
	
	public boolean login(String email, String password) {
		
		if(db.containsKey(email) && db.get(email).equals(password)) {
//			System.out.println("Logged in");
			return true;
		}else {
//			System.out.println("Invalid Email or Password!!");
			return false;
		}
		
	}


	
	
}
