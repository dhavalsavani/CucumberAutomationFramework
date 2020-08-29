package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.config.Configuration;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialized WebDriver instance for the current thread.
	 */
	private static void InitializeWebdriver() {
		String browser = System.getProperty("browser").trim().toLowerCase();
		if(browser == null) {
			throw new RuntimeException("Please set system property names 'browser', for initializing browser.");
		}
		switch(browser) {
		case "chrome":
			initChrome();
			break;

		case "firefox":
			initFirefox();
			break;

		case "ie":
		case "internetexplorer":
			initIE();
			break;

		case "edge":
			initEdge();
			break;
			
		default:
			throw new RuntimeException("Unsupported/Unrecognizable browser: " + browser);
		}
	}

	/**
	 * Initialization method for chrome browser.
	 */
	private static void initChrome() {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
//		driver = new ChromeDriver(chromeOptions);
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(
				Integer.parseInt(Configuration.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	/**
	 * Initialization method for firefox browser.
	 */
	private static void initFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver.set(new FirefoxDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(
				Integer.parseInt(Configuration.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	/**
	 * Initialization method for ie browser.
	 */
	private static void initIE() {
		WebDriverManager.iedriver().setup();
		driver.set(new InternetExplorerDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(
				Integer.parseInt(Configuration.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	/**
	 * Initialization method for edge browser.
	 */
	private static void initEdge() {
		WebDriverManager.edgedriver().setup();
		driver.set(new EdgeDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(
				Integer.parseInt(Configuration.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}

	/**
	 * This method is used to close and quit the current WebDriver instance.
	 * Use this method cautiously as it will terminate current browser and webdriver instance.
	 */
	public static void close() {
		try {
			if(driver.get() != null) {
				driver.get().quit();
				driver.remove();
			}
		} catch (UnreachableBrowserException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * This method is used to get WebDriver instance for current thread.
	 * If current thread does not have WebDriver initialized, 
	 * then it will initialized WebDriver instance for current thread.
	 * 
	 * @return WebDriver instance for current thread
	 */
	public static WebDriver getDriver() {
		if(driver.get() == null) {
			InitializeWebdriver();
		}
		return driver.get();
	}
}