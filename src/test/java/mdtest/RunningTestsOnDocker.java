package mdtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunningTestsOnDocker {

	@Test
	public void runtestsondocker() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8070/webapp/");
		String text = driver.findElement(By.xpath("(//h2)[2]")).getText();
		Assert.assertEquals("Good Luck and we are almost done with the course.Thank you, this is from azure", text);
		driver.close();

	}

}
