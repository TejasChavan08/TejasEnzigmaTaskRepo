package ForgotPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forgot_Invalid_emailFormat {

	public static void main(String[] args) {
		

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
		
		//comparing the two url to check whether it is in right page or not
		if (ex_url.equals(ac_url)) {
			System.out.println("At tageted Page");
			
			//forgot password element to click the the link to forgot the password action ---> click
			driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
			
			//inserting the email into the forgot password to get the verification code
			driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("0123@@gmail.com");
			
			//click the proceed button
			driver.findElement(By.xpath("//div[@title='Proceed']")).click();
			
			//gettting error or not in the screen to check
			WebElement msg=driver.findElement(By.xpath("//h1[@class='slds-text-heading_small slds-p-bottom_xx-small']"));
			
			
			if (msg.isDisplayed()) {
				//gettting the message
				WebElement message=driver.findElement(By.xpath("//h2[@class='slds-text-heading_small']"));
				
				//displaying the error
				System.out.println(msg.getText() +" : "+message.getText());
			}						
			
		} else {
			System.out.println("not at target page");
		}
		
		driver.quit();
	}
}
