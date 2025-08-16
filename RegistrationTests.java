package Tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.RegistrationPage;

public class RegistrationTests extends BaseTest{
	@Test(priority = 1)
	public void testPageLoadandPopup() {
		Assert.assertEquals(driver.getTitle(), "DevCon 2025 Registration");
		RegistrationPage reg = new RegistrationPage(driver);
		reg.closePromoPopup();
	}
	@Test(priority = 2)
	public void testFormFilling() {
		RegistrationPage reg = new RegistrationPage(driver);
		reg.fillPersonalInfo("suman", "shekhar", "suman.she@gmail.com");
		reg.selectDiet("NonVeg");
		
	}
	@Test(priority = 3)
	public void testWorkshopSelection() {
		RegistrationPage reg = new RegistrationPage(driver);
		reg.selectWorkshop("Python", "MySql");
		reg.selectseminarDate("2025.10.17");
	}
	@Test(priority = 4)
	public void testSponsorandterms() {
		RegistrationPage reg = new RegistrationPage(driver);
		reg.handleSponsorWindow();
		reg.acceptterms();
	}
	
	public void testformSubmission() throws IOException {
		RegistrationPage reg = new RegistrationPage(driver);
		reg.submitForm();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Registration Successful");
		alert.accept();
		
		Assert.assertTrue(driver.getTitle().contains("Confirmation"));
		
	
	}

}
