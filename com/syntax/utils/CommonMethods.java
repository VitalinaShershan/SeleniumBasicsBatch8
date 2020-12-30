package com.syntax.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class CommonMethods {

    protected static WebDriver driver;

    /**
     * this method will open a browser, set up configuration and navigate to the URL
     */
    public static void setUp() {

        ConfigsReader.readProperties("/Users/syntax/IdeaProjects/Batch8/TestNGBasics/src/configs/configuration.properties");
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Ivalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * this method will close any open browser
     */
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
