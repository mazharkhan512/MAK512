package auditpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuiteAdmin {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.get("http://192.168.100.248/EwQIMS_Inst2");

		driver.manage().window().maximize();	

		driver.findElement(By.id("txtUsername")).sendKeys("administrator");

		driver.findElement(By.id("txtPassword")).sendKeys("a1");

		driver.findElement(By.xpath("(//input[@type='button'])[2]")).sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		// Clicking on Suite icon

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[@title='Suite Administrator']")).click();

		Thread.sleep(4000);		

		// iFrame = Detailview

		WebElement frames = driver.findElement(By.id("Detailview"));

		driver.switchTo().frame(frames);

		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@title='Select User']")).click(); 

		//Thread.sleep(5000);

		WebElement frames1 = driver.findElement(By.id("ifrUsers"));

		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frames1));

		WebElement frames2 = driver.findElement(By.id("ifr-User"));
		
		

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frames2));

		Thread.sleep(4000);

		/*
		WebElement frames2 = driver.findElement(By.id("ifr-User"));

		driver.switchTo().frame(frames2);

		Thread.sleep(10000);

		 */

		driver.findElement(By.id("gs_Empcode")).sendKeys("86");


	}


}

