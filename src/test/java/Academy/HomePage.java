/**
 * 
 */
package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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
public class HomePage extends base {
 	public static Logger log = 
 		LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void homepageNavigetion(String email, String password){
		/*base ini = new base(driver);
		ini.InitializeDriver().get("http://google.com"); 
		ini.driver.close();*/
		driver = InitializeDriver();
		driver.get("http://ebay.com");
			log.info("=============Test Begin===============");
		LandingPage landing = new LandingPage(driver);
		landing.getLogin().click();
			log.debug("Click on login button");
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(email);
			log.info("email address input");
		lg.getPassword().sendKeys(password);
			log.info("password input");
		lg.getloginbtn().click();
			log.debug("login btn clicked");
			driver.close();
	} 
	@DataProvider
	public Object[][] getData(){
		//row stands for how many different data types test should run
		Object[][] data = new Object[2][2];
		data[0][0] = "fenghaoshu@gmail.com";
		data[0][1] = "123456";
		
		data[1][0] = "test1";
		data[1][1] = "test2";
		

		return data;
	}

	
	
	
	
	
}
