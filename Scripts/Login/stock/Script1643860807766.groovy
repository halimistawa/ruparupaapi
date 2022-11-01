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

responseGetStock = WS.sendRequest(findTestObject('API FLOW/stock',[('sku'):sku]))
def getStock = new groovy.json.JsonSlurper()
def resultGetStock = getStock.parseText(responseGetStock.getResponseBodyContent())
String getError = resultGetStock.errors.isEmpty().toString()
def resultError = resultGetStock.errors
String getData = resultGetStock.data.toString()
def resultMessage = resultGetStock.messages
String excelName = GlobalVariable.excelName
String resultAPI = 'default'
int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()
CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 0, '/Stock')
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 0, '/Stock')

if(getError == 'true')
{
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Passed')
	if(getData.contains('location'))
	{
		int resultTotalStore = resultGetStock.data.location.size()
		String getGlobalStock = resultGetStock.data.global_stock_qty.toString()
		resultAPI = ('Total Toko : '+resultTotalStore+',  Global Stock : '+getGlobalStock)
		CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultAPI)
		}else{
		resultAPI = ('SKU tidak ditemukan/Stock Habis')
		CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultAPI)
	}
}else{
	resultAPI = (resultError+' : '+resultMessage)
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Error')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultAPI)
}
