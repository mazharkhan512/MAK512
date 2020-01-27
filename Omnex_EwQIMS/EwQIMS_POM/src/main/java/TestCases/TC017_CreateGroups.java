package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC017_CreateGroups extends ProjectMethods {
	
	@BeforeClass
	public void setData() {
		dataSheetName = "TC017_CreateGroups";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData")
	
	public void createGroups(String userName, String passWord, String groupName, String code) throws Throwable {
		testCaseName = "TC017 ";
		testDescription = "Create an admin group";
		test = startTestCase(testCaseName, testDescription);
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickOnGroupsMenu()
		.createAdminGroup(groupName, code);
	}
		
		
		
		
	}

	
	


