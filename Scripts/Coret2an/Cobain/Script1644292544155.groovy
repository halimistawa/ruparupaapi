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

responseGetLogin = WS.sendRequest(findTestObject('API FLOW/login'))
def getLogin = new groovy.json.JsonSlurper()
def resultLogin = getLogin.parseText(responseGetLogin.getResponseBodyContent())
def statusResponse = resultLogin.status
def messageResponse = resultLogin.message
String messageSuccess = 'default'

if(messageResponse != null){
println (statusResponse+' : '+messageResponse)
}
else{
	GlobalVariable.accessToken = resultLogin.token
	GlobalVariable.minicartID = resultLogin.data.cart_id
	println (GlobalVariable.accessToken)
	println (GlobalVariable.minicartID)
}

responseGetMinicart = WS.sendRequest(findTestObject('API FLOW/minicart'))
def getMinicart = new groovy.json.JsonSlurper()
def resultGetMinicart = getMinicart.parseText(responseGetMinicart.getResponseBodyContent())
int totalQty = 0
int totalSKU = 0
String resultMessage = resultGetMinicart.message.toString()
String resultAPI = 'default'
String resultStatus = 'default'

/*
String excelName = GlobalVariable.excelName

int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()
CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 0, '/minicart')
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 0, '/minicart')
*/
if (resultMessage.contains('success')) {
//	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Passed')
	String cekItems = resultGetMinicart.data.items.toString()
	if(cekItems != 'null')
	{
		totalSKU = resultGetMinicart.data.items.size() 
	}else{totalSKU = 0}
		
	totalQty = resultGetMinicart.data.total_qty
	resultAPI = ('Total Qty : '+totalQty+', Total SKU : ' + totalSKU + ', Produk Terpilih : '+resultGetMinicart.data.total_selected_qty)
	println(resultAPI)
//	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultAPI)
} else {
	resultStatus = resultGetMinicart.status
	resultAPI = ((resultStatus + ' : ') + resultMessage)
//	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Error')
//	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultAPI)
}

