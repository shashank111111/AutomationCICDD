package health.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import health.TestComponent.base;
import health.pages.Appointmentpage;
import health.pages.LandingPage;
import health.pages.Login;

public class ErrorVal extends base {
	
	@Test
	public void error() throws IOException
	{
		String Username = "John Doe";
		String Password = "This----IsNotAPassword";
//		WebDriver driver = new ChromeDriver();
		LandingPage landing = launch();
//		landing.gotopage();
		Login login =landing.info();
//		Login login = new Login(driver);
		Appointmentpage appoint = login.loginweb(Username, Password);
		Assert.assertEquals("Login failed! Please ensure the username and password are valid.", login.geterror());
		
	}

}
