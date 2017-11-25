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
public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(xpath = "//h2[@class='hl-card-header__title']")
	WebElement Viewed;

	@FindBy(xpath = "//div[@class='hl-cat-nav']")
	WebElement navbar;
	
	public WebElement getLogin(){
		return signin;
	}
	
	public WebElement checkDisplayed(){
		return Viewed;
	}
	
	public WebElement checknavbar(){
		return navbar;
	}
	
	
}
