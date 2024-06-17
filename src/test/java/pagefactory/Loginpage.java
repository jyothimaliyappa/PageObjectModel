package pagefactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import config.ExcelReader;
import io.cucumber.datatable.DataTable;
import launchApp.LaunchApplication;

import config.ExcelReader;

public class Loginpage extends LaunchApplication
{
	
	@FindBy(xpath="//input[@id='user-name']")public static WebElement username;
	@FindBy(xpath="//input[@id='password']")public  WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")public static WebElement Loginbtn;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")public WebElement errormsg;
	
	
	
	public void Loginusername()
	{
		username.click();
		username.sendKeys("standard_user");
	}
	
	public void Loginpassword()
	{
		password.click();
		password.sendKeys("secret_sauce");
	}
	
	public void Loginbutton()
	{
		Loginbtn.click();
	}
	
	public void LoginpageErrormsg()
	{
		String Actualtext = errormsg.getText();
		System.out.println("Error Message is: "+Actualtext);
	   
		
	}
	
	/*
	 * public void Exampletab(io.cucumber.datatable.DataTable dataTable) {
	 * List<List<String>> cells= dataTable.cells();
	 * 
	 * for(List<String> e: cells) username.sendKeys(e.get(0)); }
	 */
	
	
	   public void Examp(String usernamechar) 
	  {
	  username.sendKeys(usernamechar); 
	  }
	 	
	
	
	   //Read data from Excel
	   public void getData(String SheetName) throws Throwable
	   {
		   File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ExecelReading\\Testdata.xlsx");
		   FileInputStream fis =new FileInputStream(f);
		   Workbook wb = WorkbookFactory.create(fis);
		   Sheet sheetName = wb.getSheet(SheetName);
		   
		   int totalRows = sheetName.getLastRowNum();
		   System.out.println(totalRows);
		   
		   Row rowCells = sheetName.getRow(0);
		   int totalCols = rowCells.getLastCellNum();
		   
		   System.out.println("Data is "+rowCells);
		   
		   DataFormatter format =new DataFormatter();
		   
		   String testData[][] =new String[totalRows][totalCols];
		   for(int i=1; i<=totalRows;i++)
		   {
			   for(int j=0; j<totalCols; j++)
			   {
				   testData[i-1][j] =format.formatCellValue(sheetName.getRow(i).getCell(j));
				   //System.out.println(testData[i-1][j]);
				  username.sendKeys(testData[i-1][j]);
				   
			   }
			   
		   }
		//   return testData;
	   }
	   
	   
	   //Read from excel with parameter
	   public void ecexelread(String SheetsName, Integer Rownumber) throws Throwable
	   {
		   Thread.sleep(2000);
		ExcelReader reader =new ExcelReader();
		
	//List<Map<String, String>> testDataMap= reader.getData("C:\\Users\\jyothi.m\\eclipse-workspace\\saucedemo\\src\\test\\resources\\ExecelReading\\Testdata.xlsx", SheetsName)
		
		  List<Map<String, String>> testDataMap =reader.getData(
		  "C:\\Users\\jyothi.m\\eclipse-workspace\\saucedemo\\src\\test\\resources\\ExecelReading\\Testdata.xlsx",
		  SheetsName);
		  
		  String usernamest=testDataMap.get(Rownumber).get("username");
		  String Passworddata=testDataMap.get(Rownumber).get("password");
		  
		  username.sendKeys(usernamest);
		  
		  
		  //WebElement
		//  userId=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
	//	  "user-name"))); 
		  Thread.sleep(4000);
		  driver.findElement(By.id("password")).sendKeys(Passworddata); Thread.sleep(2000);
		 
	   }
	   
	   
	 
	   

}
