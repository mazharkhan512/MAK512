package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC015_ValidateDocDetails extends ProjectMethods {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC015_ValidateDocDetails";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	public void ValidateDocDetails(String userName, String passWord, String levelName, String documentNumber,String documentName,String revision,String docOwner) throws Throwable {
		testCaseName = "TC015 ";
		testDescription = "Validate the published document details are revised after doing the change request";
		test = startTestCase(testCaseName, testDescription);
		
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickOnDocumentsMenu()
		.validateDocISRevised(levelName, documentNumber, documentName, revision, docOwner);
	
	
		
		
	}

	
}
