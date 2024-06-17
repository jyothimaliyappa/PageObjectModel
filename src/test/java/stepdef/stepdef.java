package stepdef;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import config.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import launchApp.LaunchApplication;

public class stepdef extends LaunchApplication
{
	 @Before 
	public static void beforeallapp() throws Throwable
	{
		LaunchApplication.openbrowser();
	}
	
	 @After
	 public static void afterallapp()
	 {
		 LaunchApplication lpp= new LaunchApplication();
		 lpp.closebrowser();
     }

	@Given("user launch applicaton url")
	public void user_launch_applicaton_url() 
	{
		System.out.println("Application page is launched");
		System.out.println("***********************************");
	  
	}
	
	
	@When("user enter user name")
	public void user_enter_user_name() {
		 lg.Loginusername();
	}

	@And("user enter password")
	public void user_enter_password() {
		 lg.Loginpassword();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("user clicks Login button")
	public void user_clicks_login_button() {
		lg.Loginbutton();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	


  //Login_Page Scenario two
 //----------------------------------------------------------------------------------------------------------------------------------------------------------------
	@When("user only enter user name")
	public void user_only_enter_user_name() 
	{
	      lg.Loginusername();
	      
	}
	@And("user press login button")
	public void user_press_login_button() throws Throwable 
	{
	 
		Thread.sleep(2000);
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	}

	
	//Login Page scenario three
	//**************************************************************************************************************
	@When("user enter only password")
	public void user_enter_only_password() throws Throwable
	{
		Thread.sleep(2000);
	       lg.Loginpassword();   
	       
	}
	
	//Login page Error Validation
	//******************************************************************************************************************
	@Then("Home page will not display")
	public void home_page_will_not_display() throws Throwable 
	{
		
		lg.Loginbutton();
		Thread.sleep(3000);
		lg.LoginpageErrormsg();
		Thread.sleep(3000);
		
	}
	
	//Add to cart page
	//*****************************************************************************************************************
	
	@Then("item will be added to cart")
	public void item_will_be_added_to_cart() throws Throwable 
	{
	   adc.additem();
		Thread.sleep(3000);
		adc.Cartitem();
		Thread.sleep(3000);
		
	}
	
	
	//Example table for login function
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	   
	
	   
	   @When("user enter exp {string}")
	   public void user_enter_exp(String  usernamechar) throws Throwable 
	   {
	       lg.Examp(usernamechar);
	       Thread.sleep(2000);
	   }
	   
	  //Read data from Excel sheet
	 //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	   

//	   @When("user read data from excel")
//	   public void user_read_data_from_excel() throws Throwable 
//	   {
//		  
//		   	lg.getData("login");
//		   	Thread.sleep(5000);
//		   	
//	   }
	   
	   @When("user enter {string}")
	   public void user_enter_and(String SheetName) throws Throwable, Throwable 
	   {
		 lg.getData(SheetName);
		
	   }
	   	
	   
	   @When("user enter pass excelsheet name and user name from {string} and {int}")
	   public void user_enter_pass_excelsheet_name_and_user_name_from_and(String SheetsName, Integer Rownumber) throws Throwable, Throwable 
	   {
		   Thread.sleep(2000);
		 lg.ecexelread(SheetsName, Rownumber);
	   }

	   
//	   @When("user enter pass excelsheet name and user name from {string} and {int}")
//	   public void user_enter_pass_excelsheet_name_and_user_name_from_and(String string, Integer int1) {
//	     
//		   
//		   
//	   }
	 




}
