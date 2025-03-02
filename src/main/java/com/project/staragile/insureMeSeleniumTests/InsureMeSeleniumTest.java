package com.project.staragile.insureMeSeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsureMeSeleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-logging");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://18.218.238.178:8081/contact.html");
            System.out.println("Page Title: " + driver.getTitle());

            WebElement name = driver.findElement(By.id("inputName"));
            name.sendKeys("Test Name");

            WebElement number = driver.findElement(By.id("inputNumber"));
            number.sendKeys("1234567890");

            WebElement email = driver.findElement(By.id("inputMail"));
            email.sendKeys("test@example.com");

            WebElement message = driver.findElement(By.id("inputMessage"));
            message.sendKeys("Hello, this is a test message.");

            WebElement submitButton = driver.findElement(By.id("my-button"));
            submitButton.click();

            WebElement responseMessage = driver.findElement(By.id("response"));
            String responseText = responseMessage.getText();
            System.out.println("Response Message: " + responseText);

            if (responseText.equalsIgnoreCase("Message Sent")) {
                System.out.println("Test Case Passed");
            } else {
                System.out.println("Test Case Failed");
            }

        } finally {
            driver.quit();
        }
    }
}
