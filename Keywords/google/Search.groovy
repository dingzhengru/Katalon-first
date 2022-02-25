package google

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Search {
	@Keyword
	def static void submitSearch(String url,String search){

		WebUI.openBrowser(url)
//		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Google/input_search'), GlobalVariable.waitPresentTimeout)

		WebUI.sendKeys(findTestObject('Google/input_search'), search)
		WebUI.click(findTestObject('Google/input_submit'))
		WebUI.delay(1)
		WebUI.closeBrowser()
	}
	@Keyword
	def static void submitSearchWithGlobalVariable(){
		submitSearch(GlobalVariable.baseUrl, GlobalVariable.searchValue)
	}
	@Keyword
	def static void submitSearchMultiWithGlobalVariable(){
		for (val in GlobalVariable.searchValueList) {
			submitSearch(GlobalVariable.baseUrl, val)
		}
	}
}
