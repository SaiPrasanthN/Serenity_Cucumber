package com.learning.pageelements;

import com.learning.base.BaseClass;
import com.learning.utilities.Utilities;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductsPage extends BaseClass {

    public  Target pageTitle=Target.the("title").located(By.xpath("//div[@class='app_logo']"));
    Target hamburgerIcon=Target.the("hamBurgerIcon").located(By.xpath("//button[@id='react-burger-menu-btn']"));

    Target logoutButton=Target.the("logout").located(By.xpath("//a[@id='logout_sidebar_link']"));

    Target iconList=Target.the("itemsText").located(By.xpath("//a[contains(@id,'sidebar_link')]"));

    Target productNames=Target.the("productName").located(By.xpath("//div[@class='inventory_item_name']"));

Target productTitle=Target.the("productTitle").located(By.xpath("//div[@class='product_label']"));

    public void logout(){
        getActor().attemptsTo(JavaScriptClick.on(hamburgerIcon));
        List<String> iconsText=iconList.resolveAllFor(getActor()).texts();

        for(String text:iconsText){
            System.out.println(text);
        }
        getActor().attemptsTo(Click.on(logoutButton).afterWaitingUntilPresent());



    }

    public void clickOnRandomProduct() throws IOException {
        int size=productNames.resolveAllFor(getActor()).size();
        int varsize=  ThreadLocalRandom.current().nextInt(1,size);

        Utilities utilities=new Utilities();

        Target productLink=Target.the("productButton").located(By.xpath("(//div[@class='inventory_item_name'])["+varsize+"]"));
        Target cost=Target.the("cost").located(By.xpath("(//div[@class='inventory_item_name'])["+varsize+"]/ancestor::div[2]//div[@class='inventory_item_price']"));
        Target description=Target.the("description").located(By.xpath("(//div[@class='inventory_item_name'])["+varsize+"]/ancestor::div[2]//div[@class='inventory_item_price']"));
        String productText=productLink.resolveFor(getActor()).getText();
        String price=cost.resolveFor(getActor()).getText();
        String desc=description.resolveFor(getActor()).getText();
        utilities.writeToTextFile("title="+productText+"\n"+"cost="+price+""+"\n"+"description="+desc+"");
        getActor().attemptsTo(Click.on(productLink));
    }


}
