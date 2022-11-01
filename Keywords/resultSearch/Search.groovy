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

public class ResultSearchSKU {
	Date today = new Date()
	String todaysDate = today.format('dd-MM-yyyy')

	@Keyword
	public void createExcel(String name) {
		ExcelKeywords.createExcelFile("C:\\Users\\dharm\\OneDrive\\Documents\\KATALON\\Result\\"+name+" ("+todaysDate+")"+".xlsx")
	}
	@Keyword
	public void writeExcel(String name, int row, int colm, String value) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\dharm\\OneDrive\\Documents\\KATALON\\Result\\"+name+" ("+todaysDate+")"+".xlsx");
		"ResultSKU.xlsx"
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet0");

		ExcelKeywords.setValueToCellByIndex(sheet, 0, 0, 'SKU')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 1, 'Result Run')
		ExcelKeywords.setValueToCellByIndex(sheet, 0, 2, 'Status')

		ExcelKeywords.setValueToCellByIndex(sheet, row, colm, value)
		FileOutputStream fos = new FileOutputStream("C:\\Users\\dharm\\OneDrive\\Documents\\KATALON\\Result\\"+name+" ("+todaysDate+")"+".xlsx");
		workbook.write(fos);
		fos.close();
	}
}
/*
 @Keyword
 public void createExcel(String name) {
 FileInputStream fis = new FileInputStream("C:\Users\dharm\OneDrive\Documents\KATALON\Result\ResultSKU.xlsx");
 XSSFWorkbook workbook = new XSSFWorkbook(fis);
 XSSFSheet sheet = workbook.getSheet("Sheet0");
 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
 Row row = sheet.createRow(rowCount+1);
 Cell cell = row.createCell(0);
 cell.setCellType(cell.CELL_TYPE_STRING);
 cell.setCellValue(name);
 Excel	    
 FileOutputStream fos = new FileOutputStream("E:\\ExcelSheets\\Demo1.xlsx");
 workbook.write(fos);
 fos.close();
 }
 }
 */
/*	def verifyStatusCode(TestObject request, int expectedStatusCode) {
 if (request instanceof RequestObject) {
 RequestObject requestObject = (RequestObject) request
 ResponseObject response = WSBuiltInKeywords.sendRequest(requestObject)
 if (response.getStatusCode() == expectedStatusCode) {
 KeywordUtil.markPassed("Response status codes match")
 } else {
 KeywordUtil.markFailed("Response status code not match. Expected: " +
 expectedStatusCode + " - Actual: " + response.getStatusCode() )
 }
 } else {
 KeywordUtil.markFailed(request.getObjectId() + " is not a RequestObject")
 }
 }
 */
/**
 * Add Header basic authorization field,
 * this field value is Base64 encoded token from user name and password
 * @param request object, must be an instance of RequestObject
 * @param username username
 * @param password password
 * @return the original request object with basic authorization header field added
 */
/*	
 @Keyword
 def addBasicAuthorizationProperty(TestObject request, String username, String password) {
 if (request instanceof RequestObject) {
 String authorizationValue = username + ":" + password
 authorizationValue = "Basic " + authorizationValue.bytes.encodeBase64().toString()
 // Find available basic authorization field and change its value to the new one, if any
 List<TestObjectProperty> headerProperties = request.getHttpHeaderProperties()
 boolean fieldExist = false
 for (int i = 0; i < headerProperties.size(); i++) {
 TestObjectProperty headerField = headerProperties.get(i)
 if (headerField.getName().equals('Authorization')) {
 KeywordUtil.logInfo("Found existent basic authorization field. Replacing its value.")
 headerField.setValue(authorizationValue)
 fieldExist = true
 break
 }
 }
 if (!fieldExist) {
 TestObjectProperty authorizationProperty = new TestObjectProperty("Authorization",
 ConditionType.EQUALS, authorizationValue, true)
 headerProperties.add(authorizationProperty)
 }
 KeywordUtil.markPassed("Basic authorization field has been added to request header")
 } else {
 KeywordUtil.markFailed(request.getObjectId() + "is not a RequestObject")
 }
 return request
 }
 }
 */