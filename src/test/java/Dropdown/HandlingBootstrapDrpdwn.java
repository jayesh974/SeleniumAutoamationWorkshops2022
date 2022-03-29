package Dropdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBootstrapDrpdwn {
	
	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3");
		
		String arr[] = {"Bootstrap","Java","MS SQL Server", "Python" };
		List ls = new ArrayList<String>(Arrays.asList(arr));
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a/label"));
		int size = list.size();
		System.out.println(size);
		
//		for (int i = 0; i < size; i++) {
//			System.out.println(list.get(i).getText());
//			list.get(i).click();
//		}
		
		for(int i = 0; i < size; i++) {	
			
			if(ls.contains(list.get(i).getText())) {
				Thread.sleep(2000);
				System.out.println(list.get(i).getText()+" is selected");
				list.get(i).click();
			}
		}
		
		
	}

}
