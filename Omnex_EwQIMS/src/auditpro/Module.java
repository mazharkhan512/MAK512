package auditpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.100.47:8080/Common/EwIMSNew/homepage/Index");

		driver.findElement(By.id("txtUsername")).sendKeys("administrator");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		driver.findElement(By.xpath("//a[@title='Modules']")).click();

		// option to press button manually
		// driver.findElement(By.xpath("(//input[@type='button'])[2]")).sendKeys(Keys.ENTER);

		WebElement frames = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(frames);
		Thread.sleep(8000);
		driver.findElement(By.id("ddl_Module_chzn")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("ddl_Module_chzn_o_2")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		Thread.sleep(8000);
		WebElement frames1 = driver.findElement(By.id("ifrUsers"));
		driver.switchTo().frame(frames1);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id=\"gs_Empcode\"]")).sendKeys("86");
		
		driver.findElement(By.id("gs_Empcode")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("jqg_userListingGridControl_1")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[3]")).click();

		WebElement frames2 = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(frames2);
		Thread.sleep(8000);
		driver.findElement(By.id("ddl_Module_chzn")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("ddl_Module_chzn_o_5")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("gs_Empcode")).sendKeys("86");
		driver.findElement(By.id("gs_Empcode")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("jqg_userListingGridControl_1")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[3]")).click();
		driver.quit();
		System.out.println("Group access provided to selected users");
	}


}

