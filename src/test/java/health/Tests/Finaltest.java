package health.Tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import health.TestComponent.base;
import health.pages.Appointmentpage;
import health.pages.LandingPage;
import health.pages.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Finaltest extends base {

	@Test
	public void start() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String Username = "John Doe";
		String Password = "ThisIsNotAPassword";
//		WebDriver driver = new ChromeDriver();
		LandingPage landing = launch();
//		landing.gotopage();
		Login login =landing.info();
//		Login login = new Login(driver);
		Appointmentpage appoint = login.loginweb(Username, Password);
//		Appointmentpage appoint = new Appointmentpage(driver);
		appoint.makeappointment();
		
	}
	

}
