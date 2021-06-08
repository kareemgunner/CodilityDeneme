package com.codility.step_definitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.automationpractice.com");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.id("email")).sendKeys("123abc456def@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Armms2020u");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
        WebElement image = driver.findElement(By.cssSelector("a.product_img_link"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",image);
        new Actions(driver).moveToElement(image).perform();
        WebElement moreButton = driver.findElement(By.cssSelector("a.button.lnk_view.btn.btn-default"));
        moreButton.click();
        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
        quantity.clear();
        quantity.sendKeys("2");
        WebElement group_1 = driver.findElement(By.id("group_1"));
        Select select = new Select(group_1);
        select.selectByVisibleText("M");
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.btn.btn-default.button.button-medium ")).click();














    }




}
