package excelInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

public class ReadFileInfo {
	@Test
	  public static  Sheet ReadSignUpInfo(String sheetName) throws IOException {
		  File filepath = new File(System.getProperty("user.dir"));
		  File file = new File(filepath,"/File/CCFlareKidsInfo.xls");
		  FileInputStream input = new FileInputStream(file);
		//  FileInputStream input = new FileInputStream(new POIFSFileSystem(new FileInputStream(file)));
		  //reading .xls file
		  Workbook excelformat = null;
		  excelformat = new HSSFWorkbook(input);
		  Sheet excelSheet = excelformat.getSheet(sheetName);
		  return excelSheet;
	  }
	  @Test
	  public static int retriveNoOfRows(Sheet excelSheet,String sheetName){
		  int rowcount= excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();
		  return rowcount;
	  }
	  @Test
	  public static int retriveNoOfColumns(Sheet excelSheet, String sheetName){
		  int colcount = excelSheet.getRow(0).getPhysicalNumberOfCells();
		  return colcount;			  
	  }
	  
}
