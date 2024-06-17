package pagefactory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import launchApp.LaunchApplication;

public class AddtoCartPage extends LaunchApplication
{
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-onesie\"]")public WebElement additem;
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")public WebElement Cartitem;
	
	
	public void additem() throws Throwable
	{
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)" ," ");
		additem.click();
		Thread.sleep(4000);
//		JavascriptExecutor jsp=(JavascriptExecutor)driver;
//		jsp.executeScript("windows.scrollBy(0,-250)");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		
	}
	
	public void Cartitem() throws IOException, Throwable
	{
		Cartitem.click();
		File screenshotAs=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		FileHandler fileHandler=new FileHandler();
		fileHandler.copy(screenshotAs, new File("./snaps/img1.png"));
		Thread.sleep(2000);
	}
	

}
