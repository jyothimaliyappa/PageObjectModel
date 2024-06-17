import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class TestExcel {

	public static void main(String[] args) throws Throwable 
	{
		TestExcel red =new TestExcel();
		red.getData("login");
	}
		 public String[][] getData(String execelSheetname) throws Throwable
		   {
			   File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ExecelReading\\Testdata.xlsx");
			   FileInputStream fis =new FileInputStream(f);
			   Workbook wb = WorkbookFactory.create(fis);
			   Sheet sheetName = wb.getSheet(execelSheetname);
			   
			   int totalRows = sheetName.getLastRowNum();
			   System.out.println(totalRows);
			   
			   Row rowCells = sheetName.getRow(0);
			   int totalCols = rowCells.getLastCellNum();
			   
			   DataFormatter format =new DataFormatter();
			   
			   String testData[][] =new String[totalRows][totalCols];
			   for(int i=1; i<=totalRows;i++)
			   {
				   for(int j=0; j<totalCols; j++)
				   {
					   testData[i-1][j] =format.formatCellValue(sheetName.getRow(i).getCell(j));
					   System.out.println(testData[i-1][j]);
					   
				   }
				   
			   }
			   return testData;
		   }
		

	

}
