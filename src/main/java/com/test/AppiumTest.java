package main.java.com.test;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.html5.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Cookie.Builder;

import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.ios.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import PageObjects.*;
import DataDriver.*;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.testng;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

import com.perfectomobile.selenium.util.EclipseConnector;

/*@CucumberOptions(plugin = "json:target/cucumber.json", features = {
        "src/test/resources/features/Notification.feature",
        "src/test/resources/features/SecureDialog.feature"},
        glue = "com.test.stepdefs")*/

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/CucumberTest.feature",
format = {"json:target/integration_cucumber.json"}//what formatters to use
)//what tags to include(@)/exclude(@~)




public class AppiumTest extends BasicTest{

	static PerfectoDriver driver;
    static TopPageObject topPageObject;
    static String platformname;


	@BeforeClass
	@Parameters({"mcm", "deviceID", "platformName"})
    static public void BeforeClass(String mcm, String deviceID, String platformName) throws MalformedURLException, IOException {
        System.out.println("Run started");


        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = mcm;

        boolean bEnablePersona = true;
        if( bEnablePersona ){
        	String personaName = WindTunnelUtils.GEORGIA;
        	capabilities.setCapability("scriptName", "RemoteWebDriverTest");
        	capabilities.setCapability("windTunnelPersona",personaName);
        }


        capabilities.setCapability("user", System.getProperty("PerfectoUsername"));
        capabilities.setCapability("password", System.getProperty("PerfectoPassword"));
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("deviceName", deviceID);
        capabilities.setCapability("scriptName", "RemoteWebDriverTest");
        
        // Call this method if you want the script to share the devices with the Perfecto Lab plugin.
        setExecutionIdCapability(capabilities, host);
        System.out.println(host);
        driver = new PerfectoDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       
		// Switch context to native
	    switchToContext(driver, "NATIVE_APP") ;
	    //switchToContext(driver, "WEBVIEW") ;

		System.out.println(driver);

		//Push home button
		driver.PushHome();
		platformname = platformName;
		if(platformName.equals("Android")){
			topPageObject = new TopPageObjectAndroid(driver);
		} else {
//			topPageObject = new TopPageObjectIOS(driver);
		}


	}
	
	static public void PushHome()
	{
		driver.PushHome();
	}
	
	static public void CloseApp(String sAppName )
	{
		driver.CloseApp( sAppName );
	}
	
	static public void StartApp(String sAppName )
	{
		driver.StartApp( sAppName );
	}
	
	static public PageObject GetPageObject( String sPageName)
	{
		switch( sPageName ){
		case "TopPage":
			return topPageObject;
		}
		return null;
	}
	
	@AfterClass
	@Step("Teardown")
    static public void afterTest() throws MalformedURLException, IOException {
        try {
            driver.close();
            String ReportDir = "/Users/jeffz/Documents/Test/report"+"/"+platformname;
            PerfectoLabUtils.downloadReport(driver, "html", ReportDir);
            // In case you want to down the report or the report attachments, do it here.
            PerfectoLabUtils.downloadReport(driver, "pdf", ReportDir);
            PerfectoLabUtils.downloadAttachment(driver, "video", ReportDir+"/video", "flv");
            PerfectoLabUtils.downloadAttachment(driver, "image", ReportDir+"/images", "jpg");

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
        System.out.println("Run ended");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    private static void setExecutionIdCapability(DesiredCapabilities capabilities, String host) throws IOException {
        EclipseConnector connector = new EclipseConnector();
        String eclipseHost = connector.getHost();
        if ((eclipseHost == null) || (eclipseHost.equalsIgnoreCase(host))) {
            String executionId = connector.getExecutionId();
            capabilities.setCapability(EclipseConnector.ECLIPSE_EXECUTION_ID, executionId);
        }
    }
}
