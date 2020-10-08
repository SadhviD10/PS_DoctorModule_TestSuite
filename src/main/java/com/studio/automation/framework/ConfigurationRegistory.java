package com.studio.automation.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import com.studio.utils.InitData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 * @author nimit.jain
 *
 */
public class ConfigurationRegistory {
//	public static String sauceURL = System.getProperty("sauceURL");
	Map<String, Object> registry;
	private static String OS = System.getProperty("os.name").toLowerCase();

//	public static String url;
	@SuppressWarnings("unchecked")
	public ConfigurationRegistory() {
		registry = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configurationRegistry.yaml"));
	}

	public WebDriver getDriver(Map<String, Object> config) throws MalformedURLException {
		Map<String, Object> options = new HashMap<String, Object>();
		return getDriver(config, options);
	}

	public WebDriver getDriver(Map<String, Object> config, Map<String, Object> options) throws MalformedURLException {
		String projectPath = System.getProperty("user.dir");
		String driverPath = null;
		String testConfiguration = null;
		System.out.println(OS);

		if (isWindows()) {
			System.out.println("This is Windows");
			driverPath = projectPath + "" + "/src/main/resources/drivers/window/chromedriver.exe";
		} else if (isMac()) {
			System.out.println("This is Mac");
			driverPath = projectPath + "" + "/src/main/resources/drivers/mac/chromedriver";
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			driverPath = projectPath + "" + "/src/main/resources/drivers/linux/chromedriver";
		} else {
			System.out.println("Your OS is not supported!!");
		}

		System.out.println("The driver path is " + driverPath);

		if (options.containsKey("TEST_CONFIGURATION")) {
			testConfiguration = options.get("TEST_CONFIGURATION").toString();
		}

		TestSession.logger.info("Launching Test Configuration: " + testConfiguration + " ...");
		System.out.println("Launching Test on Configuration: " + testConfiguration + " ...");

		Map<String, String> configRegistory = (Map<String, String>) registry.get(testConfiguration);
		WebDriver driver = null;

		System.out.println(configRegistory);

		// url=configRegistory.get("server");

		ChromeOptions chromeOptions;
		// switch (configRegistory.get("os").toLowerCase()) {
		switch (InitData.platformName) {
		case ("mac"):
			// TODO need to check if chromedriver exists
			System.setProperty("webdriver.chrome.driver", driverPath);
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");
			driver = new ChromeDriver(chromeOptions);
			break;

		case ("chrome"):
			System.out.println("In Chrome configuration");
			System.setProperty("webdriver.chrome.driver", driverPath);
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");
			// driver.get("https://demo:virgin2017@staging.virginmobile.sa/en/");
			driver = new ChromeDriver(chromeOptions);
			driver.get("https://doctors.qa.patientstudio.com/login");
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			// driver.get(configRegistory.get("server"));
			break;

		case "sauceWeb":

			DesiredCapabilities capabillities = DesiredCapabilities.chrome();
			capabillities.setCapability("version", "83");
			capabillities.setCapability("platform", Platform.WIN8_1);
			capabillities.setCapability("name", "Remote File Upload Test");

			driver = new RemoteWebDriver(new URL(
					"https://Test_10:568916d3-a46d-4317-8503-bdd4fec6382e@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
					capabillities);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.get("https://doctors.qa.patientstudio.com/login");
			// driver.get(configRegistory.get("server"));
			break;

		}

		return driver;
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

}
