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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


/*
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
*/

responseSKU = WS.sendRequest(findTestObject('API Login/searchSKUDrivenTest', [('base_url') : GlobalVariable.baseURL, ('sku') : skulist]))
def getName = new groovy.json.JsonSlurper()
def resultName = getName.parseText(responseSKU.getResponseBodyContent())
def messageRequest = resultName.message
def baris = nomor as Integer

if ((messageRequest == 'success') & (resultName.data.total != '')) 
{
    def nameSKU = resultName.data.prd[0].name
    resultRunning = ((skulist + ' ') + nameSKU)
//    println(resultRunning)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,0, skulist)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,1, resultRunning)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,2, 'Passed')
} else if ((messageRequest == 'success') & (resultName.data.total == '')) 
{
//    println(('SKU ' + skulist) + ' Tidak Ditemukan')
    resultRunning = 'Tidak Ditemukan'
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,0, skulist)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,1, resultRunning)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,2, 'Error')
} else if (messageRequest != 'success') 
{
    println('Error System')
    resultRunning = 'Error System'
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,0, skulist)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,1, resultRunning)
	CustomKeywords.'resultSearch.ResultSearchSKU.writeExcel'('Result Search SKU ',baris,2, 'Error')
}

