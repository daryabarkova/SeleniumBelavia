package by.dbarkova.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import by.dbarkova.driver.DriverSingleton;
import by.dbarkova.pages.CalendarPage;
import by.dbarkova.pages.MainPage;

public class Steps {
	
	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	public void closeDriver() {
		DriverSingleton.getDriver();
	}
	
	public void requestFlightDetails(String fromCountry, String toCountry) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.populateFromForm(fromCountry);
		mainPage.populateToForm(toCountry);
		mainPage.selectOneWayTripType();
		mainPage.selectCurrentDepartureDate();
		mainPage.searchResults();
		System.out.println("Flight details have been requested.");
	}
	
	public List<String> getPricesForPeriod(int weeksAmount) throws InterruptedException{
		
		CalendarPage calendarPage = new CalendarPage(driver);
		List<String> fullPricesList = new ArrayList<String>();
		int a = 0;
		
		for(int i = 0; i<weeksAmount; i++) {
			fullPricesList.addAll(a, calendarPage.getPricesList());
			calendarPage.switchToNextWeek();
			a = a+7;
			Thread.sleep(2000);
		}
		
		System.out.println("Full price list has been generated for requested period.");
		return fullPricesList;
	}
	
	@SuppressWarnings("null")
	public List<Double> getPrices(List<String> fullPricesList){
		
		List<Double> prices  = null;
		Iterator<String> it = fullPricesList.iterator();
		
		while(it.hasNext()) {
			prices.add(Double.parseDouble(it.next().split(" ")[0]));
		}
		
		System.out.println("Prices have been collected!! :)");
		return prices;
	}
	
	public double getAveragePrice(List<Double> prices) {
		
		double avgPrice = 0;
		double totalAmount = 0;
		int pricesAmount = 0;
		
		Iterator<Double> it = prices.iterator();
		
		while(it.hasNext()) {
			totalAmount += it.next();
			pricesAmount += 1;
		}
		
		avgPrice = totalAmount / pricesAmount;
		
		System.out.println("Average price has been calculated, the result is: " + avgPrice);
		return avgPrice;
	}

}
