package auditpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Access {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ewl.ewqims.com ");
		driver.findElement(By.id("txtUsername")).sendKeys("m1");
		driver.findElement(By.id("txtPassword")).sendKeys("m1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		driver.findElement(By.id("imglistModules")).click();
		driver.findElement(By.id("auditpro")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Groups']")).click();
		Thread.sleep(4000);
		WebElement frames = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(frames);
		Thread.sleep(8000);

		//Schdeuler
		driver.findElement(By.id("btn_SuGroupsGridViewControl_iladd")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@class='editable']")).sendKeys("Scheduler1");
		driver.findElement(By.id("btn_SuGroupsGridViewControl_ilsave")).click();
		driver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//td[contains(text(),'Scheduler1')]//parent::tr//img[@title='Add Users']")).click();
		Thread.sleep(4000);


		WebElement frames1 = driver.findElement(By.id("ifrUsers"));
		driver.switchTo().frame(frames1);
		WebElement frames2 = driver.findElement(By.id("ifr-user"));	
		driver.switchTo().frame(frames2);

		Thread.sleep(4000);

		driver.findElement(By.id("gs_Empcode")).sendKeys("APS1");
		driver.findElement(By.id("gs_Empcode")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("cb_userListingGridControl")).click();
		driver.switchTo(). parentFrame();
		Thread.sleep(5000);
		driver.findElement(By.id("chkType_Admin")).click();
		driver.findElement(By.id("chkType_Reports")).click();
		driver.findElement(By.id("save")).click();
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("Togglemenu")).click();	
		System.out.println("Scheduler group created with scheduler access");



		//Auditor
		Thread.sleep(4000);

		WebElement framesA = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(framesA);

		driver.findElement(By.id("btn_SuGroupsGridViewControl_iladd")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='editable']")).sendKeys("Auditor1");

		driver.findElement(By.id("btn_SuGroupsGridViewControl_ilsave")).click();

		driver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//td[contains(text(),'Auditor1')]//parent::tr//img[@title='Add Users']")).click();
		Thread.sleep(4000);
		
		WebElement frames3 = driver.findElement(By.id("ifrUsers"));
		driver.switchTo().frame(frames3);
		WebElement frames4 = driver.findElement(By.id("ifr-user"));	
		driver.switchTo().frame(frames4);
		
		Thread.sleep(4000);
		driver.findElement(By.id("gs_Empcode")).sendKeys("AU");
		driver.findElement(By.id("gs_Empcode")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("cb_userListingGridControl")).click();
		driver.switchTo(). parentFrame();
		Thread.sleep(5000);
		driver.findElement(By.id("chkType_Auditor")).click();
		driver.findElement(By.id("save")).click();
		driver.findElement(By.id("popup_ok")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.id("Togglemenu")).click();	
		System.out.println("Auditor group created with Auditor access");
		
		//Auditee
		
		
		
		

	}


}


