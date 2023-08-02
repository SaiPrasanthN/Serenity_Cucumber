package com.learning.pageelements;

import com.learning.base.BaseClass;
import com.learning.utilities.Utilities;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FinishPage extends BaseClass {

    Utilities utilities=new Utilities();

    Target name= Target.the("name").located(By.xpath("//div[@class='inventory_item_name']"));

    Target cost= Target.the("cost").located(By.xpath("//div[@class='inventory_item_price']"));


    Target description= Target.the("description").located(By.xpath("//div[@class='inventory_item_desc']"));

Target paymentInfoHeader=Target.the("paymentInfoHeader").located(By.xpath("//div[text()='Payment Information:']"));

    Target shippingInfoHeader=Target.the("shippingInfoHeader").located(By.xpath("//div[text()='Shipping Information:']"));


    Target itemTotal=Target.the("itemTotal").located(By.xpath("//div[contains(text(),'Item total:')]"));


    Target tax=Target.the("tax").located(By.xpath("//div[contains(text(),'Tax:')]"));


    Target total=Target.the("total").located(By.xpath("//div[contains(text(),'Total:')]"));


    Target itemTotalAmount=Target.the("itemTotal").located(By.xpath("//div[@class='summary_subtotal_label']"));


    Target taxAmount=Target.the("tax").located(By.xpath("//div[@class='summary_tax_label']"));


    Target totalAmount=Target.the("total").located(By.xpath("//div[@class='summary_info_label summary_total_label']"));
    Target paymentInfo=Target.the("paymentInfo").located(By.xpath("(//div[@class='summary_value_label'])[1]"));
    Target shippingInfo=Target.the("shippingInfo").located(By.xpath("(//div[@class='summary_value_label'])[2]"));

    Target finishButton=Target.the("finishButton").located(By.xpath("//button[@class='btn btn_action btn_medium cart_button']"));
    Target headerText=Target.the("headerText").located(By.xpath("//h2[@class='complete-header']"));
    Target subText=Target.the("subText").located(By.xpath("//div[@class='complete-text']"));

Target image=Target.the("image").located(By.xpath("//img[@class='pony_express']"));


public void isUserOnFinishPage(){
    Ensure.that(name).isDisplayed();
}

public void verifyTitlesOnFinishPage(){
    Ensure.that(paymentInfoHeader.resolveFor(getActor()).getText()).equals("Payment Information:");
    Ensure.that(shippingInfoHeader.resolveFor(getActor()).getText()).equals("Shipping Information:");
    Ensure.that(itemTotal.resolveFor(getActor()).getText()).equals("Item total:");
    Ensure.that(tax.resolveFor(getActor()).getText()).equals("Tax:");
    Ensure.that(total.resolveFor(getActor()).getText()).equals("Total:");
}


    public void verifyDetails_FinishPage() throws IOException {
        Map<String,String> expectedData=utilities.readFromTextFile();
        name.waitingForNoMoreThan(Duration.ofSeconds(8));
        String item=utilities.getSubStringAfter(itemTotalAmount.resolveFor(getActor()).getText(),": ");
Ensure.that(name.resolveFor(getActor()).getText()).equals(item);
        Ensure.that(name.resolveFor(getActor()).getText()).equals(expectedData.get("title"));
        Ensure.that(description.resolveFor(getActor()).getText()).equals(expectedData.get("description"));
        Ensure.that(cost.resolveFor(getActor()).getText()).equals(expectedData.get("cost"));
verifyCost();
}

    private void verifyCost() throws IOException {
        String item=utilities.getSubStringAfter(itemTotalAmount.resolveFor(getActor()).getText(),"$");
        String tax=utilities.getSubStringAfter(taxAmount.resolveFor(getActor()).getText(),"$");
        BigDecimal itemCost=utilities.getBigDecimalFromString(item);
        BigDecimal taxCost=utilities.getBigDecimalFromString(tax);
        BigDecimal total=itemCost.add(taxCost).setScale(2, RoundingMode.UP);
Ensure.that(totalAmount.resolveFor(getActor()).getText()).equals("$"+ String.valueOf("total"));
}


public void clickOnFinishButton(){
    getActor().attemptsTo(Click.on(finishButton));
}

public void verifyOrderCompletion(){
    Ensure.that(headerText.resolveFor(getActor()).getText()).equals("THANK YOU FOR YOUR ORDER");
    Ensure.that(subText.resolveFor(getActor()).getText()).equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
Ensure.that(image).isDisplayed();
}




}



