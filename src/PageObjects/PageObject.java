package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObject {
	PerfectoDriver driver;
	PageObject( PerfectoDriver driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
//		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void validate()
	{
	}

}

//@FindBy(xpath="//*[starts-with(@name,\"btn shop\")]")
//device/view[1]