package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class FolderManagement extends ProjectMethods {

	
	@FindBy(how=How.ID,using="txtSearchTree_TOCDoclvl")
	private WebElement  eleEnterSearchCriteria;
	
	@FindBy(how=How.ID,using="dpSearch'")
	private WebElement  eleClickOnSearch;
	
	
	//@FindBy(how=How.XPATH,using="//span[text()='01.QCL']")
	//private WebElement eleClickOnLevel;
	
	@FindBy(how=How.ID,using="chkInUse")
	private WebElement  eleClickOnInUse;
	

	@FindBy(how=How.XPATH,using="//iframe[@id='iframeTree']")
	private WebElement eleRHSFrame;
	
	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private static WebElement  eleLHSFrame;
	


	@FindBy(how=How.XPATH,using="//span[text()='User Defined Document Number']")
	private WebElement eleSelectDocumentNumberOption;
	
	@FindBy(how=How.ID,using="drpDocNumOpt_chzn_o_2")
	private WebElement eleSelectUseInternalidasDocNUMOption;
	
	@FindBy(how=How.XPATH,using="//span[text()='DocPro automatically increments by 1']")
	private WebElement eleSelectRevisionNumberOption;
	
	@FindBy(how=How.ID,using="drpRevOpt_chzn_o_2")
	private WebElement eleSelectCustomRevision;
	
	
	@FindBy(how=How.ID,using="drpRevSegMajor")
	private WebElement eleSelectMajorRevision;
	
	@FindBy(how=How.XPATH,using="//option[text()='A']")
	private WebElement eleSelectAasMajorRevision;
	
	@FindBy(how=How.ID,using="drpRevSegMinor")
	private WebElement eleSelectMinorRevision;
	
	@FindBy(how=How.XPATH,using="(//option[text()='I'])[2]")
	private WebElement eleSelectIasMinorRevision;
	
	@FindBy(how=How.XPATH,using="//span[text()='OK']")
	private WebElement eleclickOKtoSetMajorMinorRevs;
	

	@FindBy(how=How.ID,using="popup_ok")
	private WebElement eleclickOktoAlertMessage;
	
	
	@FindBy(how=How.ID,using="btnSave")
	private WebElement  eleClickOnSavetoActivateFolder;
	
	
	@FindBy(how=How.ID,using="aSiterights")
	private WebElement  eleClickOnAccessforSites;
	
	
	@FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_noaccess']/input")
	private WebElement  eleCLickOnNoAccessForFolder;
	
	
	@FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_noaccess_Doc']/input")
	private WebElement  eleCLickOnNoAccessForDocument;
	
	@FindBy(how=How.ID,using="aGrouprights")
	private WebElement  eleClickOnAccessforGroups;
	
	
	@FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_Inherit']/input")
	private WebElement  eleUncheckInheritOptionForFolder;
	
	
	@FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_Attachright']/input")
	private WebElement  eleClickOnAttachRightForFolder;
	
	
	
	
	
	
	public FolderManagement(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
		
		}
	
	
	public void clickOnSearchicon() {
		
		click(eleClickOnSearch);
		}
	
	public void switchToRHSFrame() {
		
		switchToFrame(eleRHSFrame);
	}
	
public  void switchToLHSFrame() {
		
		switchToFrame(eleLHSFrame);
	}
	
	public FolderManagement inUseFolder(String searchCriteria) throws Throwable {
		
		switchToLHSFrame();
		type(eleEnterSearchCriteria, searchCriteria);
		clickOnSearchicon();
		WebElement eleClickOnLevel=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
		click(eleClickOnLevel);
		switchToRHSFrame();
		click(eleClickOnInUse);
		//click(eleSelectDocumentNumberOption);
		//click(eleSelectUseInternalidasDocNUMOption);
		click(eleSelectRevisionNumberOption);
		click(eleSelectCustomRevision);
		
		System.out.println("By default 2 number of segments");
		click(eleSelectMajorRevision);
		click(eleSelectAasMajorRevision);
		click(eleSelectMinorRevision);
		click(eleSelectIasMinorRevision);
		click(eleclickOKtoSetMajorMinorRevs);
		click(eleClickOnSavetoActivateFolder);
		click(eleclickOktoAlertMessage);
		
		return this;
	}
	
	public FolderManagement setFolderRights(String searchCriteria) throws Throwable {
		
		//Access for sites
		
		switchToLHSFrame();
		type(eleEnterSearchCriteria, searchCriteria);
		clickOnSearchicon();
		WebElement eleClickOnLevel=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
		rightClickAction(eleClickOnLevel);
		//Access for sites
		click(eleClickOnAccessforSites);
		switchToRHSFrame();
		click(eleCLickOnNoAccessForFolder);
		click(eleCLickOnNoAccessForDocument);
		//Access for Groups
		//Thread.sleep(5000);
		driver.switchTo().defaultContent();
		switchToLHSFrame();
		//Thread.sleep(10000);
		//WebElement eleClickOnLevel1=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
		click(eleClickOnLevel);
		rightClickAction(eleClickOnLevel);
		click(eleClickOnAccessforGroups);
		switchToRHSFrame();
		
		
		
		
		
		
		return this;
	}
	
	
	
	
}
       