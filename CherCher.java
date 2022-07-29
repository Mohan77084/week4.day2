package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not a Friendly Topic");
		driver.switchTo().frame(0);
		WebElement chechBox = driver.findElement(By.id("a"));
		chechBox.click();
		if(chechBox.isSelected()) {
			System.out.println("Checkbox is selected");
		}
		else {
			System.out.println("Checkbox is not selected");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select dd = new Select(dropDown );
		dd.selectByIndex(2);
		
		Thread.sleep(3000);
		driver.close();
		
	}
}
