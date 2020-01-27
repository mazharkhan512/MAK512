package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class DocProAdminHomePage extends ProjectMethods {
	

	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Folder Management')]")
	WebElement  eleClickOnFolderMgmt;
	
	@FindBy(how=How.LINK_TEXT,using="Documents")
	private WebElement eleClickOnDocumentsTab;
	
	@FindBy(how=How.LINK_TEXT,using="New Document Request")
	private WebElement eleClickOnNewDocumentRequestMenu;
	
	@FindBy(how=How.LINK_TEXT,using="New Document Draft")
	private WebElement eleClickOnDocumentDraftMenu;
	
	@FindBy(how=How.LINK_TEXT,using="Actions")
	private WebElement eleClickOnActionsMenu;
	
	//@FindBy(how=How.XPATH,using="//img[@src='http://192.168.100.249/EwQIMS_Inst3//App_Themes/EwQIMS-Theme//images/docpro/icon-docpro-user-toc.png']")
	@FindBy(how=How.LINK_TEXT,using="Documents")
	private WebElement eleClickOnDocumentsMenu;
	
	
	@FindBy(how=How.LINK_TEXT,using="Groups")
	private WebElement eleclickOnGroupsMenu;
	
	
	public DocProAdminHomePage(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
	
	}
	
	public FolderManagement clickOnFolderManagement() throws Throwable {
		Thread.sleep(5000);
		click(eleClickOnFolderMgmt);
		return new FolderManagement(driver,test);
	}
	
	public   DocProAdminHomePage clickonDocumentstab() {
		
		click(eleClickOnDocumentsTab);
		return this;
		
	}
	
	public   NewDocumentsRequest clickonNewDocumentRequestmenu() {
		
		
		click(eleClickOnNewDocumentRequestMenu);
		return new NewDocumentsRequest(driver, test);
		
	}
	
	public NewDocumentDraft clickOnNewDocDraftmenu() {
		
		click(eleClickOnDocumentDraftMenu);
		return new NewDocumentDraft(driver, test);
		
	}
	
	public Actions clickOnActionsMenu() {
		click(eleClickOnActionsMenu);
		return new Actions(driver, test);
		
	}
	
	public TOC clickOnDocumentsMenu() {
		click(eleClickOnDocumentsMenu);
		return new TOC(driver, test);
		
	}
	
	public DocProGroups clickOnGroupsMenu() {
		click(eleclickOnGroupsMenu);
		
		return new DocProGroups(driver, test);
		
	}
	

}
