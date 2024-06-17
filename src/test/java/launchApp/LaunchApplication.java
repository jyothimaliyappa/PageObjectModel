package launchApp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pagefactory.AddtoCartPage;
import pagefactory.Loginpage;

public class LaunchApplication
{
	
    public static Properties prop;
	public static WebDriver driver;
	public  static String Browser;
	public static Loginpage lg;
	public static AddtoCartPage adc;
	public static SoftAssert st;
	
    public static void openbrowser() throws Throwable, Throwable
    {
    	st=new SoftAssert();
    	prop=new Properties();
    	prop.load(new FileReader("src\\test\\java\\config\\Global.properties") );
    	Browser=prop.getProperty("Browser");
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyothi.m\\eclipse-workspace\\PageObjectModelPro\\chromedriver\\chromedriver.exe");
    	if(Browser.equalsIgnoreCase("chrome"))
    	 driver=new ChromeDriver();
    	else if(Browser.equalsIgnoreCase("Edge"))
    		driver=new EdgeDriver();
    	driver.get(prop.getProperty("URL"));
    	driver.manage().window().maximize();	
    	initClass();
    	
    }
	
	public static void initClass()
	{
		lg=PageFactory.initElements(driver, Loginpage.class);
		adc=PageFactory.initElements(driver, AddtoCartPage.class);
		
	}
	

	public void closebrowser()
	{
		driver.quit();
	}
	
}
