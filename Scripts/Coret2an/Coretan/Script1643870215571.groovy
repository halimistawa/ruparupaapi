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

//  substring
if(getMessageSO.contains('VNA') && getMessageSO.contains('VOA') && getMessageSO.contains('VQA'))
{
	def getIndexVNA = getMessageSO.toString().indexOf('VNA')
	def noVNA = getMessageSO.toString().subSequence(getIndexVNA-4, getIndexVNA-4+15)
	def getIndexVOA = getMessageSO.toString().indexOf('VOA')
	def noVOA = getMessageSO.toString().subSequence(getIndexVOA-4, getIndexVOA-4+15)
	def getIndexVQA = getMessageSO.toString().indexOf('VQA')
	def noVQA = getMessageSO.toString().subSequence(getIndexVQA-4, getIndexVQA-4+15)
	def getIndexVEA = getMessageSO.toString().indexOf('VEA')
	def noVEA = getMessageSO.toString().subSequence(getIndexVEA-4, getIndexVEA+24)
	println('Opportunity : '+noVNA+ ' Quotation : '+noVOA+ ' Sales Order : '+noVQA+' \nTicket : '+noVEA)
}else println(getMessageSO)


//def HitungArray = new groovy.json.JsonSlurper()
Map parsedJson = getRegion.parseText(responseGetRegion.getResponseBodyContent())
String parsed_datalist = parsedJson["DataList"]
println parsedJson.get("DataList").size()
def TotalData = parsedJson.get("DataList").size()

println TotalData
println('Region Awal :'+resultRegion.DataList[0].Description)
println('Region Terakhir :'+resultRegion.DataList[TotalData-1].Description)


/////////////////////////////////////////////////////////////////////////////////
for(int i=0; i<=5;i++)
{
   //println('Region : '+resultRegion.DataList[i].Description+' ')
   //ReportRegion = ReportRegion + resultRegion.DataList[i].Description
   if(i < 5)
   {
	   ReportRegion = ReportRegion + resultRegion.DataList[i].Description+', '
   }
   else
   {
	   ReportRegion = ReportRegion + resultRegion.DataList[i].Description
   }
}
println('Region :'+ReportRegion)