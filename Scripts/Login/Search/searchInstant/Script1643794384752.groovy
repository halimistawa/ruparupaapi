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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

responseGetSearchInstant = WS.sendRequest(findTestObject('Search RR/searchInstant',[('keyword'):sku]))

def getSearchInstant = new groovy.json.JsonSlurper()
def resultSearchInstant = getSearchInstant.parseText(responseGetSearchInstant.getResponseBodyContent())
def resultError = resultSearchInstant.error
def resultMessage = resultSearchInstant.message
//def resultSug = resultSearchInstant.data.sug.toString()
String excelName = GlobalVariable.excelName
String resultName = 'default'
int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()


CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 0, '/SearchInstant')
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell+1, 0, '/SearchInstant')
if (resultError == false) {
	String getData = resultSearchInstant.data.prd.isEmpty().toString()
	if(getData == 'false')
	{
		resultName = resultSearchInstant.data.prd[0].name
		//println(getData+' '+resultName)
	}else{
		resultName = 'Keyword tidak ditemukan'
	}
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 1, 'Passed')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell+1, 1, resultName)
   } else {
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 1, 'Error')
}
