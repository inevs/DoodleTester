package demo;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Und;
import cucumber.api.java.de.Wenn;
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

public class MyStepDefs {

	private WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Angenommen("^ich bin auf der Doodle Seite$")
	public void ich_bin_auf_der_Doodle_Seite() throws Throwable {
		driver.get("http://www.doodle.com");
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

	@Wenn("^ich auf Termin finden gehe$")
	public void ich_auf_Termin_finden_gehe() throws Throwable {
		driver.findElement(By.className("btn-primary")).click();
	}

	@Wenn("^den Titel \"([^\"]*)\" eingebe$")
	public void den_Titel_eingebe(String title) throws Throwable {
		driver.findElement(By.id("title")).sendKeys(title);
	}

	@Wenn("^den Namen \"([^\"]*)\" eingebe$")
	public void den_Namen_eingebe(String name) throws Throwable {
		driver.findElement(By.id("initiatorAlias")).sendKeys(name);
	}

	@Wenn("^die Mailadresse \"([^\"]*)\" eingebe$")
	public void die_Mailadresse_eingebe(String mail) throws Throwable {
		driver.findElement(By.id("initiatorEmail")).sendKeys(mail);
	}

	@Wenn("^dort auf weiter klicke$")
	public void dort_auf_weiter_klicke() throws Throwable {
		driver.findElement(By.id("next1")).click();
	}

	@Wenn("^ich dann einen Termin für morgen wähle$")
	public void ich_dann_einen_Termin_für_morgen_wähle() throws Throwable {
		driver.findElement(By.id(composeIdentifierForDateCell())).click();
	}

	@Wenn("^auf weiter klicke$")
	public void auf_weiter_klicke() throws Throwable {
		driver.findElement(By.id("next2a")).click();
	}

	@Und("^keine Zeit vorgebe$")
	public void keineZeitVorgebe() throws Throwable {
		driver.findElement(By.id("next2b")).click();
	}

	@Wenn("^eine einfache Umfrage auswähle$")
	public void eine_einfache_Umfrage_auswähle() throws Throwable {
		driver.findElement(By.id("next3s")).click();
	}

	@Wenn("^jeden den Link sehen lassen will$")
	public void jeden_den_Link_sehen_lassen_will() throws Throwable {
	}

	@Wenn("^ich dann auf Fertigstellen klicke$")
	public void ich_dann_auf_Fertigstellen_klicke() throws Throwable {
		driver.findElement(By.id("finish4a")).click();
	}

	@Dann("^sehe ich \"([^\"]*)\"$")
	public void sehe_ich(String text) throws Throwable {
		Thread.sleep(2000);
		assertThat(driver.findElement(By.id("contentArea")).getText(), containsString(text));
	}

	private String composeIdentifierForDateCell() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return "cell" + dateFormat.format(getDateOfTomorrow());
	}

	private Date getDateOfTomorrow() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
}
