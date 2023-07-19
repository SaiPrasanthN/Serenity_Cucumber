package starter.stepdefinitions;

import com.learning.base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinitions {


@Before
public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());


}
}
