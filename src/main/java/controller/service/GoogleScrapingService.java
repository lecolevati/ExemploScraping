package controller.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.factory.WebDriverFactory;

public class GoogleScrapingService {

	WebDriver driver;

	public String googleScraping(String consulta) throws InterruptedException {
		WebDriverFactory webDriverFactory = new WebDriverFactory();
		driver = webDriverFactory.createWebDriver(consulta);
		WebElement videos = driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]"));
		videos.click();

//		WebElement table = driver.findElement(By.xpath("//*[@id=\"rcnt\"]"));
//		String tableText = table.getText();
//		System.out.println(tableText);
		
		WebElement divTable = driver.findElement(By.xpath("//*[@id=\"rcnt\"]"));
		String tableText = divTable.getAttribute("innerHTML");
		driver.close();
		
		return tableText;
	}
	
}
