package commentLibs.implementation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commentLibs.contract.Driver;

public class CommonDriver implements Driver {

	private WebDriver driver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout;
	
	
	public CommonDriver(String browserType) throws Exception
	{
		//Constructor
		
		//default values for wait time
		pageLoadTimeout = 30l;
		elementDetectionTimeout=10l;
		
		browserType=browserType.trim();
		//this trims the blanks from beginning to end of input statement
		
		switch(browserType.toLowerCase())
		{
		case "edge":
			
			System.setProperty("webdriver.msgedge.driver", "C:\\Users\\gerik\\OneDrive\\Desktop\\seleniumtutorial\\drivers\\msedgedriver.exe");

			
			break;
		case "firefox" :
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\gerik\\OneDrive\\Desktop\\seleniumtutorial\\drivers\\geckodriver.exe");

		
		break;
		
		case "chrome" :
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\gerik\\OneDrive\\Desktop\\seleniumtutorial\\drivers\\chromedriver.exe");

		    WebDriver driver = new ChromeDriver();
			
			break;
			
			default:
				throw new Exception("Invalid Brpwser Type : " + browserType);
		
		}
	}
	
	@Override
	public void openBrowserandNavigateTo(String url) throws Exception {
		
		url =url.trim();

		if(url.isEmpty())
		{
			url="about:blank";
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//This method is deprecated with Selenium 4
		//driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
		//so instead i can use these
	   // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

		driver.get(url);
	}

	@Override
	public void closeCurrentBrowser() throws Exception {

		if(driver !=null)
		{
			driver.close();
		}
		
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver !=null)
		{
			driver.quit();
		}
				
	}

	@Override
	public String getTitleofThePage() throws Exception {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();
	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();	
	}

	@Override
	public void refresh() throws Exception {

		driver.navigate().refresh();
		
	}

	public long getElementDetectionTimeout() {
		return elementDetectionTimeout;
	}

	public void setElementDetectionTimeout(long elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public long getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	public void setPageLoadTimeout(long pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	

	
}
