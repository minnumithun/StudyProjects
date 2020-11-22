package BasicMavenProj.de.mrk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenBaseTest

{

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		// max the page
		driver.manage().window().maximize();
		// retriving the title of the page
		String title = driver.getTitle();
		System.out.println("the title of the page is : " + title);

		driver.findElement(By.xpath("//input[contains(@placeholder,'UserName')]")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Password@123");

		driver.findElement(By.xpath("//button[contains(@id,'login')]")).click();

		// uName.sendKeys("testuser");
		// pswd.sendKeys("Password@123");
		// loginBtn.click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {

			WebElement logoutBtn = driver
					.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));

			if (logoutBtn.isDisplayed()) {
				logoutBtn.click();
				System.out.println("LogOut Successful!");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Incorrect login....");
		}

		driver.quit();
	}
}
