package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC011_DraftRequestsNeedingViewing extends ProjectMethods{
	

@BeforeClass
public void setData() {
	dataSheetName = "TC011_DraftRequestsNeedingViewing";
	test = startTestCase("Smoketesttarts", "Browser launched successfully");
	category= "Smoke";
	authors	="Bhuvana";
	browserName ="chrome";
}

@Test(dataProvider="fetchData")

public void changedraftToDocument(String userName, String passWord,String documentName,String attachment,String draftComments) throws Throwable {
	testCaseName = "TC011 ";
	testDescription = "Draft Viewer provide the comments and attach the document for the requested draft";
	test = startTestCase(testCaseName, testDescription);
	
	new LoginPage(driver,test)
	
	.moduleLandingPageLogin(userName, passWord)
	.clickonDocumentstab()
	.clickOnActionsMenu()
	.draftRequestsNeedingViewing(documentName, attachment, draftComments);

}

}