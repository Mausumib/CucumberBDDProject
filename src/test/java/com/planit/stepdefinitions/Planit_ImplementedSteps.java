package com.planit.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.planit.pages.PageObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Planit_ImplementedSteps {

	public PageObject pom;
	public WebDriver driver;

	@Given("^user launch chrome browser$")
	public void user_launch_chrome_browser() {
		//String userProfile = "C:\\Users\\Mausumi.Behera\\AppData\\Local\\Google\\Chrome\\AutomationProfile\\";
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir="+userProfile);
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		//options.addExtensions(config.getExtension()); // path to extension
		//options.setBinary(config.getChromePortable()); //path to chrome portable .exe
		
		//options.addArguments("--no-default-browser-check");
		//options.addArguments("--no-first-run'");
		//options.addArguments("--disable-dev-shm-usage");
		//options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		//driver.get("http://demowebshop.tricentis.com/");
		pom = new PageObject(driver);
	}

	@When("^user opens url \"([^\"]*)\"$")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@And("click login")
	public void click_login() {
		pom.loginApplication();
	}

	@And("^user enters email as \"([^\"]*)\" and pwd as \"([^\"]*)\"$")
	public void user_enters_email_as_and_pwd_as(String name, String pwd) {
		pom.enterUserName(name);
		pom.enterPassword(pwd);
	}

	@And("^click login button$")
	public void click_login_button() {
		pom.clickLoginBtn();
	}

	@When("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String expTitle) {
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("^validate username \"([^\"]*)\"$")
	public void validate_username(String expUserName) {
		pom.validateUserAccountId(expUserName);
	}
	
	@And("^validate shopping cart is clear or clear the shopping cart if not empty$")
	public void validate_shopping_cart_is_clear_or_clear_the_shopping_cart_if_not_empty() {
		pom.clearShoppingCart();
	}

	@And("^click COMPUTERS tab and then Desktops option$")
	public void click_Computers_tab_and_then_Desktops_option() {
		pom.clickComputers();
	}
	
	@And("^select \"([^\"]*)\" computer from Desktops tab$")
	public void select_computer_from_Desktops_tab(String productName) {
		pom.selectProduct(productName);
	}
	
	@And("^enter \"([^\"]*)\" quantity for selected \"([^\"]*)\" computer$")
	public void enter_quantity_for_selected_computer(String quantity, String productName) {
		pom.validateSelectedProduct(quantity, productName);
	}
	
	@And("^add \"([^\"]*)\" computer to cart$")
	public void add_to_cart_computer(String productName) {
		pom.clickAddToCart(productName);
	}
	
	@Then("^validate \"([^\"]*)\" message displayed after adding the product to cart$")
	public void validate_msg_after_adding_product_to_cart(String expMsg) {
		pom.validateSuccessMsg(expMsg);
	}
	
	@And("^click shopping cart and get the sub total of the product and click on check out button$")
	public void click_on_checkout_button() {
		pom.validateSubTotalandClickCheckOut();
	}
	
	@And("^select \"([^\"]*)\" in billing address and select \"([^\"]*)\" Country and enter \"([^\"]*)\" City, \"([^\"]*)\" Address1, \"([^\"]*)\" Zip and \"([^\"]*)\" Contact Number$")
	public void select_billing_address_and_provide_mandatory_fields(String newAddress, String countryName, String city, String address1, String zip, String contactNumber) {
		pom.billingAddress(newAddress, countryName, city, address1, zip, contactNumber);
	}
	
	@And("^select Next day Air radio button and click continue button$")
	public void select_next_day_radio_btn() {
		pom.clickNextDayAirRadioBtn();
	}
	
	@And("^select \"([^\"]*)\" as payment method$")
	public void select_payment_method(String method) {
		pom.selectPaymentMethod(method);
	}
	
	@And("^validate \"([^\"]*)\" message in payment information$")
	public void validate_message_in_payment_information(String expPaymentMsg) {
		pom.validateMsgInPaymentInfo(expPaymentMsg);
	}
	
	@And("^click confirm button in Confirm Order page$")
	public void click_confirm_button() {
		pom.clickConfirmBtn();
	}
	
	@And("^validate \"([^\"]*)\" message after the order is successfully placed and get the order number$")
	public void validate_msg_after_the_order_is_successfully_placed_and_get_order_number(String expSuccessMsg) {
		pom.validateOrderSuccessMsg(expSuccessMsg);
	}
	
	@And("^click logout button$")
	public void click_logout_button() {
		pom.clickLogOutBtn();
	}

	@And("^close browser$")
	public void close_browser() {
		driver.quit();
	}

	
}
