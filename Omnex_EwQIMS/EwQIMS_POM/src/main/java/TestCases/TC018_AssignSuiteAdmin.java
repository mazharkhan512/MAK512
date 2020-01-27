package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC018_AssignSuiteAdmin extends ProjectMethods {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC018_AssignSuiteAdmin";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	
	public void AssignSuiteAdmin(String userName, String passWord,  String code) throws Throwable {
		
		testCaseName = "TC018 ";
		testDescription = "Assign the user as a suite admin";
		test = startTestCase(testCaseName, testDescription);
		new LoginPage(driver,test)
		.login(userName, passWord)
		.clickOnSuiteAdminMenu()
		.setUserAsSuiteAdmin(code);
	}
	
}

