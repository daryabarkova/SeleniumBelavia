package by.dbarkova.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private static final String BASE_URL = "https://en.belavia.by/";
	
	@FindBy(id = "OriginLocation_Combobox")
	private WebElement fromForm;
	
	@FindBy(id = "DestinationLocation_Combobox")
	private WebElement toForm;
	
	@FindBy(id = "JourneySpan_Ow")
	private WebElement tripType;
	
	@FindBy(xpath = "//*[@id=\'step-2\']/div[2]/div[1]/div/a/i")
	private WebElement calendarIcon;
	
	@FindBy(id = "//*[@id='calendar']/div/div[1]/table/tbody/tr/td[contains(@class,'ui-datepicker-current-day')]")
	private WebElement currentDate;
	
	@FindBy(xpath = "//*[@id=\'step-2\']/div[4]/div/button")
	private WebElement submitButton;
	
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void populateFromForm(String fromCountry) {
		fromForm.sendKeys(fromCountry);
		fromForm.sendKeys(Keys.RETURN);
		System.out.println("Origin country has been added.");
	}
	
	public void populateToForm(String toCountry) {
		fromForm.sendKeys(toCountry);
		fromForm.sendKeys(Keys.RETURN);
		System.out.println("Destination country has been added.");
	}
	
	public void selectOneWayTripType() {
		tripType.click();
		System.out.println("One way trrp type has been selected.");
	}
	
	public void selectCurrentDepartureDate() throws InterruptedException {
		calendarIcon.click();
		Thread.sleep(2000);
		currentDate.click();
		System.out.println("[DatePicker] Current date has been selected.");
	}
	
	public void searchResults() {
		submitButton.click();
		System.out.println("Submit button has been clicked.");
	}
	
	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
