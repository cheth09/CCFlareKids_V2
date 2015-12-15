package excelInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Elementdetectioninfo {
	@Test
	  public static Sheet FindElementPath(String sheetName) throws IOException,FileNotFoundException, EncryptedDocumentException, InvalidFormatException {
		  File filepath = new File(System.getProperty("user.dir"));
		  File file = new File(filepath,"/File/CCElementPathInfo.xls");
		  FileInputStream input = new FileInputStream(file);
		  //reading .xls file
		Workbook excelformat = WorkbookFactory.create(input);
		//  Workbook excelformat=null;
		//  excelformat = new XSSFWorkbook(input);
		  Sheet excelSheet = excelformat.getSheet(sheetName);
		  return excelSheet;
	  }
}
