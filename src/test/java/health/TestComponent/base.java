package health.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import health.pages.LandingPage;

public class base {
	public WebDriver driver;
	public LandingPage landing;
	String browsername;
	public WebDriver initialize() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fise = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\curacare\\src\\main\\java\\health\\resources\\globaldata.properties");
		prop.load(fise);
	browsername	= System.getProperty("browser")!=null ? System.getProperty("browser") :  prop.getProperty("browser");
//		browsername = prop.getProperty("browser");
			if (browsername.contains("chrome"))
			{	ChromeOptions option = new ChromeOptions();
			if(browsername.contains("headless"))
			{
				option.addArguments("headless");
			}
					driver = new ChromeDriver(option);
			}
			return driver;
		
	}
//	@BeforeMethod
	public LandingPage launch() throws IOException
	{
		driver = initialize();
		LandingPage landing = new LandingPage(driver);
		landing.gotopage();
		return landing;
	}	
		public String getss(String testCaseName, WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File(System.getProperty("user.dir")+ "//report//"+ testCaseName + ".jpg"));
			return System.getProperty("user.dir")+ "//report//"+ testCaseName + ".jpg";
	}

	

}
