package com.learning.pageelements;

import com.learning.base.BaseClass;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BaseClass {

   public  Target pageTitle=Target.the("title").located(By.xpath("//div[@class='app_logo']"));
Target hamburgerIcon=Target.the("hamBurgerIcon").located(By.xpath("//button[@id='react-burger-menu-btn']"));

Target logoutButton=Target.the("logout").located(By.xpath("//a[@id='logout_sidebar_link']"));

Target iconList=Target.the("itemsText").located(By.xpath("//a[contains(@id,'sidebar_link')]"));

public void logout(){
   getActor().attemptsTo(JavaScriptClick.on(hamburgerIcon));
   List<String> iconsText=iconList.resolveAllFor(getActor()).texts();

   for(String text:iconsText){
      System.out.println(text);
   }
   getActor().attemptsTo(Click.on(logoutButton).afterWaitingUntilPresent());



}

}
