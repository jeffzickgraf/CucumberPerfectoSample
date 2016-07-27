package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public abstract class TopPageObject extends PageObject{
	public TopPageObject(PerfectoDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public abstract void validate();

	public abstract void PutAppName(String sAppName);
	public abstract void Confirm3rd();
}
