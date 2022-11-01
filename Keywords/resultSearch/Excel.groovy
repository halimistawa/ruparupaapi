package resultSearch
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	Date today = new Date()
	String todaysDate = today.format('dd-MM-yyyy')

	@Keyword
	public void createExcel(String name){
		ExcelKeywords.createExcelFile("E:\\Report\\"+name+" ("+todaysDate+")"+".xlsx")
	}

	@Keyword
	public void writeExcel(String name, int row, int colm, String value) throws IOException{
		FileInputStream fis = new FileInputStream("E:\\Report\\"+name+" ("+todaysDate+")"+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet0");

		ExcelKeywords.setValueToCellByIndex(sheet, 0, 0, 'SKU')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 1, 'GT TP')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 2, 'GT OMS')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 3, 'Compare')

		ExcelKeywords.setValueToCellByIndex(sheet, 0, 4, 'ODI')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 5, 'Marketing Cost')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 6, 'Buyer Cost')

		ExcelKeywords.setValueToCellByIndex(sheet, row, colm, value)
		FileOutputStream fos = new FileOutputStream("E:\\Report\\"+name+" ("+todaysDate+")"+".xlsx");
		workbook.write(fos);
		fos.close();
	}
}
