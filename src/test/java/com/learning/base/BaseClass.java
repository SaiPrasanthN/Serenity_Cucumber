package com.learning.base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    Actor james = OnStage.theActorCalled("James");
    public WebDriver driver= BrowseTheWeb.as(james).getDriver();

    public static Performable openBrowser() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(BaseURLClass.class));
    }



    public Actor getActor(){

        return    OnStage.theActorInTheSpotlight();
    }

}

