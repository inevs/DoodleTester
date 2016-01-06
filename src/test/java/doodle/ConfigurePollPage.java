package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigurePollPage {
	private WebDriver driver;

	public ConfigurePollPage(WebDriver driver) {
		this.driver = driver;
	}

	public ConfigureVisibilityPage gotoConfigureVisibilityPage() {
		driver.findElement(By.id("next3s")).click();
		return new ConfigureVisibilityPage(driver);
	}
}
