package com.mavenit.selenium;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.jvm.hotspot.debugger.linux.sparc.LinuxSPARCThreadContext;
import sun.jvm.hotspot.opto.Node_Array;

import java.util.List;
import java.util.Random;

public class JunitDemo {
    public static WebDriver driver;

    @Before
    public void openBrowser() {
        System.getProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
    }
    @After
    public void closedBrowser(){
        driver.quit();
    }

    @Test
    public void searchTest() {
        WebElement searchTextBox = driver.findElement(By.id("searchTerm"));
        searchTextBox.sendKeys("Nike");
        //searchTextBox.sendKeys(Keys.ENTER);
        WebElement searchBtn = driver.findElement(By.className("_1gqeQ"));
        searchBtn.click();
        //Assert


    }
    @Test
    public  void basketTest() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.id("searchTerm"));
        searchTextBox.sendKeys("Nike");
        searchTextBox.sendKeys(Keys.ENTER);
        sleep(2000);
       // WebElement searchBtn = driver.findElement(By.className("_1gqeQ"));
        // searchBtn.click();
        List<WebElement> products=driver.findElements(By.cssSelector(".ProductCardstyles__ImageWrapper-l8f8q8-3"));
        int indexNumber=randomNumber(products.size());
        WebElement selectElement=products.get(indexNumber);
        String excepted=selectElement.getText();
        selectElement.click();
        sleep(2000);
        driver.findElement(By.cssSelector(".add-to-trolley-main")).click();
        sleep(1000);
        driver.findElement(By.linkText("Go to Trolley")).click();
        sleep(1000);
        List<WebElement> productInTrolley=driver.findElements(By.cssSelector("a[data-e2e='product-name']"));
        //Assert


        //driver.findElement(By.cssSelector("")).click();
        //Assert

    }
    public int randomNumber(int size){
        Random random=new Random();
        return random.nextInt(size -1);
    }

    public void sleep(int ms) throws InterruptedException {
       try{ Thread.sleep(2000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }

}

