
/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/#configuration
*/
import org.openqa.selenium.firefox.FirefoxDriver

driver = { def driver = new FirefoxDriver() }

waiting {
    timeout = 120
    retryInterval = 1
}

reportsDir = new File("target/runtime_reports_dir")

baseUrl =  "http://www.snapdeal.com/"