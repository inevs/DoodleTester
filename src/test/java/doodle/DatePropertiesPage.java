package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePropertiesPage {
	private WebDriver driver;

	public DatePropertiesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTitle(String title) {
		driver.findElement(By.id("title")).sendKeys(title);
	}

	public void enterOrganizerName(String organizerName) {
		driver.findElement(By.id("initiatorAlias")).sendKeys(organizerName);
	}

	public void enterOrganizerMail(String organizerMail) {
		driver.findElement(By.id("initiatorEmail")).sendKeys(organizerMail);
	}

	public DateSuggestionPage gotoDateSuggestion() {
		driver.findElement(By.id("next1")).click();
		return new DateSuggestionPage(driver);
	}
}
