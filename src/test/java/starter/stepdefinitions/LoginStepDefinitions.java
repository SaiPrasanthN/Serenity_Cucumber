package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDefinitions extends BaseClass {

    LoginPage loginPage=new LoginPage();
    @Given("user is on login Page")
    public void user_is_on_login_page() {
        james.wasAbleTo(openBrowser());
     loginPage.isUserOnLoginPage();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
     loginPage.login("standard_user","standard_user");
    }
    @When("clicks on LoginButton")
    public void clicks_on_login_button() {
      loginPage.clickOnLoginButton();
    }
    @Then("user is on HomePage")
    public void user_is_on_home_page() {

    }
}
