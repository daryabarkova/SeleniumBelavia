package by.dbarkova.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
	
	private static WebDriver driver;
	private static final String WEBDRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";
	private static final String FIREFOX_EXE_PATH = "src\\main\\resources\\drivers\\firefox\\geckodriver.exe";
	
	private DriverSingleton() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty(WEBDRIVER_FIREFOX_DRIVER, FIREFOX_EXE_PATH);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			System.out.println("Firefox browser started!");
		}
		return driver;
	}
	
	public static void closeDriver() {
		driver.close();
		driver = null;
	}

}
