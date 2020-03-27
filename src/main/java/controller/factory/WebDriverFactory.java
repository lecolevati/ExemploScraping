package controller.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public static String URL = "https://www.google.com.br";
	
	public WebDriver createWebDriver(String consulta) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
//		Habilitar essa função quando todo o código estiver pronto
//		options.addArguments("--headless"); 
		driver = new ChromeDriver(options); 
		
		URL = URL + "/search?q="+consulta;
		
		driver.get(URL); 
		driver.manage().getCookies();
		
		return driver;
	}
	
}
