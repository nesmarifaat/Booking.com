package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static pages.PageBase.*;

public class P02_SearchResult {
    WebDriver driver;

    //TODO: Define Constractor

    public P02_SearchResult(WebDriver driver) {

        this.driver = driver;
    }

//TODO: Define Locators

    private final By tragetHotelName = By.xpath("//div[text()='Tolip Hotel Alexandria']");
    private final By loadMoreButton = By.xpath("//span[text()='Load more results']");


    // Scroll until the desired hotel is found or max scrolls reached

    public P02_SearchResult scroll() {
        // Scroll until the desired hotel is found or max scrolls reached
        int maxScrolls = 20; // Maximum number of scrolls to attempt
        boolean isHotelFound = false;
        for (int i = 0; i < maxScrolls; i++) {
            try {
                // Check if the hotel element is present
                WebElement hotelElement = new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.presenceOfElementLocated(tragetHotelName));
                isHotelFound = true;
                System.out.println("Desired hotel found!");
                hotelElement.click();
                switchToSecondTab(driver, 1);
                break;
            } catch (Exception e) {
                // If the hotel is not found, scroll down
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);"); // Scroll down by 1000 pixels
                System.out.println("Scrolling down... Attempt: " + (i + 1));
            }
        }
        if (!isHotelFound) {
            driver.findElement(this.loadMoreButton).click();
            scroll();

        }
        return this;
    }


}



