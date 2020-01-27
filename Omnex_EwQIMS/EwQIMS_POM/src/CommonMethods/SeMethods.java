package CommonMethods;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeMethods extends Raster implements WdMethods{

	protected SeMethods(SampleModel arg0, DataBuffer arg1, Point arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}


	public  RemoteServer driver;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;


	public class SeMethods()extends Reporter implements WdMethods {

		public  RemoteServer driver;
		public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

		public SeeMethods() {
			Properties prop = new Properties();
			try {
				String path = System.getProperty("user.dir");
				System.out.println(path); 
				prop.load(new FileInputStream(new File(path+"\\data\\config.properties")));

				//prop.load(new FileInputStream(new File("C:\\Users\\Omnex\\git\\EwQIMS_POM_Omnex\\EwQIMS_POM\\src\\main\\java\\data\\config.properties")));
				sHubUrl = prop.getProperty("HUB");
				sHubPort = prop.getProperty("PORT");
				sUrl = prop.getProperty("URL");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		public void startApp(String browser) {
			try {
				String path = System.getProperty("user.dir");
				if(browser.equalsIgnoreCase("chrome")) {

					System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");

					//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else if(browser.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver",path+"\\drivers\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver",path+"\\drivers\\geckodriver_32bit.exe");
					driver=new FirefoxDriver();	}
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				driver.get(sUrl);

				driver.manage().window().maximize();



				reportStep("The browser:" + browser + " launched successfully", "PASS");
			} catch (WebDriverException e) {			
				reportStep("The browser:" + browser + " could not be launched", "FAIL");
			}
		}

		public WebElement locateElement(String locator, String locValue) {
			try {
				switch(locator) {

				case("id"): return driver.findElementById(locValue);
				case("link"): return driver.findElementByLinkText(locValue);
				case("xpath"):return driver.findElementByXPath(locValue);
				case("name"): return driver.findElementByName(locValue);
				case("class"): return driver.findElementByClassName(locValue);
				case("tag"):return driver.findElementByTagName(locValue);
				}
			} catch (NoSuchElementException e) {
				reportStep("The element with locator "+locator+" and with value "+locValue+" not found.","FAIL");
				throw new RuntimeException();
			} catch (WebDriverException e) {
				reportStep("WebDriverException", "FAIL");
			}
			return null;
		}

		public WebElement locateElement(String locValue) {
			return driver.findElementById(locValue);
		}


		public void type(WebElement ele, String data) {
			try {
				ele.clear();
				ele.sendKeys(data);
				reportStep("The data: "+data+" entered successfully in field :"+ele, "PASS");
			} catch (InvalidElementStateException e) {
				reportStep("The element: "+ele+" is not interactable","FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			}
		}

		public void click(WebElement ele) {
			String text = "";
			try {
				WebDriverWait wait = new WebDriverWait(driver,100);

				wait.until(ExpectedConditions.elementToBeClickable(ele));			
				text = ele.getText();
				ele.click();
				reportStep("The element : "+text+" is clicked "+text, "PASS");
			} catch (InvalidElementStateException e) {
				reportStep("The element: "+text+" is not interactable", "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			} 

		}


		public void pressEnterKey(WebElement ele) {

			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(ele));			
				ele.sendKeys(Keys.ENTER);
				reportStep("Enter key is pressed", "PASS");
			} catch (InvalidElementStateException e) {
				reportStep("Enter key is not pressed", "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			} 

		}

		public void clickWithNoSnap(WebElement ele) {
			String text = "";
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(ele));	
				text = ele.getText();
				ele.click();
				//	switchToWindow(0);
				reportStep("The element :"+text+"  is clicked.", "PASS",false);
			} catch (InvalidElementStateException e) {
				reportStep("The element: "+text+" is not interactable", "FAIL",false);
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL",false);
			} 
		}

		public String getText(WebElement ele) {	
			String bReturn = "";
			try {
				bReturn = ele.getText();
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			}
			return bReturn;
		}

		public String getTitle() {		
			String bReturn = "";
			try {
				bReturn =  driver.getTitle();
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			} 
			return bReturn;
		}

		public String getAttribute(WebElement ele, String attribute) {		
			String bReturn = "";
			try {
				bReturn=  ele.getAttribute(attribute);
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			} 
			return bReturn;
		}

		public void selectDropDownUsingText(WebElement ele, String value) {
			try {
				new Select(ele).selectByVisibleText(value);
				reportStep("The dropdown is selected with text "+value,"PASS");
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			}

		}

		public void selectDropDownUsingIndex(WebElement ele, int index) {
			try {
				new Select(ele).selectByIndex(index);
				reportStep("The dropdown is selected with index "+index,"PASS");
			} catch (WebDriverException e) {
				reportStep("WebDriverException"+e.getMessage(), "FAIL");
			} 

		}

		public boolean verifyTitle(String expectedTitle) {
			boolean bReturn =false;
			try {
				if(getTitle().equals(expectedTitle)) {
					reportStep("The expected title matches the actual "+expectedTitle,"PASS");
					bReturn= true;
				}else {
					reportStep(getTitle()+" The expected title doesn't matches the actual "+expectedTitle,"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
			return bReturn;

		}

		public void verifyExactText(WebElement ele, String expectedText) {
			try {
				if(getText(ele).equals(expectedText)) {
					reportStep("The expected text matches the actual "+expectedText,"PASS");
				}else {
					reportStep("The expected text doesn't matches the actual "+expectedText,"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 

		}

		public void verifyPartialText(WebElement ele, String expectedText) {
			try {
				if(getText(ele).contains(expectedText)) {
					reportStep("The expected text contains the actual "+expectedText,"PASS");
				}else {
					reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
		}

		public void verifyExactAttribute(WebElement ele, String attribute, String value) {
			try {
				if(getAttribute(ele, attribute).equals(value)) {
					reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
				}else {
					reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 

		}

		public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
			try {
				if(getAttribute(ele, attribute).contains(value)) {
					reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
				}else {
					reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}

		public void verifySelected(WebElement ele) {
			try {
				if(ele.isSelected()) {
					reportStep("The element "+ele+" is selected","PASS");
				} else {
					reportStep("The element "+ele+" is not selected","FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}

		public void verifyDisplayed(WebElement ele) {
			try {
				if(ele.isDisplayed()) {
					reportStep("The element "+ele+" is visible","PASS");
				} else {
					reportStep("The element "+ele+" is not visible","FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
		}

		public void switchToWindow(int index) {
			try {
				Set<String> allWindowHandles = driver.getWindowHandles();
				List<String> allHandles = new ArrayList<>();
				allHandles.addAll(allWindowHandles);
				driver.switchTo().window(allHandles.get(index));
			} catch (NoSuchWindowException e) {
				reportStep("The driver could not move to the given window by index "+index,"PASS");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}

		public  void switchToFrame(WebElement ele) {
			try {
				//driver.switchTo().frame(ele);
				WebDriverWait wait = new WebDriverWait(driver,100);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));

				reportStep("switch In to the Frame "+ele,"PASS");
			} catch (NoSuchFrameException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
		}


		public  void switchToMultipleFrames( String frame1, String frame2) {
			try {



				driver.switchTo().frame(frame1).switchTo().frame(frame2);



				reportStep("switch In to the Frame ","PASS");
			} catch (NoSuchFrameException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
		}


		public void acceptAlert() {
			String text = "";		
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
				alert.accept();
				reportStep("The alert "+text+" is accepted.","PASS");
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.","FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}  
		}

		public void dismissAlert() {
			String text = "";		
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
				alert.dismiss();
				reportStep("The alert "+text+" is dismissed.","PASS");
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.","FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 

		}

		public String getAlertText() {
			String text = "";		
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.","FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			} 
			return text;
		}

		public void rightClickAction(WebElement ele) {
			try {
				Actions action = new Actions(driver);
				action.contextClick(ele).perform();
				reportStep("rightclick action is performed ","PASS");
			}catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}

		public void doubleClickAction(WebElement ele) {
			try {		
				Actions action = new Actions(driver);

				action.doubleClick(ele).perform();
				reportStep("DoubleClick action is performed ","PASS");
			}
			catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}
		public void explicitWait(WebElement ele) {
			try {		
				WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(ele));

				reportStep("The element is waited for 20 secs ","PASS");
			}
			catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}
		}



		public void uploadDocument(String attachment) throws Throwable {
			try {
				String path = System.getProperty("user.dir");
				String filename = path+"\\documentstoupload\\"+attachment;
				// Setting clipboard with file location
				StringSelection stringSelection = new StringSelection(filename);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				// native key strokes for CTRL, V and ENTER keys
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(2000);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				reportStep("Document from local system has been attached ","PASS");
			}
			catch (WebDriverException e) {
				reportStep("WebDriverException : "+e.getMessage(), "FAIL");
			}



		}



		public long takeSnap(){
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
			try {
				String path = System.getProperty("user.dir");
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File(path+"//reports//images//"+number+".jpg"));
			} catch (WebDriverException e) {
				System.out.println("The browser has been closed.");
			} catch (IOException e) {
				System.out.println("The snapshot could not be taken");
			}
			return number;
		}

		public void closeBrowser() {
			try {
				driver.close();
				reportStep("The browser is closed","PASS");
			} catch (Exception e) {
				reportStep("The browser could not be closed","FAIL");
			}
		}

		public void closeAllBrowsers() {
			try {
				driver.quit();
				reportStep("The opened browsers are closed","PASS");
			} catch (Exception e) {
				reportStep("The browsers could not be closed","FAIL");
			}
		}






	}


	@Override
	public void startApp(String browser) {
		// TODO Auto-generated method stub

	}


	@Override
	public WebElement locateElement(String locator, String locValue) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void type(WebElement ele, String data) {
		// TODO Auto-generated method stub

	}


	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub

	}


	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}


	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}


	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}


	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}


	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}


	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}


	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}


	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}


	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}


	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}


	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}


	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub

	}


	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}





}

