package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC001to5_Login_UserCreation_AssignModuleAdmin_ModuleLandingPage extends ProjectMethods {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC001to5";
		test = startTestCase("Smoketesttarts", "Brower launched successfully");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData", groups="smoke")

	public void login(String TestcaseNumber, String Scenario, String userName, String passWord, String code,
			String fName, String lName, String eMail, String uName, String pwd, String confirmPassword)
			throws Throwable {

		testCaseName = Scenario  ;
		testDescription =TestcaseNumber ;
		test = startTestCase(testCaseName, testDescription);
		
		
		switch (TestcaseNumber) {

		case "TC001":
		
			new LoginPage(driver, test).login(userName, passWord);
			break;

		case "TC002":
			new LoginPage(driver, test).invalidLogin(userName, passWord);
			break;

		case "TC003":
			new LoginPage(driver, test).login(userName, passWord).clickOnUersTab().clickOnUsersMenu().addUsers(code,
					fName, lName, eMail, uName, pwd, confirmPassword);
			break;

		case "TC004":
			new LoginPage(driver, test).login(userName, passWord).clickOnModuleAdminMenu().setUserAsModuleAdmin(code);

		case "TC005":
			new LoginPage(driver, test).login(userName, passWord).clickOnUersTab().clickOnUserPrefrencesMenu()
					.setDocProasLandingPage();

		default:
			break;

		}

	}

}
