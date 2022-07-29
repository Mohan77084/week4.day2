package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
public static void main (String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	Set<String> windowHandles1 = driver.getWindowHandles();
	List<String> winList1 = new ArrayList<>(windowHandles1);
	driver.switchTo().window(winList1.get(1));
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	driver.switchTo().window(winList1.get(0));
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> windowHandles2 = driver.getWindowHandles();
	List<String> winList2 = new ArrayList<>(windowHandles2);
	driver.switchTo().window(winList2.get(1));
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
	driver.switchTo().window(winList2.get(0));
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	String title = driver.getTitle();
	if(title.contains("View Contact")) {
		System.out.println("Passed");
	}
	else {
		System.out.println("Failed");
	}
	Thread.sleep(2000);
	driver.close();
}
}
