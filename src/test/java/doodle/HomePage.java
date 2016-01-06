package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get("http://www.doodle.com");
	}

	public DatePropertiesPage startFindingDates() {
		driver.findElement(By.className("btn-primary")).click();
		return new DatePropertiesPage(driver);
	}

}
