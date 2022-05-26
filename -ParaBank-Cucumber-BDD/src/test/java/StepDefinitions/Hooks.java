package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.BaseClass;
import utils.CommonMethod;

public class Hooks extends CommonMethod{

    @Before
    public void startTest(){
        BaseClass.setUp();
    }


    @After
    public void endTest(Scenario scenario){

        byte[] screenshot;

        if (scenario.isFailed()){
            logger.info("Failed");

            screenshot=CommonMethod.takeScreen("failed/"+scenario.getName());
        }else{
            screenshot=CommonMethod.takeScreen("passed/"+scenario.getName());
            logger.info("Passed");
        }



        BaseClass.teardown();
    }
}
