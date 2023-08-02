package com.learning.pageelements;

import com.learning.base.BaseClass;
import com.learning.utilities.Utilities;
import io.cucumber.java.af.En;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CartPage extends BaseClass {

    Utilities utilities=new Utilities();

        Target name= Target.the("name").located(By.xpath("//div[@class='inventory_item_name']"));

        Target cost= Target.the("cost").located(By.xpath("//div[@class='inventory_item_price']"));


        Target description= Target.the("description").located(By.xpath("//div[@class='inventory_item_desc']"));

    Target checkout= Target.the("checkoutButton").located(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));

    Target title=Target.the("title").located(By.xpath("//div[text()='Your Cart']"));

public void verifyDetails_CartPage() throws IOException {
    Map<String,String> expectedData=utilities.readFromTextFile();
    name.waitingForNoMoreThan(Duration.ofSeconds(8));

    Ensure.that(name.resolveFor(getActor()).getText()).equals(expectedData.get("title"));
    Ensure.that(description.resolveFor(getActor()).getText()).equals(expectedData.get("description"));
    Ensure.that(cost.resolveFor(getActor()).getText().replace("$","")).equals(expectedData.get("cost"));
}

public void clickOnCheckOutButton(){
    Ensure.that(checkout).isEnabled();
    getActor().attemptsTo(Click.on(checkout));
}

public void isUserOnCartPage(){
    Ensure.that(checkout).isDisplayed();
}

}
