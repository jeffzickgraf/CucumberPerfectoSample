package PageObjects;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

import org.openqa.selenium.remote.RemoteWebDriver;

public class TopPageObjectAndroid extends TopPageObject{
	public TopPageObjectAndroid(PerfectoDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void validate(){
		
		try
		{
			driver.TextCheckPoint("google","0%", "30%", "English");
		} 
		catch(Exception e){}
	}

	@FindBy(xpath="//*[@resource-id=\"com.android.vending:id/search_box_idle_text\"]")
	WebElement AppNameTextBox;
	public void PutAppName(String sAppName)
	{
		AppNameTextBox.sendKeys(sAppName);
		
		Map<String, Object> params3 = new HashMap<>();
		params3.put("label", "PRIVATE:TestImages\\Cucumber\\Galaxy6sSearch.png");
		params3.put("screen.top", "63%");
		params3.put("screen.height", "37%");
		params3.put("screen.left", "20%");
		params3.put("screen.width", "80%");
		Object result3 = driver.executeScript("mobile:button-image:click", params3);
		
	}

	@FindBy(xpath="//*[@resource-id=\"com.android.vending:id/search_results_list\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")
	WebElement Confirm3rdExisting;
	public void Confirm3rd()
	{
		Confirm3rdExisting.click();
	}
	
}
