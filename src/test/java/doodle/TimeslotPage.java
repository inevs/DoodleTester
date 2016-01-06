package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeslotPage {
	private WebDriver driver;

	public TimeslotPage(WebDriver driver) {
		this.driver = driver;
	}

	public ConfigurePollPage gotoConfigurePollPage() {
		driver.findElement(By.id("next2b")).click();
		return new ConfigurePollPage(driver);
	}
}
