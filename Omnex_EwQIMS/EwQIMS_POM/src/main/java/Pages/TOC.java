package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class TOC extends ProjectMethods{

	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleLevelsFrame;
	
	
	
	@FindBy(how=How.ID,using="txtSearchTree_TOCDoclvl")
	private WebElement  eleEnterLevelNameToSearch;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='iframeTree']")
	private WebElement eleTOCFrame;
	
	@FindBy(how=How.ID,using="dpSearch'")
	private WebElement  eleClickOnSearchIcon;
	
	@FindBy(how=How.ID,using="flashDoc")
	private WebElement  eleClickOnviewDocument;
	
	@FindBy(how=How.ID,using="CChangeRequest")
	private WebElement  eleClickOnChangeRequestOption;
	
	
	@FindBy(how=How.ID,using="attachdoc")
	private WebElement  eleClickOnChooseFileToAttachDoc;
	
	@FindBy(how=How.ID,using="reasonforreq")
	private WebElement  eleEnterReasonForRequest;
	
	@FindBy(how=How.ID,using="changesrequired")
	private WebElement  eleEnterChangesRequired;
	
	@FindBy(how=How.ID,using="btcontinue")
	private WebElement  eleClickOnContinueButton;
	
	@FindBy(how=How.ID,using="gs_number")
	private WebElement  eleEnterDocNumSearchCriteria;
	
	
	
	public TOC(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
		
		}
	
	public TOC viewDocumentinTOC(String levelName,String documentNumber) throws InterruptedException {
	
		switchToFrame(eleLevelsFrame);
		//Thread.sleep(2000);
		click(eleEnterLevelNameToSearch);
		type(eleEnterLevelNameToSearch, levelName);
		click(eleClickOnSearchIcon);
		WebElement eleClickOnLevel= driver.findElementByXPath("//span[text()='"+levelName+"']");
		click(eleClickOnLevel);
		switchToFrame(eleTOCFrame);
		WebElement eleClickOnDocumentNumberLink= driver.findElementByXPath("//a[text()='"+documentNumber+"']");
		click(eleClickOnDocumentNumberLink);
		click(eleClickOnviewDocument);
		
		
		return this;
		
	}
	
	public TOC reviseDocument(String levelName,String documentNumber,String attachment,String reasonForRequest, String changesRequired) throws Throwable {
		
		switchToFrame(eleLevelsFrame);
		//Thread.sleep(2000);
		click(eleEnterLevelNameToSearch);
		type(eleEnterLevelNameToSearch, levelName);
		click(eleClickOnSearchIcon);
		WebElement eleClickOnLevel= driver.findElementByXPath("//span[text()='"+levelName+"']");
		click(eleClickOnLevel);
		switchToFrame(eleTOCFrame);
		WebElement eleRightClickOnDocumentNumberLink= driver.findElementByXPath("//a[text()='"+documentNumber+"']");
		rightClickAction(eleRightClickOnDocumentNumberLink);
		click(eleClickOnChangeRequestOption);
		click(eleClickOnChooseFileToAttachDoc);
		uploadDocument(attachment);
		type(eleEnterReasonForRequest, reasonForRequest);
		type(eleEnterChangesRequired, changesRequired);
		click(eleClickOnContinueButton);
		
		
		
		
		return this;
		
	}
	
	public TOC validateDocISRevised(String levelName,String documentNumber,String documentName,String revision,String docOwner ) {
		
		switchToFrame(eleLevelsFrame);
		//Thread.sleep(2000);
		click(eleEnterLevelNameToSearch);
		type(eleEnterLevelNameToSearch, levelName);
		click(eleClickOnSearchIcon);
		WebElement eleClickOnLevel= driver.findElementByXPath("//span[text()='"+levelName+"']");
		click(eleClickOnLevel);
		switchToFrame(eleTOCFrame);
		type(eleEnterDocNumSearchCriteria, documentNumber);
		eleEnterDocNumSearchCriteria.sendKeys(Keys.ENTER);
		WebElement eleValidateDocumentNumberLink= driver.findElementByXPath("//a[text()='"+documentNumber+"']");
		verifyExactText(eleValidateDocumentNumberLink, documentNumber);
		WebElement eleValidateDocumentName= driver.findElementByXPath("//td[text()='"+documentName+"']");
		verifyExactText(eleValidateDocumentName, documentName);
		WebElement eleValidateRevNum= driver.findElementByXPath("//td[text()='"+revision+"']");
		verifyExactText(eleValidateRevNum, revision);
		WebElement eleValidateDocOwner= driver.findElementByXPath("//td[text()='"+docOwner+"']");
		verifyExactText(eleValidateDocOwner, docOwner);
		
		
		
		return this;
		
		
	}
	
	
	
}
