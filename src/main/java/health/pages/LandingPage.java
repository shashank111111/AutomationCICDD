package health.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import health.abstractclasscomponent.abstractclasscomponent;

public class LandingPage extends abstractclasscomponent {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void gotopage()
	{
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
	}
	
	@FindBy(id="login")
	WebElement login;
	
	public Login info()
	{
		driver.findElement(By.id("btn-make-appointment")).click();
		wait(login);
		Login login = new Login(driver);
		return login;
	}
}
