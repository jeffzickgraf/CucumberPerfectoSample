package PageObjects;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PerfectoDriver extends RemoteWebDriver {

//	RemoteWebDriver driver;

	public void SetLocation( String location ){
		Map<String, Object> params4 = new HashMap<>();
		params4.put("address", location);
		Object result4 = this.executeScript("mobile:location:set", params4);

	}
	
	public Object PushHome()
	{
		Map<String, Object> params = new HashMap<>();
		params.put("keySequence", "HOME");
		return this.executeScript("mobile:presskey", params);

	}
	
	public Object CloseApp(String sAppName)
	{
		
		Map<String, Object> params = new HashMap<>();
		params.put("identifier", sAppName );
		Object result ;
		result=null;
		try{
			result = this.executeScript("mobile:application:close", params);
		}catch(Exception E){
//			result = new Object();
//			result.
			result = new String( "Application close failed!");
			System.out.println("Application lose failed");
		}
		return result;
	}

	public Object StartApp(String sAppName)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("identifier", sAppName );
		Object result ;
		try{
			result = this.executeScript("mobile:application:open", params);
		}catch(Exception E){
//			result = new Object();
//			result.
			result = new String( "Application start failed!");
			System.out.println("Application lose failed");
		}
		return result;
	}
	
	public PerfectoDriver(URL url , DesiredCapabilities capabilities){
		super( url , capabilities);
	}
	
	public Object TextCheckPoint(String content, String top, String height,String lang){
		return TextCheckPoint( content , top , height , lang , 30);
	}	
	
	
	public Object TextCheckPoint(String content, String top, String height,String lang,int timeout){
		System.out.println("Checking:"+content);
		List<String> languages = new ArrayList<>();
		languages.add(lang);
		Map<String, Object> param_OCR = new HashMap<>();
		param_OCR.put("content", content);
		param_OCR.put("screen.top", top);
		param_OCR.put("screen.height", height);
		param_OCR.put("screen.left", "0%");
		param_OCR.put("screen.width", "100%");
		param_OCR.put("profile", "TextExtraction_Speed");
		param_OCR.put("policy", "performance");
		param_OCR.put("timeout", String.valueOf(timeout) );
		param_OCR.put("language", languages);Map<String, Object> params1 = new HashMap<>();
		param_OCR.put("threshold", "80");
		
		return  this.executeScript("mobile:checkpoint:text", param_OCR);
	}

	
	
	
	public Object TextButtonClick(String label, String top, String height,String lang){
		return TextButtonClick( label , top , height , lang , 30);
	}

	public Object TextButtonClick(String label, String top, String height,String lang,String analysys,String invert,int timeout){
		System.out.println("Waiting:"+label);
		List<String> languages = new ArrayList<>();
		languages.add(lang);
		Map<String, Object> param_OCR = new HashMap<>();
		param_OCR.put("label", label);
		param_OCR.put("screen.top", top);
		param_OCR.put("screen.height", height);
		param_OCR.put("screen.left", "0%");
		param_OCR.put("screen.width", "100%");
		param_OCR.put("profile", "TextExtraction_Speed");
		param_OCR.put("policy", "performance");
		param_OCR.put("timeout", String.valueOf(timeout));
		param_OCR.put("language", languages);
		param_OCR.put("threshold", "90");
		param_OCR.put("analysis", analysys);
		param_OCR.put("inverse", invert);
		return this.executeScript("mobile:button-text:click", param_OCR);
	}
	
	public Object PickerSelect(String label, String top, String height,String lang){
		System.out.println("Waiting:"+label);
		List<String> languages = new ArrayList<>();
		languages.add(lang);
		Map<String, Object> param_OCR = new HashMap<>();
		param_OCR.put("label", label);
		param_OCR.put("screen.top", top);
		param_OCR.put("screen.height", height);
		param_OCR.put("screen.left", "0%");
		param_OCR.put("screen.width", "100%");
		param_OCR.put("profile", "TextExtraction_Speed");
		param_OCR.put("policy", "performance");
		param_OCR.put("timeout", String.valueOf(15));
		param_OCR.put("language", languages);
		param_OCR.put("threshold", "90");
		param_OCR.put("label.direction", "below");
		param_OCR.put("label.offset", "0.5%");
		return this.executeScript("mobile:button-text:click", param_OCR);
	}

	
	public Object TextButtonClick(String label, String top, String height,String lang,int timeout){
		System.out.println("Waiting:"+label);
		List<String> languages = new ArrayList<>();
		languages.add(lang);
		Map<String, Object> param_OCR = new HashMap<>();
		param_OCR.put("label", label);
		param_OCR.put("screen.top", top);
		param_OCR.put("screen.height", height);
		param_OCR.put("screen.left", "0%");
		param_OCR.put("screen.width", "100%");
		param_OCR.put("profile", "TextExtraction_Speed");
		param_OCR.put("policy", "performance");
		param_OCR.put("timeout", String.valueOf(timeout));
		param_OCR.put("language", languages);
		param_OCR.put("threshold", "90");
		
/*		
		Map<String, Object> params25 = new HashMap<>();
		params25.put("label", "〜4500");
		params25.put("threshold", "90");
		params25.put("screen.top", "60%");
		params25.put("screen.height", "40%");
		params25.put("screen.left", "0%");
		params25.put("screen.width", "100%");
		params25.put("profile", "TextExtraction_Speed");
		List<String> languages25 = new ArrayList<>();
		languages25.add("Japanese");
		params25.put("language", languages25);
		params25.put("policy", "performance");
		Object result25 = driver.executeScript("mobile:button-text:click", params25);
	*/	
		
		return this.executeScript("mobile:button-text:click", param_OCR);
	}
	

	
	public Object ImageButtonClick(String image , String top , String height )
	{
		System.out.println("Waiting:"+image);
		Map<String, Object> params7 = new HashMap<>();
//		params7.put("label", "PRIVATE:Toyoya_Portal\\Galaxy_currentPosButton.png");
		params7.put("timeout", "30");
		params7.put("label", image);
		params7.put("screen.top", top);
		params7.put("screen.height", height);
		params7.put("screen.left", "0%");
		params7.put("screen.width", "100%");
		params7.put("match", "bounded");
		return this.executeScript("mobile:button-image:click", params7);

	}
	
	public Object ImageButtonClick(String image , String left , String width , String top , String height )
	{
		System.out.println("Waiting:"+image);
		Map<String, Object> params7 = new HashMap<>();
//		params7.put("label", "PRIVATE:Toyoya_Portal\\Galaxy_currentPosButton.png");
		params7.put("timeout", "30");
		params7.put("label", image);
		params7.put("screen.top", top);
		params7.put("screen.height", height);
		params7.put("screen.left", left);
		params7.put("screen.width", width);
		params7.put("match", "bounded");
		return this.executeScript("mobile:button-image:click", params7);

	}
	
	
	
	

	public void testToyopet(String location)
	{

	}
}