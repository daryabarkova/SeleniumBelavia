package by.dbarkova.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends AbstractPage {
	
	@FindBy(xpath = "//*[@id='matrix']/div[1]/div[1]/div[2]/a")
	WebElement nextWeekButton;
	
	@FindBy(xpath = "//*[@id='matrix']/div[@class='b-matrix clear']/div[@class='details']/div[@class='price selected']/div/label")
	List<WebElement> flightDates;
	
	
	public CalendarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void switchToNextWeek() {
		nextWeekButton.click();
		System.out.println("[Calendar] Next week details have been requested.");
	}
	
	public List<String> getPricesList() {
		
		List<String> pricesList = null;
		Iterator<WebElement> it = flightDates.iterator();
		
		while(it.hasNext()) {
			pricesList.add(it.next().getText());
		}
		System.out.println("List of prices for 1 week has been collected.");
		return pricesList;
	}

	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}
}
