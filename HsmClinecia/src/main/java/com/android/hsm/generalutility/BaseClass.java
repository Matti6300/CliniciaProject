package com.android.hsm.generalutility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.android.hsm.fileutility.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	AppiumDriverLocalService service;
	
	PropertyFileUtility pu= new PropertyFileUtility();
	
	@BeforeSuite
	public void ConectingToServer() throws IOException {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", pu.getTheDataFromPropertyfile("devicename"));
		dc.setCapability("UDID", pu.getTheDataFromPropertyfile("udid"));
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		URL u =new URL(pu.getTheDataFromPropertyfile("url"));
		driver =new AndroidDriver(u,dc);
		 service = new AppiumServiceBuilder().withAppiumJS(new File(pu.getTheDataFromPropertyfile("jsPath"))).
				 withIPAddress(pu.getTheDataFromPropertyfile("ip")).usingPort(4723)
				 .withTimeout(Duration.ofSeconds(3000)).build();
		 service.start();		
	}
	
	@BeforeClass
	public void openingTheApplication() throws IOException {
		driver.activateApp(pu.getTheDataFromPropertyfile("appPackage"));
	}
	
	
	@BeforeMethod
	public void loggingIntoApp(){
		
		
		System.out.println("lpgged out from the application");
		
		
	}

}
