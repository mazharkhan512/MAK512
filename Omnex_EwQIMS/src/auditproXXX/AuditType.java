package auditproXXX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuditType {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://192.168.100.248/EwQIMS_Inst2");

		driver.findElement(By.id("txtUsername")).sendKeys("m1");
		driver.findElement(By.id("txtPassword")).sendKeys("m1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		driver.findElement(By.id("imglistModules")).click();
		driver.findElement(By.id("auditpro")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Groups']")).click();
		Thread.sleep(4000);
		
		
		
		
	}

}
