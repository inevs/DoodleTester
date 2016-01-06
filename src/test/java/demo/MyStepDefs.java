package demo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

public class MyStepDefs {

	private DoodleDriver app;

	@Before
	public void initDriver() {
		app = new DoodleDriver();
	}

	@Angenommen("^ich bin auf der Doodle Seite$")
	public void ich_bin_auf_der_Doodle_Seite() throws Throwable {
		app.open();
	}

	@Wenn("^ich einen Termin einstelle$")
	public void ich_einen_Termin_einstelle() throws Throwable {
		app.addDate();
	}

	@Dann("^sehe ich eine Erfolgsmeldung$")
	public void sehe_ich_eine_Erfolgsmeldung() throws Throwable {
		app.assertThatPageContains("Danke");
	}

	@After
	public void closeBrowser() {
		app.quit();
	}
}
