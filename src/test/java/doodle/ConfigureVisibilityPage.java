package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureVisibilityPage {
	private WebDriver driver;

	public ConfigureVisibilityPage(WebDriver driver) {
		this.driver = driver;
	}

	public PollCompletionPage completePoll() {
		driver.findElement(By.id("finish4a")).click();
		return new PollCompletionPage(driver);
	}
}
