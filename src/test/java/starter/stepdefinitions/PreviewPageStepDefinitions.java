package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.PreviewPage;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class PreviewPageStepDefinitions extends BaseClass {

    PreviewPage previewPage=new PreviewPage();

    @Then("user should be on preview Page")
    public void user_should_be_on_preview_page() {
previewPage.isUserOnPreviewPage();
    }

    @Then("user verifies data on preview page")
    public void user_verifies_data_on_preview_page() throws IOException {
previewPage.verifyProductDetails();
    }

    @Then("user clicks on AddToCart Button")
    public void user_clicks_on_add_to_cart_button() {
previewPage.clickOnAddToCartButton();
    }
}
