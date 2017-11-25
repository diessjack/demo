/**
 * 
 */
package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

/**
 * @author HAOSHU FENG
 * @version 1.0
 * @since Oct 24, 2017 12:54:51 AM 
 */
public class validateNavigationBar extends base {
	@BeforeClass
	public void initialize(){
		driver = InitializeDriver();
		driver.get(prop.getProperty("ebayhomeurl"));
		log.info("ebay home page opened to check navbar");
	}
	public static Logger log = 
			LogManager.getLogger(validateNavigationBar.class.getName());
	public WebDriver driver;
	
	@Test
	public void Navbar() throws IOException{
		/*base ini = new base(driver);
		ini.InitializeDriver().get("http://google.com"); 
		ini.driver.close();*/
		//String filepath = "C:\\Users\\HAOSHU\\RealProject\\src\\main\\java\\resources\\datadriven.properties";
		//FileInputStream fis = new FileInputStream(filepath);
		
		//prop.load(fis);
		
		
		LandingPage landing = new LandingPage(driver);
		//Assert.assertEquals(landing.checkDisplayed().getText(), "Popular eBay Deals");
		Assert.assertTrue(landing.checknavbar().isDisplayed());
		log.info("navbar checked");;
		
	} 
	@AfterClass
	public void teardown(){
		driver.close();
	}

	
	
	
	
	
}
