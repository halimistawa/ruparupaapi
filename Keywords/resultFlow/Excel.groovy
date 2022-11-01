package resultFlow
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
import com.kms.katalon.core.webui.keyword.builtin.getCSSValueKeyword
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
	String todaysDate = today.format('dd-MM-yyyy HH')

	String folderLocation = GlobalVariable.locationFile
	String nameExcell = GlobalVariable.excelName


	@Keyword
	public int cekFileExcel(){
		String fileName =  nameExcell +" ("+ todaysDate+"))"+".xlsx"
		int getFile = 0

		File resultFolder = new File(folderLocation)
		List namesOfFiles = Arrays.asList(resultFolder.list())
		if(namesOfFiles.contains(fileName)) {
			getFile = 1
		}else{
			getFile = 0
		}
		return getFile;
	}

	@Keyword
	public void createExcel(String name){
		ExcelKeywords.createExcelFile(folderLocation+name+" ("+todaysDate+")"+".xlsx")
		//"C:\\Users\\dharm\\OneDrive\\Documents\\KATALON\\Result\\Result Flow\\"
		FileInputStream fis = new FileInputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Sheet Name
		XSSFSheet sheet = workbook.setSheetName(0, "Summary")
		XSSFSheet sheet1 = workbook.createSheet("Detail Response")

		// Cell Name
		XSSFSheet cellSheet = workbook.getSheet("Summary");
		ExcelKeywords.setValueToCellByIndex(cellSheet, 0, 0, 'API Name')
		ExcelKeywords.setValueToCellByIndex(cellSheet, 0, 1, 'Status')

		XSSFSheet cellSheet1 = workbook.getSheet("Detail Response")
		ExcelKeywords.setValueToCellByIndex(cellSheet1, 0, 0, 'Field Response')
		ExcelKeywords.setValueToCellByIndex(cellSheet1, 0, 1, 'Value')


		FileOutputStream fos = new FileOutputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public void writeExcel(String name, int row, int colm, String value) throws IOException{
		FileInputStream fis = new FileInputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Summary");

		ExcelKeywords.setValueToCellByIndex(sheet, row, colm, value)

		FileOutputStream fos = new FileOutputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public void writeExcel1(String name, int row, int colm, String value) throws IOException{
		FileInputStream fiss = new FileInputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fiss);
		XSSFSheet sheet = workbook.getSheet("Detail Response")

		String getRows = sheet.getLastRowNum()
		ExcelKeywords.setValueToCellByIndex(sheet, row, colm, value)

		FileOutputStream foss = new FileOutputStream(folderLocation+name+" ("+todaysDate+")"+".xlsx");
		workbook.write(foss);
		foss.close();
	}

	@Keyword
	public int countRowExcel1()throws IOException{
		//String name = 'Report Flow API '
		FileInputStream fis = new FileInputStream(folderLocation+nameExcell+" ("+todaysDate+")"+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Summary");
		int getRows = 0

		getRows = sheet.getLastRowNum()

		FileOutputStream fos = new FileOutputStream(folderLocation+nameExcell+" ("+todaysDate+")"+".xlsx");
		workbook.write(fos);
		fos.close();
		return getRows;
	}
}
