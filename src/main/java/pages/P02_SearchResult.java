package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


import static pages.PageBase.*;

public class P02_SearchResult  {
    WebDriver driver;

    //TODO: Define Constractor

    public P02_SearchResult(WebDriver driver) {

        this.driver = driver;
    }
    private final By tragetHotelName= By.xpath("//div[text()='Tolip Hotel Alexandria']");

//    private final By seeAvalibality=By.xpath("");

    public P02_SearchResult scrolltoTolipHotel(){
        scrollToViewElement(driver,driver.findElement(tragetHotelName));
        return this;
    }


}
