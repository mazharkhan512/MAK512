package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC012_PendingDocumentDrafts extends ProjectMethods{
	
	


@BeforeClass
public void setData() {
	dataSheetName = "TC012_PendingDocumentDrafts";
	test = startTestCase("Smoketesttarts", "Browser launched successfully");
	category= "Smoke";
	authors	="Bhuvana";
	browserName ="chrome";
}

@Test(dataProvider="fetchData")

public void changedraftToDocument(String userName, String passWord,String documentName,String attachment,String reasonForRequest,String changesRequired ) throws Throwable {
	testCaseName = "TC012 ";
	testDescription = "Draft requester Convert the draft to document";
	test = startTestCase(testCaseName, testDescription);
	
	new LoginPage(driver,test)
	.moduleLandingPageLogin(userName, passWord)
	.clickonDocumentstab()
	.clickOnActionsMenu()
	.pendingDocumentDrafts(documentName, attachment, reasonForRequest, changesRequired);
	
	
}

	
}