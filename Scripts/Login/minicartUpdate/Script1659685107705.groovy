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

responseGetLogin = WS.sendRequest(findTestObject('API FLOW/login', [('uid') : uidlist, ('pass') : passlist]))
GlobalVariable.accessToken = ''
GlobalVariable.minicartID = ''
def getLogin = new groovy.json.JsonSlurper()
def resultLogin = getLogin.parseText(responseGetLogin.getResponseBodyContent())
def statusResponse = resultLogin.status
def messageResponse = resultLogin.message
String messageSuccess = 'default'
if (messageResponse != null) {
    println((statusResponse + ' : ') + messageResponse)
} else {
    GlobalVariable.accessToken = resultLogin.token
    GlobalVariable.minicartID = resultLogin.data.cart_id
}

responseMinicartUpdate = WS.sendRequest(findTestObject('API FLOW/minicartUpdate',[('minicartid'):GlobalVariable.minicartID,('authorization'):GlobalVariable.accessToken,('sku'):sku,('qty'):qty]))
def getMinicartUpdate = new groovy.json.JsonSlurper()
def resultMinicartUpdate = getMinicartUpdate.parseText(responseMinicartUpdate.getResponseBodyContent())
String resultMessage = resultMinicartUpdate.message.toString()
String resultError = resultMinicartUpdate.errors.message.toString()


println("result message "+resultMessage)
String excelName = GlobalVariable.excelName

int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()
CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 0, '/minicart/update')
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 0, '/minicart/update')

if (resultMessage.contains('updated')&&resultError==null) {
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Passed')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultMessage+' : '+resultError)
	println("Success message "+resultMessage)
	println("Success error "+resultError)
	
} else {
	//resultStatus = resultGetMinicart.status
	//resultAPI = ((resultStatus + ' : ') + resultMessage)
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(excelName, lastRowExcell + 1, 1, 'Error')
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(excelName, lastRowExcell + 1, 1, resultMessage+' : '+resultError)
	println("Failed message "+resultMessage)
	println("Failed errors "+resultError)
}