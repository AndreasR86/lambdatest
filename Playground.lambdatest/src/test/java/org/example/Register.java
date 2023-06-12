package org.example;

import io.qase.api.annotation.QaseTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Register {

    private WebDriver driver;

    private final static String baseUrl = "https://ecommerce-playground.lambdatest.io/";


    @BeforeClass
    public void beforeClass(){
    }

    @BeforeMethod
    public void beforeMethod(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);


    }


    @Test
    @QaseTitle("Register")
    public void Register() throws InterruptedException {
        driver.get (baseUrl);

        driver.findElement(By.linkText("My account")).click();

        driver.findElement(By.linkText("Continue")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Hej");

        driver.findElement(By.id("input-lastname")).sendKeys("Hejsson");

        driver.findElement(By.id("input-email")).sendKeys("Hej@Hejsson.com");

        driver.findElement(By.id("input-telephone")).sendKeys("07012345678");

        driver.findElement(By.id("input-password")).sendKeys("HejHej1");

        driver.findElement(By.id("input-confirm")).sendKeys("HejHej1");

        driver.findElement(By.cssSelector("label[for='input-agree']")).click();

        driver.findElement(By.cssSelector("input[value='Continue']")).click();

    }

    @AfterMethod
    public void avsluta(){
        driver.quit();
    }

}



