package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC013_ViewDocumentinTOC extends ProjectMethods{

	@BeforeClass
	public void setData() {
		dataSheetName = "TC013_ViewDocumentinTOC";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	public void viewDocument(String userName, String passWord, String levelName, String documentNumber) throws Throwable {
		
		testCaseName = "TC013 ";
		testDescription = "View documents in TOC";
		test = startTestCase(testCaseName, testDescription);
		
		
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickOnDocumentsMenu()
		.viewDocumentinTOC(levelName, documentNumber);
		
		
	}

	
}
