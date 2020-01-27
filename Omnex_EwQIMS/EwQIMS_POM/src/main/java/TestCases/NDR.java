package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class NDR extends ProjectMethods {
	
	@BeforeClass
	public void setData() {
		dataSheetName = "test";
		test = startTestCase("Smoketesttarts", "Brower launched successfully");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData", groups="smoke")

	public void login(String userName, String passWord,String searchCriteria, String documentNumber, String documentName,
			String attachment)
			throws Throwable {

		testCaseName = "Test"  ;
		testDescription ="test" ;
		test = startTestCase(testCaseName, testDescription);
		
		
	

	
		
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickonNewDocumentRequestmenu()
		.uploadNewDocument(searchCriteria,documentNumber,documentName,attachment);
		
		
		}

	}



