package send.message;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Start the chrome in debug mode
 * chrome.exe -remote-debugging-port=9014 --user-data-dir="E:\Selenium Scripts\Chrome_Test_Profile”
 * 
 *  
 */

public class SendMsg {

	static WebDriverWait wait;
	static String csvFile = "E:\\Enviro-Advisors-India\\workspace\\send-message-data\\test.csv";
	static String imageLocation = "E:\\Enviro-Advisors-India\\EAI-Pictures\\Offer.jpeg";
	static String line = " ";
	static String csvSplitBy = ",";
	public static String[] ContactInfo = null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"E:\\Enviro-Advisors-India\\Drivers\\chromedriver121\\chromedriver.exe");

		System.out.println("Started");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:9081");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<String> notOnWhatsApp = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int n = 1;
			while ((line = br.readLine()) != null) {

				driver.findElement(
						By.xpath("/html/body/div[1]/div/div[2]/div[3]/header/div[2]/div/span/div[5]/div/span")).click();
				driver.findElement(By.xpath(
						"/html/body/div[1]/div/div[2]/div[2]/div[1]/span/div/span/div/div[1]/div[2]/div[2]/div/div[1]/p"))
						.click();

				WaitingTime.waitTime(3);
				ContactInfo = line.split(csvSplitBy);
				int i = 0;
				int j = 1;
				System.out.println("Searching Contact : " + ContactInfo[i]);
				driver.findElement(By.xpath(
						"/html/body/div[1]/div/div[2]/div[2]/div[1]/span/div/span/div/div[1]/div[2]/div[2]/div/div[1]/p"))
						.sendKeys(ContactInfo[i]);
				WaitingTime.waitTime(3);
				WebElement noresult = driver.findElement(
						By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/span/div/span/div/div[2]/div"));
				String stringNumber = noresult.getText();
				WaitingTime.waitTime(3);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).build().perform();
				// The above code is for searching contact and opening their chat

				System.out.println("StringNumber : " + stringNumber);
				WaitingTime.waitTime(2);
				boolean ifNum = true;
				if (stringNumber.contains("No results")) {
					ifNum = false;
					System.out.println("isNumberPresent: " + ifNum);
				}

				if (ifNum) {

					// First line
					WaitingTime.waitTime(2);
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.click();
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getFirstLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Second Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getSecondLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Third Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getThirdLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Fourth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getFourthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Fifth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getFifthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Sixth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getSixthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Seventh Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getSeventhLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Eighth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getEighthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Ninth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getNinthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Tenth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getTenthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Eleventh Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getEleventhLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Twelveth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getTwelvethLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Thirteenth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getThirteenthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					// Fourteenth Line
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"))
							.sendKeys(CreateMessage.getFourteenthLine());
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyDown(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
					action.keyUp(Keys.SHIFT).build().perform();

					WaitingTime.waitTime(2);
					// Insert Image
					// To send attachments
					// click to add
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[1]/div[2]/div/div/div/span"))
							.click();
					// add file to send by file path
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[4]/div/footer/div[1]/div/span[2]/div/div[1]/div[2]/div/span/div/ul/div/div[2]/li/div/span"))
							.click();
					Robot robot = new Robot();
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// Set the String to Enter
					StringSelection stringSelection = new StringSelection(imageLocation);// Copy the String to Clipboard
					clipboard.setContents(stringSelection, null);// Use Robot class instance to simulate CTRL+C and
																	// CTRL+V key events :
					WaitingTime.waitTime(2);
					robot.keyPress(KeyEvent.VK_CONTROL);

					robot.keyPress(KeyEvent.VK_V);

					robot.keyRelease(KeyEvent.VK_V);
					WaitingTime.waitTime(2);
					robot.keyRelease(KeyEvent.VK_CONTROL);// Simulate Enter key event

					robot.keyPress(KeyEvent.VK_ENTER);
					WaitingTime.waitTime(1);
					robot.keyRelease(KeyEvent.VK_ENTER);
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[2]/div[2]/span/div/span/div/div/div[2]/div/div[2]/div[2]/div/div"))
							.click();
					// click to send
					// driver.findElement(By.cssSelector("span[data-icon='send-light']")).click();

					// Send message
					WaitingTime.waitTime(3);
					action.sendKeys(Keys.ENTER).build().perform();

					WaitingTime.waitTime(3);
					System.out.println("Sent to : " + (n) + ". " + ContactInfo[i]);
					System.out.println("============================================================");
					i++;
					j++;
					n++;
					WaitingTime.waitTime(4);
				} else {
					System.out.println("*************************Number not found*****************************");
					WaitingTime.waitTime(3);
					driver.findElement(By.xpath(
							"/html/body/div[1]/div/div[2]/div[2]/div[1]/span/div/span/div/header/div/div[1]/div/span"))
							.click();
					System.out.println("Number not found : " + (n) + ". " + ContactInfo[i]);
					System.out.println("============================================================");
					notOnWhatsApp.add(ContactInfo[i]);
					i++;
					j++;
					n++;
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sent to all !!");
		System.out.println("Numbers not on whatsapp are: ");
		for(String s : notOnWhatsApp) {
			System.out.println(s);
		}
	}

}
