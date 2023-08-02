package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.OverViewPage;
import io.cucumber.java.en.*;

public class CheckoutOveriewPageStepDefinitions extends BaseClass {

    OverViewPage overViewPage=new OverViewPage();

    @Then("user is on OverView Page")
    public void user_is_on_over_view_page() {
    overViewPage.isUserOnOverviewPage();
    }

    @Then("user enters checkout details")
    public void user_enters_checkout_details() {
     overViewPage.enterDetails();
    }

    @Then("then user clicks on Continue Button")
    public void then_user_clicks_on_continue_button() {
        overViewPage.clickOnContinueButton();
    }
}
