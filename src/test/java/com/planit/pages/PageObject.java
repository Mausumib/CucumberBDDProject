package com.planit.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.planit.Utilities.CommonFunctionPage;

public class PageObject extends CommonFunctionPage{

	WebDriver ldriver;

	public PageObject(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	public WebElement login;

	@FindBy(xpath = "//input[contains(@id,'Email')]")
	public WebElement username;

	@FindBy(xpath = "//input[contains(@id,'Password')]")
	public WebElement password;

	@FindBy(xpath = "//input[contains(@value,'Log in')]")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@class='header']/descendant::a[@class='account']")
	public WebElement validateUserName;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	public WebElement clickUpdateShopping;

	@FindBy(xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")
	public WebElement emptyShoppingCart;

	@FindBy(xpath = "//ul[@class='top-menu']/descendant::a[contains(text(),'Computers')]")
	public WebElement clickComputer;

	@FindBy(xpath = "//ul[@class='top-menu']/descendant::a[contains(text(),'Desktops')]")
	public WebElement clickDesktop;

	@FindBy(xpath = "//div[@class='product-name']/h1")
	public WebElement validateProductName;

	@FindBy(xpath = "//div[@class='product-price']/span")
	public WebElement validateProductPrice;

	@FindBy(xpath = "//input[@class='qty-input']")
	public WebElement quantityInput;

	@FindBy(xpath = "//div[@id='bar-notification']/child::p[contains(text(),'The product has been added to your')]")
	public WebElement successMsg;

	@FindBy(xpath = "//div[@class='header-links']/descendant::span[text()='Shopping cart']")
	public WebElement clickShoppingCart;

	@FindBy(xpath = "//table[@class='cart-total']/descendant::tr[1]/descendant::span[@class='product-price']")
	public WebElement subTotal;

	@FindBy(xpath = "//input[@id='termsofservice']")
	public WebElement clickAgreeBtn;

	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement clickCheckOutBtn;

	@FindBy(xpath = "//div[@class='section select-billing-address']/label")
	public WebElement billingAddressHeader;

	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	public WebElement enterCity;

	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	public WebElement enterAddress1;

	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	public WebElement enterZip;

	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	public WebElement enterPhoneNumber;

	@FindBy(id = "billing-address-select")
	public WebElement billingAddresDD;

	@FindBy(id = "BillingNewAddress_CountryId")
	public WebElement countryDD;

	@FindBy(xpath = "//div[@id='billing-buttons-container']/input[@title='Continue']")
	public WebElement continueBtnInBillingAddress;

	@FindBy(xpath = "//div[@id='shipping-buttons-container']/input[@title='Continue']")
	public WebElement continueBtnInShippingAddress;

	@FindBy(xpath = "//input[contains(@value,'Next Day Air')]")
	public WebElement nextDayAirRadioBtn;

	@FindBy(xpath = "//div[contains(@id,'shipping-method-buttons-container')]/descendant::input[@value='Continue']")
	public WebElement continueBtnInShippingMethod;

	@FindBy(xpath = "//div[contains(@id,'payment-method-buttons')]/descendant::input[@value='Continue']")
	public WebElement continueBtnInPaymentMethod;

	@FindBy(xpath = "//h2[text()='Payment information']/../following::div/descendant::div[contains(@class,'payment-info')]/descendant::p")
	public WebElement paymentInfo;

	@FindBy(xpath = "//div[contains(@id,'payment-info-buttons')]/descendant::input[@value='Continue']")
	public WebElement continueBtnInPaymentInfo;

	@FindBy(xpath = "//input[@value='Confirm']")
	public WebElement confirmBtn;

	@FindBy(xpath = "//div[@class='title']/strong")
	public WebElement orderSuccessMsg;

	@FindBy(xpath = "//ul[@class='details']/li[1]")
	public WebElement orderNumber;

	@FindBy(xpath = "//div[@class='section order-completed']/descendant::input[@value='Continue']")
	public WebElement continueBtnInOrderCompleted;

	@FindBy(xpath = "//a[text()='Log out']")
	public WebElement logoutBtn;

	@FindBy(xpath = "//td[@class='product-picture']")
	public List<WebElement> productPicture;

	@FindBy(xpath = "//input[@name='removefromcart']")
	public WebElement productsList;

	@FindBy(id = "shipping-address-select")
	public WebElement shippingAddressDD;

	@FindBy(xpath = "//div[@class='header-logo']")
	public WebElement logo;

	public WebElement wait(WebElement element, int time) {
		WebElement ele = new WebDriverWait(ldriver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOf(element));
		return ele;
	}	

	public void loginApplication() {
		wait(login, 10).click();
	}

	public void enterUserName(String name) {
		username.sendKeys(name);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void validateUserAccountId(String expUserName) {
		String actualUserName = validateUserName.getText();
		Assert.assertTrue(actualUserName.contains(expUserName));
	}

	public void clearShoppingCart() {
		wait(clickShoppingCart, 5).click();

		if (productPicture.size() > 0) {
			productsList.click();
			clickUpdateShopping.click();
		} else {
			System.out.println("Print the message :" + emptyShoppingCart.getText());
		}
	}

	public void clickComputers() {
		Actions action = new Actions(ldriver);
		action.moveToElement(wait(clickComputer, 2)).moveToElement(clickDesktop).click().perform();
	}

	public void selectProduct(String productName) {
		WebElement desktopList = ldriver.findElement(
				By.xpath("//div[@class='item-box']/descendant::h2/a[contains(text(),'" + productName + "')]"));
		desktopList.click();
	}

	public void validateSelectedProduct(String quantity, String productName) {
		String expProductName = validateProductName.getText();
		if (productName.contains(expProductName)) {
			String productPrice = validateProductPrice.getText();
			System.out.println(productPrice);
			wait(quantityInput, 5).clear();
			wait(quantityInput, 5).sendKeys(quantity);

		} else {
			System.out.println("This is not expected selected product");
		}
	}

	public void clickAddToCart(String productName) {
		WebElement addToCart = ldriver.findElement(By
				.xpath("//h1[contains(text(),'" + productName + "')]/../..//descendant::input[@value='Add to cart']"));
		wait(addToCart, 5).click();
	}

	public void validateSuccessMsg(String expMsg) {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,-350)", "");

		String actSuccessMsg = wait(successMsg, 5).getText();
		System.out.println(actSuccessMsg);

		if (actSuccessMsg.contains(expMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void validateSubTotalandClickCheckOut() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,-350)", "");

		wait(clickShoppingCart, 20).click();
		String subTotalCost = subTotal.getText();
		System.out.println("Print Sub Total :" + subTotalCost);
		wait(clickAgreeBtn, 5).click();
		wait(clickCheckOutBtn, 5).click();
	}

	public void billingAddress(String newAddress, String countryName, String city, String address1, String zip,
			String contactNumber) {
		if (billingAddressHeader.isDisplayed()) {
			Select billingAddressDD = new Select(billingAddresDD);
			billingAddressDD.selectByVisibleText(newAddress);

			Select country = new Select(countryDD);
			country.selectByVisibleText(countryName);

			enterCity.sendKeys(city);
			enterAddress1.sendKeys(address1);
			enterZip.sendKeys(zip);
			enterPhoneNumber.sendKeys(contactNumber);
			continueBtnInBillingAddress.click();

			wait(continueBtnInShippingAddress, 5).click();
		}
	}

	public void clickNextDayAirRadioBtn() {
		wait(nextDayAirRadioBtn, 5).click();
		wait(continueBtnInShippingMethod, 5).click();
	}

	public void selectPaymentMethod(String method) {
		sleep(5);
		WebElement paymentMethod = ldriver.findElement(
				By.xpath("//div[@class='payment-details']/label[contains(text(),'" + method + "')]/../input"));
		String expValue = paymentMethod.getAttribute("checked");
		System.out.println("Print the attribute value : " + expValue);

		if (paymentMethod.equals(expValue)) {
			Assert.assertTrue(true);
		} else {
			wait(paymentMethod, 5).click();

			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].scrollIntoView();", continueBtnInPaymentMethod);
			wait(continueBtnInPaymentMethod, 5).click();
		}
	}

	public void validateMsgInPaymentInfo(String expPaymentMsg) {
		String actualPaymentMsg = wait(paymentInfo, 5).getText();

		if (actualPaymentMsg.equals(expPaymentMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		wait(continueBtnInPaymentInfo, 5).click();
	}

	public void clickConfirmBtn() {
		wait(confirmBtn, 5).click();
	}

	public void validateOrderSuccessMsg(String expSuccessMsg) {
		String actualSuccessMsg = wait(orderSuccessMsg, 5).getText();

		if (actualSuccessMsg.equals(expSuccessMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		String orderNumberDetails = wait(orderNumber, 2).getText();
		System.out.println("Print order number details :" + orderNumberDetails);

		wait(continueBtnInOrderCompleted, 5).click();
	}

	public void clickLogOutBtn() {
		wait(logoutBtn, 5).click();
	}
}
