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

responseGetSearchTahuSuggestion = WS.sendRequest(findTestObject('Search RR/searchTahuSuggestion'))
def getSearchTahu = new groovy.json.JsonSlurper()
def resultSearchTahu = getSearchTahu.parseText(responseGetSearchTahuSuggestion.getResponseBodyContent())
def resultError = resultSearchTahu.error
def resultMessage = resultSearchTahu.message
def resultTahu = resultSearchTahu.data.finalRandomList.toString()
String excelName = GlobalVariable.excelName
int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()


CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 0, '/SearchTahuSuggestion')
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell+1, 0, '/SearchTahuSuggestion')
if (resultError == false) {
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 1, 'Passed')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell+1, 1, resultTahu)
   } else {
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell+1, 1, 'Error')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell+1, 1, resultMessage)
}

