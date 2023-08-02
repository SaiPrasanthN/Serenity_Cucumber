package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.CartPage;
import com.learning.pageelements.HeadersPage;
import io.cucumber.java.en.*;

import java.io.IOException;

public class CartPageStepDefinitions extends BaseClass {

    CartPage cartPage=new CartPage();
    @Then("user verifies details on cart page")
    public void user_verifies_details_on_cart_page() throws IOException {
cartPage.verifyDetails_CartPage();
    }

    @Then("user clicks on Cart Button")
    public void user_clicks_on_cart_button() {
        HeadersPage headersPage=new HeadersPage();
        headersPage.clickOnCartButton();
    }


    @Then("user should be on cart page")
    public void user_should_be_on_cart_page() {
      cartPage.isUserOnCartPage();
    }

    @When("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        cartPage.clickOnCheckOutButton();
    }
}
