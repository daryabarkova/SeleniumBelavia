package by.dbarkova.tests;

import org.testng.annotations.Test;

import by.dbarkova.steps.Steps;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.testng.annotations.AfterMethod;

public class NewTest {

	private Steps steps;
	private final String FROM_CITY = "Minsk";
	private final String TO_CITY = "Baku";
	private final int WEEKS_AMOUNT = 4;

	@BeforeMethod(description="Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void checkAvgPricePositive () throws InterruptedException {
		steps.requestFlightDetails(FROM_CITY, TO_CITY);
		List<String> fullPricesList = steps.getPricesForPeriod(WEEKS_AMOUNT);
		List<Double> prices = steps.getPrices(fullPricesList);
		double avgPrice = steps.getAveragePrice(prices);
		
		System.out.println(avgPrice);
		
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
