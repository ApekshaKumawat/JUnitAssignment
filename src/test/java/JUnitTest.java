import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class JUnitTest {
	
	
	@Test
	public void testForgotPasswordSuccess() {
		LoginPage login = Mockito.mock(LoginPage.class);
		doNothing().when(login).forgotPassword("admin@gmail.com");
		login.forgotPassword("admin@gmail.com");
		verify(login, times(1)).forgotPassword("admin@gmail.com");
		
	}
	
	@Test
	public void testLoginSuccess() {
		LoginPage loginPage = new LoginPage();
		boolean loggedIn = loginPage.login("user1@gmail.com","123456");
		Assertions.assertTrue(loggedIn,"Login successfully!");
	}
	
	@Test
	public void testLoginFailureWrongPassword() {
		//Wrong Password
		LoginPage loginPage = new LoginPage();
		boolean loggedIn = loginPage.login("user1@gmail.com","126");
		Assertions.assertFalse(loggedIn,"Login Failed!");
	}
	
	@Test
	public void testLoginFailureWrongEmail() {
		LoginPage loginPage = new LoginPage();
		boolean loggedIn = loginPage.login("user@gmail.com","123456");
		Assertions.assertFalse(loggedIn,"Login Failed!");
	}
	

}
