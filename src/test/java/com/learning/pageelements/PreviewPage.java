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
import java.util.Map;

public class PreviewPage extends BaseClass {

    Target name=Target.the("name").located(By.xpath("//div[@class='inventory_details_name large_size']"));
    Target desc=Target.the("description").located(By.xpath("//div[@class='inventory_details_desc large_size']"));

    Target cost=Target.the("cost").located(By.xpath("//div[@class='inventory_details_price']"));

Target addToCartButton=Target.the("addToCartButton").located(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

    Target removeButton=Target.the("removeButton").located(By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']"));


    ProductsPage productsPage=new ProductsPage();
Utilities utilities=new Utilities();

public void isUserOnPreviewPage(){
    Ensure.that(productsPage.productTitle).isNotDisplayed();
}

    public void verifyProductDetails() throws IOException {

        Map<String,String> expectedData=utilities.readFromTextFile();
        name.waitingForNoMoreThan(Duration.ofSeconds(8));
        Ensure.that(name.resolveFor(getActor()).getText()).equals(expectedData.get("title"));
        Ensure.that(desc.resolveFor(getActor()).getText()).equals(expectedData.get("description"));
        Ensure.that(cost.resolveFor(getActor()).getText()).equals(expectedData.get("cost"));
    }

    public void clickOnAddToCartButton(){
    getActor().attemptsTo(Click.on(addToCartButton));
        Ensure.that(removeButton).isDisplayed();
        Ensure.that(removeButton).isEnabled();
    }
}
