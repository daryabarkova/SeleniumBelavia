package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	 
	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void openPage();
	
}
