package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class TC006to10_LevelCreation_Activation_PublishDocument_PublishDraft extends ProjectMethods {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC006to10";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData",groups="smoke")
	
	public void createParentLevels(String TestcaseNumber,String Scenario, String userName, String passWord,String levelName,String prefix,String reviewDue,String searchCriteria,String subLevelName,String subPrefix,String subReviewDue,String documentNumber,String documentName,String attachment,String code) throws Throwable {
		
		testCaseName = TestcaseNumber ;
		testDescription = Scenario;
		test = startTestCase(testCaseName, testDescription);
	
		switch(TestcaseNumber) {
		
		case"TC006":
		
		
		new LoginPage(driver,test)
		.login(userName, passWord)
		.clickOnLevelsMenu()
		.createParentLevels( levelName, prefix, reviewDue);
		break;
		
		case"TC007":
		
		
		new LoginPage(driver,test)
		.login(userName, passWord)
		.clickOnLevelsMenu()
		.createSubLevels(searchCriteria, levelName,subLevelName, subPrefix, subReviewDue);
		break;
		
		case "TC008":
		
		
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickOnFolderManagement() 
		.inUseFolder(searchCriteria);
		
		
		case "TC009":
			
	
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickonNewDocumentRequestmenu()
		.uploadNewDocument(searchCriteria,documentNumber,documentName,attachment);
		
		case "TC010":
			
	
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickOnNewDocDraftmenu()
		.uploadNewDraft(searchCriteria,documentNumber,documentName,attachment,code) ;
		
		
		
		default:
		break;
			
		
		
		}
		
	}
	
	
}
