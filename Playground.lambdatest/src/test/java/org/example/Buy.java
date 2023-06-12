package org.example;

import io.qase.api.annotation.QaseTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Buy {

    private WebDriver driver;

    private final static String baseUrl = "https://ecommerce-playground.lambdatest.io/";


    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);


    }


    @Test
    @QaseTitle("Buy")
    public void loginTest() throws InterruptedException {
        driver.get(baseUrl);

        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.id("input-email")).sendKeys("Hej@Hejsson.com");
        driver.findElement(By.id("input-password")).sendKeys("HejHej1");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.cssSelector("div[id='entry_217822'] input[placeholder='Search For Products']")).sendKeys("Sony VAIO");
        driver.findElement(By.cssSelector("button[class='type-text']")).click();
        driver.findElement(By.cssSelector("div[class='carousel-item active'] img[title='Sony VAIO']")).click();
        driver.findElement(By.cssSelector("button[title='Buy now']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='input-payment-address-new']")).click();

        WebElement inputFirstName = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname")));
        inputFirstName.sendKeys("Hej");

        driver.findElement(By.id("input-payment-lastname")).sendKeys("Hejsson");
        driver.findElement(By.id("input-payment-company")).sendKeys("HejsanHoppsan");
        driver.findElement(By.id("input-payment-address-1")).sendKeys("Hejgatan1");
        driver.findElement(By.id("input-payment-city")).sendKeys("Stockholm");
        driver.findElement(By.id("input-payment-postcode")).sendKeys("12345");
        driver.findElement(By.cssSelector("label[for='input-agree']")).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='button-save']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("button-confirm")).click();



    }
}


