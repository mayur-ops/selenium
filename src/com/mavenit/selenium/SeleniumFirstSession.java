package com.mavenit.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirstSession {
    public static void main(String[] args) {
        //search Test
        //open Browser
        // Navigate out
        //search
        //assert
    System.getProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        WebElement searchTextBox = driver.findElement(By.id("searchTerm"));
        searchTextBox.sendKeys("Nike");
        //searchTextBox.sendKeys(Keys.ENTER);
        WebElement searchBtn = driver.findElement(By.className("_1gqeQ"));
        searchBtn.click();


       // driver.findElement(By.xpath("//button[@class='Buttonstyles__Button-q93iwm-2 NkbPS btn-cta']")).click();
        //driver.findElement(By.xpath("//a[@class='Buttonstyles__Button-q93iwm-2 dUQXJf']")).click();

        driver.quit();



    }
}
