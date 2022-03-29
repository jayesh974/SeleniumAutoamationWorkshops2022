package Calender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_Picker_HYR {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/");

		driver.findElement(By.xpath("//input[@name='checkin'][@id='checkin']")).click();

		String month = "November 2021";
		String day = "22";

		WebElement text = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]"));

		while (true) {

			if (text.equals(month))
			{
				break;
			} 
			else
			{
				driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
			}

			driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td[contains(text()," + day + ")]"))
					.click();
			

		}

	}

}
