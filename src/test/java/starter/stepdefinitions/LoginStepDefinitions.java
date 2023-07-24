package starter.stepdefinitions;

import com.learning.base.BaseClass;
import com.learning.pageelements.LoginPage;
import com.learning.pageelements.ProductsPage;
import io.cucumber.java.af.En;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.io.IOException;

public class LoginStepDefinitions extends BaseClass {

    LoginPage loginPage=new LoginPage();
    ProductsPage productsPage=new ProductsPage();
    @Given("user is on login Page")
    public void user_is_on_login_page() {
        getActor().wasAbleTo(openBrowser());
     loginPage.isUserOnLoginPage();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
     loginPage.login("standard_user","secret_sauce");
    }
    @When("clicks on LoginButton")
    public void clicks_on_login_button() {
      loginPage.clickOnLoginButton();
    }
    @Then("user is on HomePage")
    public void user_is_on_home_page() {
        Ensure.that(productsPage.pageTitle).getValue().equals("Swag Labs");
    }

    @When("user clicks on logout Button")
    public void user_clicks_on_logout_button() {
productsPage.logout();
    }
    @Then("user should land on Login Page")
    public void user_should_land_on_login_page() {
       loginPage.verifyCurrentTitle();
    }

    @When("user gets data from {string} file for login")
    public void user_gets_data_from_file_for_login(String fileName) throws IOException {
loginPage.loginWithBulkUsers(fileName);
    }

}
