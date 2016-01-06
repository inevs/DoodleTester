package doodle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DoodleDriver {

	private WebDriver driver;
	private HomePage homePage;
	private PollCompletionPage pollCompletionPage;

	public DoodleDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void open() {
		homePage = new HomePage(driver);
		homePage.open();
	}

	public void addDate() {
		DatePropertiesPage propertiesPage = homePage.startFindingDates();
		propertiesPage.enterTitle("Test Termin");
		propertiesPage.enterOrganizerName("John Doe");
		propertiesPage.enterOrganizerMail("john.doe@local.com");

		DateSuggestionPage dateSuggestionPage = propertiesPage.gotoDateSuggestion();
		dateSuggestionPage.selectDate(getDateOfTomorrow());

		pollCompletionPage = dateSuggestionPage
				.gotoTimeslotPage()
				.gotoConfigurePollPage()
				.gotoConfigureVisibilityPage()
				.completePoll();
	}

	public void assertThatPageContains(String text) {
		String contentAreaText = pollCompletionPage.getContentAreaText();
		assertThat(contentAreaText, containsString(text));
	}

	public void quit() {
		driver.quit();
	}

	private Date getDateOfTomorrow() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}



}
