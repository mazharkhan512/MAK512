package auditproXXX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuditType {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://192.168.100.47/EwQIMS_Inst1");

		driver.findElement(By.id("txtUsername")).sendKeys("m1");
		driver.findElement(By.id("txtPassword")).sendKeys("m1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
		driver.findElement(By.id("imglistModules")).click();
		driver.findElement(By.id("auditpro")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"ui-id-8\"]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Audit Types')]")).click();				
		Thread.sleep(2000);

		WebElement frames = driver.findElement(By.id("Detailview"));
		driver.switchTo().frame(frames);

		// Adding Audit type 1
		driver.findElement(By.id("btn_Grid_AuditTypes_iladd")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("jqg1_AuditTypeName")).sendKeys("EHS Registrar Certification Audit");		
		driver.findElement(By.id("Grid_AuditTypes_toppager_center")).click();
		driver.findElement(By.id("btn_Grid_AuditTypes_ilsave")).click();

		System.out.println("Audit type 1 added successfully");

		// Adding Audit type 2
		driver.findElement(By.id("btn_Grid_AuditTypes_iladd")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("jqg1_AuditTypeName")).sendKeys("EHS Registrar Re-Certification Audit");		
		driver.findElement(By.id("Grid_AuditTypes_toppager_center")).click();
		driver.findElement(By.id("btn_Grid_AuditTypes_ilsave")).click();

		System.out.println("Audit type 2 added successfully");


		// Adding Audit type 3
		driver.findElement(By.id("btn_Grid_AuditTypes_iladd")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("jqg1_AuditTypeName")).sendKeys("QMS Registrar Assumption Audit");		
		driver.findElement(By.id("Grid_AuditTypes_toppager_center")).click();
		driver.findElement(By.id("btn_Grid_AuditTypes_ilsave")).click();

		System.out.println("Audit type 3 added successfully");
		
		System.out.println("Audit Type added successfully");


	}

}
