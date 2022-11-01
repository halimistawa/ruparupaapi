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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


responseGetLogin = WS.sendRequest(findTestObject('API FLOW/login',[('base_url'):GlobalVariable.baseURL, ('uid'):uidlist,('pass'):passlist]))
def getLogin = new groovy.json.JsonSlurper()
def resultLogin = getLogin.parseText(responseGetLogin.getResponseBodyContent())
def statusResponse = resultLogin.status
def messageResponse = resultLogin.message
String nameExcell = GlobalVariable.excelName
String messageSuccess = 'default'
//String getToken = 'default'
//String getMinicartID = 'default'

int lastRowExcell = CustomKeywords.'resultFlow.WriteExcel.countRowExcel1'()
CustomKeywords.'resultFlow.WriteExcel.writeExcel'(nameExcell,lastRowExcell+1,0, "/login")
CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(nameExcell,lastRowExcell+1,0, "/login")
if(messageResponse != null){
println (statusResponse+' : '+messageResponse)
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(nameExcell,lastRowExcell+1,1, "Failed")
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(nameExcell,lastRowExcell+1,1, statusResponse+' : '+messageResponse)
}
else{
	messageSuccess = resultLogin.data.customer_id
//	getToken = resultLogin.data.token
//	getMinicartID = resultLogin.data.cart_id
	
	GlobalVariable.accessToken = resultLogin.data.token
	GlobalVariable.minicartID = resultLogin.data.cart_id
	println (GlobalVariable.accessToken)
	println (GlobalVariable.minicartID)
	CustomKeywords.'resultFlow.WriteExcel.writeExcel'(nameExcell,lastRowExcell+1,1, "Passed")
	CustomKeywords.'resultFlow.WriteExcel.writeExcel1'(nameExcell,lastRowExcell+1,1, "Customer ID : "+messageSuccess)	
}
/*	"customer_id":"12345,"
	"first_name":"dharma",
	"email":"dharma@gmail.com",
	"phone":"087656674323",
	"last_name":"",
    "birth_date":null,
    "gender":null,
    "is_new":"0",
    "last_login":"2022-01-27 15:17:58",
    "registered_by":"ruparupa",
    "is_phone_verified":"10",
    "is_email_verified":"0",
	"token":"8b2612aa4651023c802d60a9cc73cc902d0ab1e72af0fe9151243206f1ff5933",
	"cart_id":"8306dc80d95c0864e45d843f240e0827f941f11c"
*/   