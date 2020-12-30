package com.syntax.class09;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingCalendars1 extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {
        setUp();
        WebElement username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'btnLogin']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement leaveButton = driver.findElement(By.linkText("Leave"));
        leaveButton.click();
        WebElement leaveListButton = driver.findElement(By.linkText("Leave List"));
        leaveListButton.click();
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();
        WebElement mDD = driver.findElement(By.className("ui-datepicker-month"));
        Select monthDD = new Select(mDD);
        monthDD.selectByVisibleText("Jul");

        WebElement yDD = driver.findElement(By.className("ui-datepicker-year"));
        Select yearDD = new Select(yDD);
        yearDD.selectByVisibleText("2021");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement fromDate : fromDates) {
            if(fromDate.getText().equals("4")) {
                fromDate.click();
                break;
            }
        }
    }

}
