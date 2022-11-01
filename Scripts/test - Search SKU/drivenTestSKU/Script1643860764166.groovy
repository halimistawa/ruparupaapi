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

responseSKU = WS.sendRequest(findTestObject('API Login/searchSKUDrivenTest', [('base_url') : GlobalVariable.baseURL, ('sku') : skulist]))

//WS.verifyElementPropertyValue(responseSKU, 'message', "success")
//println(skulist + ' ditemukan')
//responseSearchSKU = WS.sendRequest(findTestObject('API Login/searchSKU'))
def getName = new groovy.json.JsonSlurper()
def resultName = getName.parseText(responseSKU.getResponseBodyContent())
def messageRequest = resultName.message

if ((messageRequest == 'success') & (resultName.data.total != '')) {
	def nameSKU = resultName.data.prd[0].name
	println((skulist+ ' ') + nameSKU)
} else if ((messageRequest == 'success') & (resultName.data.total == '')) {
	println(('SKU ' + skulist) + ' Tidak Ditemukan')
} else if (messageRequest != 'success') {
	println('Error System')
}