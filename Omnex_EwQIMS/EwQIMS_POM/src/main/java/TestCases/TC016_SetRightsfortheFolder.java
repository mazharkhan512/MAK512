package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC016_SetRightsfortheFolder extends ProjectMethods {
	
	@BeforeClass
	public void setData() {
		dataSheetName = "SetRights";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	public void setAccessRightsfortheFolder(String userName, String passWord, String searchCriteria) throws Throwable {
		testCaseName = "TC016 ";
		testDescription = "Set rights for the folder";
		test = startTestCase(testCaseName, testDescription);
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickOnFolderManagement() 
		.setFolderRights(searchCriteria);
	}

}
