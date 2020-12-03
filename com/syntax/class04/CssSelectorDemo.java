package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxtechs.com/selenium-practice/index.php");
        driver.findElement(By.cssSelector("a#btn_basic_example")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder ^= 'Please']")).sendKeys("2020 sucks");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick *= 'show']")).click();

        driver.quit();

    }
}
