package BasicScript;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScriptForPositiveData {

	public static void main(String[] args) throws InterruptedException {

		// login page url
		String ex_url = "https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
		// open the browser
		ChromeDriver driver = new ChromeDriver();
		// maxize the browser
		driver.manage().window().maximize();
		// providing the waiting conditions to avoiding the unnecessary errors. Giving
		// implicit wait condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// navigate to the Web page by providing the URL
		driver.get("https://app-staging.nokodr.com/");
		// verify the webPage by taking current url means controller present page url.
		String ac_url = driver.getCurrentUrl();
		if (ex_url.equals(ac_url)) {
			// if yes then print this verification code
			System.out.println("We are at Right Page");
			// trying to display the current page title of the web page (to know where is
			// our controller is present)
			System.out.println(driver.getTitle());
		} else {
			// if not present then print this code
			System.out.println("We are not Right Page");
			// trying to display the title of the web page (to know where is our controller
			// is present)
			System.out.println(driver.getTitle());
		}
		// giving some extra time for human so we can see the some result
		Thread.sleep(2000);
		// close the browser
		driver.quit();
	}
}
