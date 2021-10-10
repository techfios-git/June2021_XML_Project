package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddContactTest {

	WebDriver driver;
	
//	@Test
	@Parameters({"UserName", "Password","FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company, String eamil, String phone, String address, String city, String state, String zip, String country) {

		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(eamil);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickOnSubmitButton();
		addContactPage.verifyProfilePage();
		
		dashboard.clickListCustomerButton();
		
		addContactPage.verifyEnteredNameAndDelete();
		
		

	}
	
	
	@Test
	@Parameters({"UserName", "Password","FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomerOnListCustomer(String userName, String password, String fullName, String company, String eamil, String phone, String address, String city, String state, String zip, String country) {

		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickListCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.clickAddCustomerOnListCustomer();
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(eamil);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickOnSubmitButton();
		addContactPage.verifyProfilePage();
		
		dashboard.clickListCustomerButton();
		
		addContactPage.insertNameOnSearchBarOnListCustomer();
		addContactPage.verifyEnteredNameAndProfile();
		

	}

}
