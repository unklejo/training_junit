package com.indivara.training.junit.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestJUnitOnBukaLapak {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"/Users/bagusalfa/Downloads/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// 30 detik sampai exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Launch website
		driver.navigate().to("https://www.bukalapak.com/"); // Search the
															// product, named
															// Juvia’s Place
		driver.findElement(By.id("search_keywords")).sendKeys("juvia's place");
		// Click the search button
		driver.findElement(
				By.xpath("//button[@class=\"omnisearch__submit c-omnisearch__button\"]"))
				.click();
		// Wait until the web is stable and the element mentioned available
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("product_sort_option")));
		// Making new object, named “urutan” to refer the sorting
		Select urutan = new Select(driver.findElement(By
				.xpath(".//*[@id='product_sort_option']")));
		// sorting price low to high
		urutan.selectByValue("price:asc");
		// Making a list, named “res” to keep the data of product after sorted
		List<WebElement> res = driver
				.findElements(By
						.xpath("//*[@id='display_product_search']/div[contains(@class,\"basic-products--grid\")]"));

		// looping to print the data to console
		for (WebElement listofProduct : res)
			System.out.println(listofProduct.getText()); // print data to
		// click on the first product
		driver.findElement(
				By.xpath("//div/article[@data-id=\"427587992\"]/div[@class=\"product-media\"]"))
				.click();

		driver.findElement(
				By.xpath("//div[contains(@class,\"js-buy-button\")]/div[@class=\"o-layout__item\"]/button"))
				.click();
		// verify if the QuickBuyer page appear
		String expectedUrl = "https://www.bukalapak.com/payment/purchases/new?product_id=427587992&product_sku_id=375145460&seller_ids=%5B9448705%5D";
		// driver.get(expectedUrl);

		assertEquals(expectedUrl, driver.getCurrentUrl());
		System.out.println("Correct Webpage");

		driver.close();
	}
	// closing the browser

}
