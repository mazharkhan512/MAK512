package auditpro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserCreation {

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.100.248/EwQIMS_Inst2");
		driver.findElement(By.id("txtUsername")).sendKeys("administrator");
		driver.findElement(By.id("txtPassword")).sendKeys("a1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();

		// option to press button manually
		// driver.findElement(By.xpath("(//input[@type='button'])[2]")).sendKeys(Keys.ENTER);


		driver.findElement(By.id("ui-id-2")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Create Users']")).click();
		WebElement frames = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(frames);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@title='Add']")).click();
		Thread.sleep(8000);

		//driver.close();
		// Scheduler 

		driver.findElement(By.id("txtcode")).sendKeys("OSS-86");
		driver.findElement(By.id("txtfirstname")).sendKeys("Mazhar");
		driver.findElement(By.id("txtlastname")).sendKeys("Khan");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APScheduler1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("m1");
		driver.findElement(By.id("txtpassword")).sendKeys("m1");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("m1");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);
		//

		// Auditor 1 

		driver.findElement(By.id("txtcode")).sendKeys("AU1");
		driver.findElement(By.id("txtfirstname")).sendKeys("Steve");
		driver.findElement(By.id("txtlastname")).sendKeys("Smith");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APLauditor1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a1");
		driver.findElement(By.id("txtpassword")).sendKeys("a1");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a1");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();        
		Thread.sleep(8000);

		// Auditor 2 
		driver.findElement(By.id("txtcode")).sendKeys("AU2");
		driver.findElement(By.id("txtfirstname")).sendKeys("Chad");
		driver.findElement(By.id("txtlastname")).sendKeys("Kymal");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APLauditor2@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a2");
		driver.findElement(By.id("txtpassword")).sendKeys("a2");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a2");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();        
		Thread.sleep(8000);


		// Auditor 3 
		driver.findElement(By.id("txtcode")).sendKeys("AU3");
		driver.findElement(By.id("txtfirstname")).sendKeys("Brad");
		driver.findElement(By.id("txtlastname")).sendKeys("Smith");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APLauditor3@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a3");
		driver.findElement(By.id("txtpassword")).sendKeys("a3");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a3");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Auditor 4 
		driver.findElement(By.id("txtcode")).sendKeys("AU4");
		driver.findElement(By.id("txtfirstname")).sendKeys("Bradly");
		driver.findElement(By.id("txtlastname")).sendKeys("watson");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APLauditor4@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a4");
		driver.findElement(By.id("txtpassword")).sendKeys("a4");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a4");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);

		// Auditee 1 
		driver.findElement(By.id("txtcode")).sendKeys("AE1");
		driver.findElement(By.id("txtfirstname")).sendKeys("Steve");
		driver.findElement(By.id("txtlastname")).sendKeys("jobs");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APPCauditee1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a11");
		driver.findElement(By.id("txtpassword")).sendKeys("a1");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a1");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Auditee 2 
		driver.findElement(By.id("txtcode")).sendKeys("AE2");
		driver.findElement(By.id("txtfirstname")).sendKeys("Stephen");
		driver.findElement(By.id("txtlastname")).sendKeys("Hooks");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APPCauditee2@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a22");
		driver.findElement(By.id("txtpassword")).sendKeys("a2");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a2");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);

		// Auditee 3 
		driver.findElement(By.id("txtcode")).sendKeys("AE3");
		driver.findElement(By.id("txtfirstname")).sendKeys("Robert");
		driver.findElement(By.id("txtlastname")).sendKeys("Bosch");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APPCauditee3@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a33");
		driver.findElement(By.id("txtpassword")).sendKeys("a3");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a3");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Auditee 4 
		driver.findElement(By.id("txtcode")).sendKeys("AE4");
		driver.findElement(By.id("txtfirstname")).sendKeys("Anna");
		driver.findElement(By.id("txtlastname")).sendKeys("Luise");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APPCauditee4@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("a44");
		driver.findElement(By.id("txtpassword")).sendKeys("a4");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a4");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Program manager 
		driver.findElement(By.id("txtcode")).sendKeys("APPM");
		driver.findElement(By.id("txtfirstname")).sendKeys("Terance");
		driver.findElement(By.id("txtlastname")).sendKeys("Luise");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APPmanager1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("aa7");
		driver.findElement(By.id("txtpassword")).sendKeys("a7");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a7");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Approver 1
		driver.findElement(By.id("txtcode")).sendKeys("APAR1");
		driver.findElement(By.id("txtfirstname")).sendKeys("Tony");
		driver.findElement(By.id("txtlastname")).sendKeys("Jaa");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APApprover1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("aa5");
		driver.findElement(By.id("txtpassword")).sendKeys("a5");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a5");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);

		// Approver 2
		driver.findElement(By.id("txtcode")).sendKeys("APAR2");
		driver.findElement(By.id("txtfirstname")).sendKeys("John");
		driver.findElement(By.id("txtlastname")).sendKeys("Carter");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APApprover2@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("aa6");
		driver.findElement(By.id("txtpassword")).sendKeys("a6");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a6");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);


		// Responsible person 1
		driver.findElement(By.id("txtcode")).sendKeys("APRP");
		driver.findElement(By.id("txtfirstname")).sendKeys("France");
		driver.findElement(By.id("txtlastname")).sendKeys("law");
		driver.findElement(By.id("txtbusinessmail")).sendKeys("APSCAuditee1@omnexqa.com");
		driver.findElement(By.id("txtusername")).sendKeys("aa8");
		driver.findElement(By.id("txtpassword")).sendKeys("a8");
		driver.findElement(By.id("txtconfirmpassword")).sendKeys("a8");
		driver.findElement(By.id("Changelogin")).click();
		driver.findElement(By.id("btnSaveandAdd")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(8000);



		System.out.println("Users Successfully added to instance");
		driver.quit();
	}

}

