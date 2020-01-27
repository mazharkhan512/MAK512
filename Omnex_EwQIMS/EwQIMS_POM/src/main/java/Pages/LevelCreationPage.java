package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class LevelCreationPage extends ProjectMethods {


	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleLevelsFrame;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='iframeTree']")
	private WebElement eleLevelsTreeFrame;

	@FindBy(how=How.ID,using="txtLevelName")
	private WebElement eleLevelName;
	
	@FindBy(how=How.ID,using="txtPrefix")
	private WebElement elePrefix;
	
	@FindBy(how=How.ID,using="txtReviewUnit")
	private WebElement eleReviewDue;
	
	@FindBy(how=How.ID,using="chkSiteMod")
	private WebElement eleAllowSiteModification;
	
	@FindBy(how=How.ID,using="chkAllowSiteSub")
	private WebElement eleAllowSubLevelcreation;
	
	
	@FindBy(how=How.ID,using="btnSave")
	private WebElement eleClickOnSave;
	

	@FindBy(how=How.ID,using="popup_ok")
	private WebElement eleClickOktoAlertmsg;
	
	@FindBy(how=How.ID,using="txtSearchTree_TOCDoclvl")
	private WebElement eleEnterSearchCriteria;
	
	@FindBy(how=How.ID,using="dpSearch'")
	private WebElement eleClickOnSearch;
	
	//@FindBy(how=How.XPATH,using="//span[text()='QMS CheckLists']")
	//private WebElement eleRightClick;
	
	@FindBy(how=How.ID,using="divNewFolder")
	private WebElement eleClickNew;
	
	
	
	
	
	public LevelCreationPage(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
	}

		
	
	public LevelCreationPage createParentLevels(String levelName,String prefix,String reviewDue) {
		
		switchToFrame(eleLevelsFrame);
		switchToFrame(eleLevelsTreeFrame);
		type(eleLevelName, levelName);
		type(elePrefix, prefix);
		type(eleReviewDue, reviewDue);
		click(eleAllowSiteModification);
		click(eleAllowSubLevelcreation);
		click(eleClickOnSave);
		click(eleClickOktoAlertmsg);
		return this;
		}
	
	public LevelCreationPage createSubLevels(String searchCriteria,String levelName,String subLevelName,String subPrefix,String subReviewDue) throws Throwable {
		
		switchToFrame(eleLevelsFrame);
		
		type(eleEnterSearchCriteria, searchCriteria);
		//Thread.sleep(2500);
		click(eleClickOnSearch);
		//Thread.sleep(12500);
		WebElement eleRightClick= driver.findElementByXPath("//span[text()='"+levelName+"']");
		rightClickAction(eleRightClick);
		click(eleClickNew);
		switchToFrame(eleLevelsTreeFrame);
		type(eleLevelName, subLevelName);
		type(elePrefix, subPrefix);
		type(eleReviewDue, subReviewDue);
		click(eleAllowSiteModification);
		click(eleAllowSubLevelcreation);
		click(eleClickOnSave);
		click(eleClickOktoAlertmsg);
	
		return this;
		
	}
	

	
}
