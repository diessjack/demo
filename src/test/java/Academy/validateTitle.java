/**
 * 
 */
package Academy;

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
public class validateTitle extends base {
 	public static Logger log = 
 			LogManager.getLogger(validateTitle.class.getName());
	public WebDriver driver;
	@BeforeClass
	public void Initialize(){
		driver = InitializeDriver();
		driver.get(prop.getProperty("ebayhomeurl"));
			log.info("Driver is initialized to ebay HomePage");
	}
	@Test
	public void titlecheck(){
		/*base ini = new base(driver);
		ini.InitializeDriver().get("http://google.com"); 
		ini.driver.close();*/
		
		LandingPage landing = new LandingPage(driver);
		Assert.assertEquals(landing.checkDisplayed().getText(), "Popular eBay Deals");
		//Assert.assertTrue(landing.checknavbar().isDisplayed());
		log.info("title checked");
	} 
	@AfterClass
	public void clos(){
		driver.close();
	}

	
	
	
	
	
}
