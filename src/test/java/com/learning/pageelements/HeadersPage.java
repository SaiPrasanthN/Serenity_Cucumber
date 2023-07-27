package com.learning.pageelements;

import com.learning.base.BaseClass;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeadersPage extends BaseClass {

    Target cartCount=Target.the("cartCount").located(By.xpath("//span[@class='shopping_cart_badge']"));

    public void verifyCartCount(String count){
        Ensure.that(cartCount.resolveFor(getActor()).getText()).equals(count);

    }
}
