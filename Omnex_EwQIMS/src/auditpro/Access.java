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

		driver.get("http://192.168.100.47:8080/Common/EwIMSNew/homepage/Index");

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
		Thread.sleep(8000);


		WebElement frames1 = driver.findElement(By.id("ifrUsers"));
		driver.switchTo().frame(frames1);
		
		WebElement frames2 = driver.findElement(By.id("ifr-user"));
		driver.switchTo().frame(frames2);
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.id("gs_Empcode")).sendKeys("86");
		driver.findElement(By.id("gs_Empcode")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("cb_userListingGridControl")).click();
		Thread.sleep(4000);	
		driver.switchTo(). parentFrame();	
		driver.findElement(By.id("chkType_Admin")).click();
		driver.findElement(By.id("save")).click();
		System.out.println("ok user page is displaying and user added to the group");
		Thread.sleep(8000);


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		// xpath for user icon (//td[contains(text(),'Scheduler')])//parent::tr//img[@title='Add Users']

		//driver.findElement(By.xpath("(//td[contains(text(),'Auditor')])//parent::tr//img[@title='Add Users']")).click();


	}


}