package health.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import health.abstractclasscomponent.abstractclasscomponent;

public class Login extends abstractclasscomponent{
		WebDriver driver;
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css=".form-horizontal")
	WebElement calenderpage;
	
	@FindBy(css="p.text-danger")
	WebElement error;
		public Appointmentpage loginweb(String Username, String Password)
		{
			driver.findElement(By.xpath("(//input[@id='txt-username'])[1]")).sendKeys(Username);
			driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys(Password);
			driver.findElement(By.id("btn-login")).click();
			wait(calenderpage);
			Appointmentpage appoint = new Appointmentpage(driver);
			return appoint;
}
		public String geterror()
		{
			wait(error);
			return error.getText();
			
		}
}
