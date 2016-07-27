package main.java.com.test.stepdefs;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.com.test.AppiumTest;
import PageObjects.TopPageObject;


public class CucumberStepdefinitionTest {
    String input1,input2,result;
@Given("input1 is \"([^\"]*)\"$")
public void input1(String input1)
{
    this.input1=input1;
}
@Given("close app \"([^\"]*)\"$")
public void closeApp( String sAppName)
{
	AppiumTest.CloseApp(sAppName);
}
@Given("start app \"([^\"]*)\"$")
public void startApp( String sAppName)
{
	AppiumTest.StartApp(sAppName);
}
@Given("push home")
public void pushHome( )
{
	AppiumTest.PushHome();
}


@Then("Page should be \"([^\"]*)\"$")
public void validate( String sPageName)
{
	AppiumTest.GetPageObject(sPageName);
}

@Then("result should contain 3rd")
public void Confirm3rd()
{
	TopPageObject pageObject;
	pageObject = (TopPageObject) AppiumTest.GetPageObject("TopPage");
	pageObject.Confirm3rd();	
}

@Given("app name input is \"([^\"]*)\"$")
public void SearchAppName( String sAppName )
{
	TopPageObject pageObject;
	pageObject = (TopPageObject) AppiumTest.GetPageObject("TopPage");
	pageObject.PutAppName( sAppName );
}




@When("input2 is also \"([^\"]*)\"$")
public void input2(String input2)
{
    this.input2=input2;
}
@Then("result should be \"([^\"]*)\"$")
public void result(String result)
{
    this.result=result;
    Assert.fail();
}
}