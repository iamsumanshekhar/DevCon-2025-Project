package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Fictional Locators
	private By popupCloseButton = By.id("Close");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("emailId");
	private By dietPreference = By.id("diet");
	private By areasofinterest = By.name("interest");
	private By workshopTrack = By.name("track");
	private By specificWorkshop = By.id("workshop");
	private By seminarDate = By.id("date");
	private By sponsorLogo = By.cssSelector(".sponsorLogo");
	private By termsFrame = By.id("termsFrame");
	private By agreeCheckBox = By.id("agree");
	private By submitBtn = By.id("submit");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public void closePromoPopup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(popupCloseButton));
		driver.findElement(popupCloseButton).click();
	}
	
	public void fillPersonalInfo(String fname, String lname, String mail) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(email).sendKeys(mail);
	}
	
	public void selectDiet(String value) {
		driver.findElement(By.id("Diet")).click();
		
	}
	
	public void selectWorkshop(String track, String workshop) {
		driver.findElement(workshopTrack).sendKeys(track);
		wait.until(ExpectedConditions.presenceOfElementLocated(specificWorkshop));
		driver.findElement(specificWorkshop).sendKeys(workshop);
		}
	public void selectseminarDate(String Date) {
		driver.findElement(seminarDate).sendKeys(Date);
		
	}
	
	public void handleSponsorWindow() {
		String mainWin = driver.getWindowHandle();
		driver.findElement(sponsorLogo).click();
		for(String win : driver.getWindowHandles()) {
			if(!win.equals(mainWin)) {
				driver.switchTo().window(win);
				System.out.println("sponsor Title : " + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWin);
	}
	
	public void acceptterms() {
		driver.switchTo().frame(driver.findElement(termsFrame));
		driver.switchTo().defaultContent();
		driver.findElement(agreeCheckBox).click();
	}
	
	public void submitForm() {
		driver.findElement(submitBtn).click();
	}
	}


