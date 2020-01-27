package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class NewDocumentDraft extends ProjectMethods{

	
	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleFrame;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSelectLevel']")
	private WebElement eleClickOnSelectLevelButton;
	
	@FindBy(how=How.ID,using="txtSearchTree_tvDocument")
	private WebElement eleEnterSearchCriteria;
	
	@FindBy(how=How.ID,using="dpSearch")
	private WebElement eleClickonSearchIcon;
	
	//@FindBy(how=How.XPATH,using="//span[text()='01.QCL']")
	//private WebElement eleClickOnLevel;
	
	@FindBy(how=How.ID,using="levelsubmit")
	private WebElement eleClickonDoneButton;
	

	@FindBy(how=How.ID,using="txtDocNumberValue")
	private WebElement eleEnterDocNum;
	
	@FindBy(how=How.ID,using="txtDocNameValue")
	private WebElement eleEnterDocName;
	
	@FindBy(how=How.ID,using="fileUploadControl")
	private WebElement eleAttachDoc;
	
	@FindBy(how=How.ID,using="imgSearch")
	private WebElement eleClickOnDraftViewersIcon;
	
	
	@FindBy(how=How.XPATH,using="//iframe[@id='ifrUsers']")
	private WebElement eleUserFrame;
	
	
	@FindBy(how=How.XPATH,using="//input[@value='userBased']")
	private WebElement eleCLickOnUserBasedSearchRadioButton ;
	
	@FindBy(how=How.ID,using="gs_Empcode")
	private WebElement eleEnterCode ;
	
	@FindBy(how=How.XPATH,using="(//a[@class='soptclass']//img[1])[1]")
	private WebElement eleCLickOnSearchFilter ;
	
	@FindBy(how=How.XPATH,using="//td[text()='equal']")
	private WebElement eleCLickonEqualsfilter ;
	

	
	@FindBy(how=How.CLASS_NAME, using="cbox")
	private WebElement eleClickOnUserToSelect;
	
	@FindBy(how=How.XPATH,using="//input[@value='Done']")
	private WebElement eleClickOnDone;
	
	@FindBy(how=How.ID,using="btnContinue")
	private WebElement eleClickOnContinueButton;

	@FindBy(how=How.ID,using="ifrpopuplevel")
	private WebElement eleLevelPopupFrame;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='ifr-user']")
	private WebElement eleUserFrame1;
	
	
	
	public NewDocumentDraft(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
	
	}

	public NewDocumentDraft uploadNewDraft(String searchCriteria,String documentNumber,String documentName,String attachment,String code ) throws Throwable {
		
		switchToFrame(eleFrame);
		click(eleClickOnSelectLevelButton);
		//switchToWindow(0);
		switchToFrame(eleLevelPopupFrame);
		Thread.sleep(50000);
		click(eleEnterSearchCriteria);
		type(eleEnterSearchCriteria, searchCriteria);
		click(eleClickonSearchIcon);
		WebElement eleClickOnLevel=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
		click(eleClickOnLevel);
		click(eleClickonDoneButton);
		//switchToWindow(1);
		switchToFrame(eleFrame);
		type(eleEnterDocNum, documentNumber);
		type(eleEnterDocName, documentName);
		click(eleAttachDoc);
		uploadDocument(attachment);
		click(eleClickOnDraftViewersIcon);
		switchToFrame(eleUserFrame);
		click(eleCLickOnUserBasedSearchRadioButton);
		switchToFrame(eleUserFrame1);
		Thread.sleep(15000);
		type(eleEnterCode, code);
		click(eleCLickOnSearchFilter);
		click(eleCLickonEqualsfilter);
		driver.findElementById("gs_Empcode").sendKeys(Keys.ENTER);
		click(eleClickOnUserToSelect);
		click(eleClickOnDone);
		switchToFrame(eleFrame);
		click(eleClickOnContinueButton);
		
		//Thread.sleep(5000);
		
		return this;
		
		
		
		
		
	}
}
