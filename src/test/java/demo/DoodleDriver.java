package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DoodleDriver {

	private WebDriver driver;

	public DoodleDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void open() {
		driver.get("http://www.doodle.com");
	}

	public void quit() {
		driver.quit();
	}

}
