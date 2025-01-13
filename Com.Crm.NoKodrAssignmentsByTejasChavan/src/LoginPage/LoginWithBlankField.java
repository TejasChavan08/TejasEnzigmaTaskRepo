package LoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithBlankField {

	public static void main(String[] args) throws InterruptedException {
		
		// login page url
		String ex_url = "https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
		// open the browser
		ChromeDriver driver = new ChromeDriver();
		
		// maxize the browser
		driver.manage().window().maximize();
		
		// providing the waiting conditions to avoiding the unnecessary errors. Giving implicit wait condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// navigate to the Web page by providing the URL
		driver.get("https://app-staging.nokodr.com/");
		
		// verify the webPage by taking current url means controller present page url.
		String ac_url = driver.getCurrentUrl();
		
		if (ex_url.equals(ac_url)) {
			// if yes then print this verification code
			System.out.println("We are at Right Page");
			
			// trying to display the current page title of the web page (to know where is our controller is present)
			System.out.println(driver.getTitle());
			
			
			//using id locator because its faster than other locator
			//getting the email element to insert the element inside the text field (findElement, sendkeys)
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("");
			
			//getting the password element to insert the element inside the text field (findElement, sendkeys)
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
			
			//click the remember me button 
			driver.findElement(By.id("rememberMe")).click();
			
			//click the login butto to getlogged in using xpath locator 
			driver.findElement(By.xpath("//div[@title='Log In']")).click();
			
			//gettting error or not in the screen to check
			WebElement msg=driver.findElement(By.xpath("//h1[@class='slds-text-heading_small slds-p-bottom_xx-small']"));
			
			
			if (msg.isDisplayed()) {
				//gettting the message
				WebElement message=driver.findElement(By.xpath("//h2[@class='slds-text-heading_small']"));
				
				//displaying the error
				System.out.println(msg.getText()+" : "+message.getText());
			}
			
		} else {
			// if not present then print this code
			System.out.println("We are not Right Page");
			
			// trying to display the title of the web page (to know where is our controller is present)
			System.out.println(driver.getTitle());
		}
		// giving some extra time for human so we can see the some result
		Thread.sleep(2000);
		// close the browser
		driver.quit();
	}
}
