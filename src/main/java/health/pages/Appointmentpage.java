package health.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import health.abstractclasscomponent.abstractclasscomponent;

public class Appointmentpage extends abstractclasscomponent{
	WebDriver driver;
	public Appointmentpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css="div.datepicker-orient-top")
	WebElement calender;
	public void makeappointment() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.id("combo_facility"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText("Seoul CURA Healthcare Center");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#chk_hospotal_readmission")).click();
		driver.findElement(By.cssSelector("input[value='None']")).click();
		driver.findElement(By.id("txt_visit_date")).click();
		wait(calender);
		WebElement next = driver.findElement(By.cssSelector("th.next"));
		WebElement month = driver.findElement(By.cssSelector(".datepicker-switch"));
		while(!month.getText().contains("December"))
		{
			next.click();
			List<WebElement> days = driver.findElements(By.cssSelector("td.day"));
			days.stream().filter(day->day.getText().equalsIgnoreCase("12")).findAny().orElse(null).click();
		}
		driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Will meet you at the top");
		driver.findElement(By.id("btn-book-appointment")).click();
		

	}

}
