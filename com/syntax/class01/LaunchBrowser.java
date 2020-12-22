package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                                                        //   chromedriver.exe for windows users
                                                        // you can also use \\

        WebDriver driver = new ChromeDriver(); // launch the browser
        driver.get("https://syntaxtechs.com"); // navigate to url
        String url = driver.getCurrentUrl();  // getting current url
        System.out.println(url);
        String title = driver.getTitle();  // getting title of the page
        System.out.println(title);
        driver.quit();
    }
}
