package JUnitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import controller.LoginDAO;
import model.Login;
public class LoginDAOTest {
 private Login log = new Login();
private LoginDAO logDao = new LoginDAO();


@Test
public void DezelfdeLogins()
{
	log.setUsername("testL");
	log.setWachtwoord("test");
}

}



