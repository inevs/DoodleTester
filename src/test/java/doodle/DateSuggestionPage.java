package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSuggestionPage {
	private WebDriver driver;

	public DateSuggestionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDate(Date date) {
		driver.findElement(By.id(composeDateCellIdentifierForDate(date))).click();
	}

	private String composeDateCellIdentifierForDate(Date tomorrow) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return "cell" + dateFormat.format(tomorrow);
	}

	public TimeslotPage gotoTimeslotPage() {
		driver.findElement(By.id("next2a")).click();
		return new TimeslotPage(driver);
	}

}
