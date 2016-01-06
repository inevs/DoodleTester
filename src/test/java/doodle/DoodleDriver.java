package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DoodleDriver {

	private WebDriver driver;

	public DoodleDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void open() {
		driver.get("http://www.doodle.com");
	}

	public void addDate() {
		startPoll();
		enterInitialAttributes();
		selectDates();
		selectTimeslots();
		configurePoll();
		configureVisibility();
	}

	public void assertThatPageContains(String text) {
		String contentAreaText = driver.findElement(By.id("contentArea")).getText();
		assertThat(contentAreaText, containsString(text));
	}

	public void quit() {
		driver.quit();
	}

	private void startPoll() {
		driver.findElement(By.className("btn-primary")).click();
	}

	private void enterInitialAttributes() {
		driver.findElement(By.id("title")).sendKeys("Test Termin");
		driver.findElement(By.id("initiatorAlias")).sendKeys("John Doe");
		driver.findElement(By.id("initiatorEmail")).sendKeys("john.doe@local.com");
		driver.findElement(By.id("next1")).click();
	}

	private void selectDates() {
		driver.findElement(By.id(composeDateCellIdentifierForDate(getDateOfTomorrow()))).click();
		driver.findElement(By.id("next2a")).click();
	}

	private void selectTimeslots() {
		driver.findElement(By.id("next2b")).click();
	}

	private void configurePoll() {
		driver.findElement(By.id("next3s")).click();
	}

	private void configureVisibility() {
		driver.findElement(By.id("finish4a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {}
	}

	private Date getDateOfTomorrow() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}

	private String composeDateCellIdentifierForDate(Date tomorrow) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return "cell" + dateFormat.format(tomorrow);
	}


}
