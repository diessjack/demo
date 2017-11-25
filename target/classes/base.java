/**
 * 
 */
package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * @author HAOSHU FENG
 * @version 1.0
 * @since Oct 24, 2017 12:06:19 AM 
 */
public class base {
	public static WebDriver driver;
	public Properties prop;
	public static Logger log = 
			LogManager.getLogger(base.class.getName());
//	public base(WebDriver driver){
//		this.driver = driver;
//	}
	@Test
	public WebDriver InitializeDriver() {
		
		String filepath = "C:\\Users\\HAOSHU\\RealProject\\src\\main\\java\\resources\\datadriven.properties";
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not Found");
			log.error("File Not Found");
		}
		try {
			prop.load(fis);
			log.info("Load the properties file success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can not load the file");
			log.error("Can not load the file");
		}
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D://selenium/chromedriver_win32/chromedriver.exe");
			 driver = new ChromeDriver();
			// log.info("chrome open success");
		}
		else if(browsername.equals("firfox")){
			System.setProperty("webdriver.gecko.driver","D://selenium/geckodriver/geckodriver.exe");
			 driver = new FirefoxDriver();
			// log.info("firfox open");
		}
		else{
			System.out.println("browser name not find");
			log.error("browser name not found");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		//log.info("open the url from properties url");
		return driver;
	}
	public void getScreenshot(String result) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D://RealProject_Selenium_ScreenShot//" + result + "Scereenshot.png"));
	
		
		
	}

}
