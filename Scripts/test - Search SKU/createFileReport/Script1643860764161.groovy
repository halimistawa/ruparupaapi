import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

 Date today = new Date()
 String todaysDate = today.format('dd-MM-yyyy')
 String fileName =  'Result Search SKU '+ todaysDate
 
 
 File resultFolder = new File("C:\\Users\\dharm\\OneDrive\\Documents\\KATALON\\Result\\")
 List namesOfFiles = Arrays.asList(resultFolder.list())
 if(namesOfFiles.contains(fileName))
	 {
		 
		 println "File Sudah Ada"
	 }else
	 {
		 CustomKeywords.'resultSearch.ResultSearchSKU.createExcel'('Result Search SKU ')
		 println "Success"
	 }
 