package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC014_DocumentRevision extends ProjectMethods {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC014_ReviseDocument";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	public void DocumentRevision(String userName, String passWord, String levelName, String documentNumber,String attachment,String reasonForRequest,String changesRequired) throws Throwable {
		testCaseName = "TC014 ";
		testDescription = "Initiate change request for the document(Document Revision)";
		test = startTestCase(testCaseName, testDescription);
		
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickOnDocumentsMenu()
	    .reviseDocument(levelName, documentNumber, attachment, reasonForRequest, changesRequired);
	
		
		
	}

	
}

