package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.FinishPage;
import io.cucumber.java.en.*;

import java.io.IOException;

public class FinishPageStepDefintions extends BaseClass {

    FinishPage finishPage=new FinishPage();

    @Then("user is on Finish Page")
    public void user_is_on_finish_page() {
       finishPage.isUserOnFinishPage();
    }

    @Then("user verifies all the details")
    public void user_verifies_all_the_details() throws IOException {
        finishPage.verifyDetails_FinishPage();
    }

    @Then("clicks on Finish Button")
    public void clicks_on_finish_button() {
      finishPage.clickOnFinishButton();
    }

    @Then("verifies confirmation order details")
    public void verifies_confirmation_order_details() {
       finishPage.verifyOrderCompletion();
    }

}
