package Calender;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAutoWorkshops_Calender {
	
	static WebDriver driver ;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

//		 not valid date
//		selectDate(driver, "32", "March", "2021");
		
		// Future date
//		selectDate(driver, "10", "March", "2024");
		
		// Prevous date
		selectDate(driver, "10", "March", "2020");
		
		Thread.sleep(5000);

		
		
		
		
	}
	
	public static void selectDate(WebDriver driver,String dateToSelect,String monthToSelect,String yearToSelect) throws InterruptedException
	{
		boolean status = false;
		
		while(!status)
		{
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(Integer.parseInt(dateToSelect)>31){
				System.out.println("Not a valid date ...");
				break;
			}
			
			if(Integer.parseInt(yearToSelect) < Calendar.getInstance().get(Calendar.YEAR)) {
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
				Thread.sleep(500);
				
				if(month.contains(monthToSelect) && year.contains(yearToSelect)) {
					driver.findElement(By.xpath("//a[text()='"+dateToSelect+"']")).click();
					status = true;
					break;
				}
			}
			else {
				if(month.contains(monthToSelect) && year.contains(yearToSelect)) {
					status = true;
					driver.findElement(By.xpath("//a[text()='"+dateToSelect+"']")).click();
					break;
				}
				else {
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					Thread.sleep(500);
				}
				
			}


		}
		
	}
	
	

}
