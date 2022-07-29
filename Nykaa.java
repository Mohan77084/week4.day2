package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.nykaa.com/"); 
	WebElement brandsElement = driver.findElement(By.xpath("//a[text()='brands']"));
	Actions builder = new Actions(driver);
	builder.moveToElement(brandsElement).perform();
	driver.findElement(By.xpath("//div[@class='brandSearchMain']//input")).sendKeys("L'Oreal Paris");
	driver.findElement(By.linkText("L'Oreal Paris")).click();
	driver.findElement(By.xpath("//div[@class='css-ar51ef']")).click();
	driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	WebElement categoryElement = driver.findElement(By.xpath("//span[text()='Category']"));
	driver.executeScript("arguments[0].scrollIntoView();",categoryElement);
	driver.executeScript("arguments[0].click();",categoryElement);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	driver.findElement(By.xpath("//div[@class='control-value']//span[text()='Shampoo']")).click();
	String filteredElement = driver.findElement(By.xpath("//div[@class='css-rtde4j']//span")).getText();
	if(filteredElement.equals("Shampoo")) {
		System.out.println("Items are sorted correctly");
	}
	else {
		System.out.println("Items are not sorted correctly");
	}
	WebElement concernElement = driver.findElement(By.xpath("//span[text()='Concern']"));
	driver.executeScript("arguments[0].scrollIntoView();",concernElement);
	driver.executeScript("arguments[0].click();",concernElement);
	driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowList = new ArrayList<>(windowHandles);
	driver.switchTo().window(windowList.get(1));
	WebElement dropDown = driver.findElement(By.xpath("//div[@class='css-11wjdq4']//select"));
	Select dd = new Select(dropDown);
	dd.selectByVisibleText("175ml");
	String mrp = driver.findElement(By.xpath("(//span[@class='css-u05rr'])[1]")).getText().substring(5);
	System.out.println("MRP of the product : "+mrp);
	driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//iframe"));
	driver.switchTo().frame(0);
	String grandTotal1 = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText().substring(1);
	System.out.println("Grand Total before 'ADD TO BAG' : "+grandTotal1);
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn full big']")).click();
	String grandTotal2 = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span")).getText();
	System.out.println("Grand Total after 'ADD TO BAG' : "+grandTotal2);
	if(grandTotal1.equals(grandTotal2)) {
		System.out.println("Grand Total values are equal");
	}
	else {
		System.out.println("Grand Total values are not equal");
	}
	driver.quit();
}
}
