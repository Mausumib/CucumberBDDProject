@PlanitTest
Feature: feature to test login functionality

  Scenario Outline: Check login
    Given user launch chrome browser
    When user opens url "<url>"
    And click login
    And user enters email as "<username>" and pwd as "<password>"
    And click login button
    Then page title should be "<pageTitle>"
    And validate username "<username>"
    And validate shopping cart is clear or clear the shopping cart if not empty
    And click COMPUTERS tab and then Desktops option
    And select "<productName>" computer from Desktops tab
    And enter "<quantity>" quantity for selected "<productName>" computer
    And add "<productName>" computer to cart
    Then validate "<addToCartMsg>" message displayed after adding the product to cart
    And click shopping cart and get the sub total of the product and click on check out button
    And select "<newAddress>" in billing address and select "<country>" Country and enter "<city>" City, "<address>" Address1, "<zip>" Zip and "<phNumber>" Contact Number
    And select Next day Air radio button and click continue button
    And select "<payment>" as payment method
    And validate "<paymentMsg>" message in payment information
    And click confirm button in Confirm Order page
    And validate "<successfullOrderMsg>" message after the order is successfully placed and get the order number
    And click logout button
    And close browser

    Examples: 
      | url                               | username               | password | pageTitle     | productName                   | quantity | addToCartMsg                       | newAddress  | country | city      | address  | zip    | phNumber  | payment          | paymentMsg          | successfullOrderMsg                         | shipingAdres                                   |
      | http://demowebshop.tricentis.com/ | planittest78@gmail.com |   123456 | Demo Web Shop | Build your own cheap computer |        2 | The product has been added to your | New Address | India   | Hyderabad | Madhapur | 500000 | 123456789 | Cash On Delivery | You will pay by COD | Your order has been successfully processed! | planit test, Madhapur, Hyderabad 500000, India |
