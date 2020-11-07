package com.company;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab5Test {
    public static void main(String[] args) {
        // set driver
        System.setProperty("webdriver.chrome.driver",
                "/Users/inabot/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // open youtube page
        driver.get("https://www.youtube.com");

        // type and search for "computer"
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("computer");
        searchBox.submit();

        // check youtube header
        boolean exists = driver.findElement( By.className("yt-simple-endpoint")).getSize() != null;
        if (exists) {
            driver.findElement( By.className("yt-simple-endpoint")).click();
        }
        else {
            System.out.println("Youtube header not found on page");
        }
        driver.close();
    }
}