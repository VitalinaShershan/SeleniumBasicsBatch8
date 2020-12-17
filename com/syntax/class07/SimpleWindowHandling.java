package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {
    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle(); // getting current window handle
        System.out.println("Parent handle " + mainPageHandle);
        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles(); // will automatically return LInkedHashSet
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator(); // creating iterator in order to iterate through windows
        mainPageHandle = it.next(); // stepping forward to the main page
        String childHandle = it.next(); // stepping forward to child
        System.out.println("Child handle " + childHandle);
        Thread.sleep(2000);
        driver.switchTo().window(mainPageHandle); // switching back to parent window
        //driver.close();
        driver.quit();
    }
}
