package com.learning.pageelements;

import com.learning.base.BaseClass;
import com.learning.utilities.Utilities;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

public class LoginPage extends BaseClass {

    Target username=Target.the("userName").located(By.xpath("//input[@id='user-name']"));
    Target password=Target.the("password").located(By.xpath("//input[@id='password']"));
    Target loginButton=Target.the("loginButton").located(By.xpath("//input[@data-test='login-button']"));

    public void isUserOnLoginPage(){
        boolean isUser=getActor().asksFor(CurrentVisibility.of(loginButton));
       Assert.assertTrue(isUser);
    }

    public void login(String userName,String password){
        getActor().attemptsTo(Enter.theValue(userName).into(username)
                .then(Enter.theValue(password).into(this.password)));
    }

    public void clickOnLoginButton(){
        getActor().attemptsTo(Click.on(loginButton));
    }

    public void verifyCurrentTitle(){
        loginButton.waitingForNoMoreThan(Duration.ofSeconds(8));

        Ensure.that(loginButton).getValue().equals("Login");
    }

public void loginWithBulkUsers(String fileName) throws IOException {
    Utilities utilities=new Utilities();
    ProductsPage productsPage=new ProductsPage();
    Map<String,String> dataVals=utilities.readData_Excel(fileName);
    Set<String>keySet=dataVals.keySet();

    for(String key:keySet){
    String password=dataVals.get(key);
    getActor().attemptsTo(Enter.theValue(key).into(username)
            .then(Enter.theValue(password).into(this.password)).then(Click.on(loginButton)));
        Ensure.that(productsPage.pageTitle).getValue().equals("Swag Labs");

    productsPage.logout();
    }
    }
}
