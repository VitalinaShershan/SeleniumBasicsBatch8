package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitHandling {

    public static String url = "http://syntaxtechs.com/selenium-practice/dynamic-data-loading-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20); // creating webdriverwait object and setting for 20 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'First Name :')]"))); // waiting until
                                                                                                                // expected conditions "visibility of element"

        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(), 'First Name :')]"));
        String firstNameText = firstName.getText();
        System.out.println(firstNameText);
    }
}
