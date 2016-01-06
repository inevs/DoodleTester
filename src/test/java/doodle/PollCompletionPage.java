package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PollCompletionPage {
	private WebDriver driver;

	public PollCompletionPage(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {}
		this.driver = driver;
	}

	public String getContentAreaText() {
		return driver.findElement(By.id("contentArea")).getText();
	}
}
