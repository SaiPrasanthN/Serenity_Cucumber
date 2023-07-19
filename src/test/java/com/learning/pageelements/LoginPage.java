package com.learning.pageelements;

import com.learning.base.BaseClass;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

public class LoginPage extends BaseClass {

    Target username=Target.the("userName").located(By.xpath("//input[@id='user-name']"));
    Target password=Target.the("password").located(By.xpath("//input[@id='password']"));
    Target loginButton=Target.the("loginButton").located(By.xpath("//input[@data-test='login-button']"));

    public void isUserOnLoginPage(){
        boolean isUser=james.asksFor(CurrentVisibility.of(loginButton));
       Assert.assertTrue(isUser);
    }

    public void login(String userName,String password){
        james.attemptsTo(Enter.theValue(userName).into(username)
                .then(Enter.theValue(password).into(this.password)));
    }

    public void clickOnLoginButton(){
        james.attemptsTo(Click.on(loginButton));
    }
}
