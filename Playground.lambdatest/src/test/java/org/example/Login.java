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

public class Login {

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
    @QaseTitle("Login")
    public void loginTest() throws InterruptedException {
        driver.get (baseUrl);

        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.id("input-email")).sendKeys("Hej@Hejsson.com");
        driver.findElement(By.id("input-password")).sendKeys("HejHej1");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @AfterMethod
    public void avsluta(){
        driver.quit();
    }


}
