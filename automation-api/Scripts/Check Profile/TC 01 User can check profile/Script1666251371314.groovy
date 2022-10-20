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

loginResponse = WS.sendRequest(findTestObject('API Builder Studio/Login'))

WS.verifyResponseStatusCode(loginResponse, 200)

WS.verifyElementPropertyValue(loginResponse, 'user.email', 'agungjayasaputraa@gmail.com')

jwtToken = WS.getElementPropertyValue(loginResponse, 'user.authtoken')

println('INI TOKEN DARI LOGIN' + jwtToken)

WS.sendRequest(findTestObject('API Builder Studio/Profile', [('token') : jwtToken]))

WS.verifyResponseStatusCode(loginResponse, 200)

WS.verifyElementPropertyValue(loginResponse, 'first_name', null)

WS.verifyElementPropertyValue(loginResponse, 'last_name', null)

