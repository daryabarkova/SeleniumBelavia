package by.dbarkova.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestRunner {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"src\\main\\resources\\drivers\\firefox\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://en.belavia.by/");

		driver.close();

	}

}
