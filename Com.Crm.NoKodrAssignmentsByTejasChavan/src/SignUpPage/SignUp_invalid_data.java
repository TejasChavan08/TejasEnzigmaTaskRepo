package SignUpPage;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp_invalid_data {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://app-staging.nokodr.com/");
		
		//click on the sign up button
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		
		//send the opt into the provided email
		driver.findElement(By.xpath("(//input[@name=\"username\"])[2]")).sendKeys("buck$.b@nd007@gmail.com");
		
		//click on the agreement terms
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		
		//click on the proceed button 
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		
		//gettting error or not in the screen to check
		WebElement msg=driver.findElement(By.xpath("//h1[@class='slds-text-heading_small slds-p-bottom_xx-small']"));
		
		
		if (msg.isDisplayed()) {
			//gettting the message
			WebElement message=driver.findElement(By.xpath("//h2[@class='slds-text-heading_small']"));
			
			//displaying the error
			System.out.println(msg.getText() +" : "+message.getText());
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Code']")));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the opt: ");
		String no = sc.nextLine();
		
		
		//send the key to output field
		otpField.sendKeys(no);
		
		//click on the verify button
		driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[2]")).click();
		
		
		//for firstname inputfeild
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("$$$$$###&&&&");
		
		//the last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Ch@v@n");
		
		//passwrod(new password)
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Tejas@2001");
		
		//for confirm the password
		driver.findElement(By.name("password-confirmpassword")).sendKeys("Tejas@2001");
		
		//for register buttom
		driver.findElement(By.xpath("//div[@title='Register']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='slds-text-heading_small slds-p-bottom_xx-small']")));
		WebElement acc_msg=driver.findElement(By.xpath("//h1[@class='slds-text-heading_small slds-p-bottom_xx-small']"));
		
		
		if (acc_msg.isDisplayed()) {
			//gettting the message
			WebElement acc_message=driver.findElement(By.xpath("//h2[@class='slds-text-heading_small']"));
			
			//displaying the error
			System.out.println(acc_msg.getText() +" : "+acc_message.getText());
		}	
	}
}
