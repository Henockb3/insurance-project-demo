package com.project.staragile.insureMeSeleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InsureMeSeleniumTest{
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		try {
            driver.get("http://ec2-3-138-33-98.us-east-2.compute.amazonaws.com:8081/contact.html");
			System.out.println(driver.getTitle());
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
			message.getText();
			if(message.getText().equalsIgnoreCase(("Message Sent"))){
				System.out.println("Test Case Passed");
			}else{
				System.out.println("Test Case Failed");
			}
			


        } finally {
            driver.quit();
        }
    }
}