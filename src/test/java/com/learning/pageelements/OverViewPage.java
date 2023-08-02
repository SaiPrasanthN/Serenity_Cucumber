package com.learning.pageelements;

import com.learning.base.BaseClass;
import com.learning.utilities.Utilities;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OverViewPage extends BaseClass {


    Utilities utilities=new Utilities();



    Target header=Target.the("header").located(By.xpath("//div[text()='Checkout: Your Information']"));

    Target firstName=Target.the("firstName").located(By.xpath("//input[@id='first-name']"));

    Target lastName=Target.the("lastName").located(By.xpath("//input[@id='last-name']"));

    Target postalCode=Target.the("postalCode").located(By.xpath("//input[@id='postal-code']"));

Target continueButton=Target.the("continueButton").located(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']"));




public void enterDetails(){
    getActor().attemptsTo(Enter.theValue(utilities.generateRandomLetters(true,false)).into(firstName)
            .then(Enter.theValue(utilities.generateRandomLetters(true,false)).into(lastName))
            .then(Enter.theValue(utilities.generateRandomLetters(false,true)).into(postalCode)));



}

public void isUserOnOverviewPage(){
    Ensure.that(header).isDisplayed();
}

public void clickOnContinueButton(){
    getActor().attemptsTo(Click.on(continueButton));
}

}
