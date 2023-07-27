package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.HeadersPage;
import com.learning.pageelements.ProductsPage;
import io.cucumber.java.en.*;

import java.io.IOException;

public class ProductPageStepDefinitions extends BaseClass {

    ProductsPage productsPage=new ProductsPage();
    HeadersPage headersPage=new HeadersPage();


    @When("user selects a random product")
    public void user_selects_a_random_product() throws IOException {
       productsPage.clickOnRandomProduct();
    }

    @Then("Cart symbol should be displayed with count of {string}")
    public void cart_symbol_should_be_displayed_with_count_of(String count) {
       headersPage.verifyCartCount(count);
    }


}
