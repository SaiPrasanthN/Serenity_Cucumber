package starter.stepdefinitions;

import com.learning.base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.File;

public class ParameterDefinitions {


@Before
public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());

}


@After
    public void removeTextFile(){
    String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+
            "test"+File.separator+"resources"+File.separator+ "TestData.txt";
    File file=new File(path);
    file.delete();
}
}
