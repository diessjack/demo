/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author HAOSHU FENG
 * @version 1.0
 * @since Oct 24, 2017 1:49:01 AM 
 */
public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='userid']")
	WebElement email;
	@FindBy(xpath = "//input[@name='pass']")
	WebElement password;
	@FindBy(xpath = "//input[@id='sgnBt']")
	WebElement loginbtn;
	
	public WebElement getEmail(){
		return email;
	}
	public WebElement getPassword(){
		return password;
	}
	public WebElement getloginbtn(){
		return loginbtn;
	}
	
	
	
}
