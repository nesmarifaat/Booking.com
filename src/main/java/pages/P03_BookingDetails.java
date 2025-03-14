package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.PageBase.longWait;
import static pages.PageBase.switchToSecondTab;

public class P03_BookingDetails {

    //TODO: Define Webdriver
    WebDriver driver;

    //TODO: Define Constractor

    public P03_BookingDetails(WebDriver driver) {
        this.driver = driver;
    }


    private final By BedSelection = By.xpath("(//ul[@class=\"rt-bed-types\"])[3]");
    private final By Amount = By.xpath("(//select)[1]");
    private final By ReserveButton = By.xpath("(//button[@type=\"submit\"])[3]");

    private final By SpecialOffer = By.xpath("//span[contains(@class,'hprt-roomtype-icon-link')][normalize-space()='Special Offer - Deluxe Room with City View - Egyptians and Residents Only']");


    public P03_BookingDetails selectbed() {
        driver.findElement(this.BedSelection).click();
        return this;

    }

    public P03_BookingDetails selectamout() {
        // Scroll until the desired hotel is found or max scrolls reached
        int maxScrolls = 20; // Maximum number of scrolls to attempt
        boolean isHotelFound = false;
        for (int i = 0; i < maxScrolls; i++) {
            try {
                // Check if the hotel element is present
                WebElement hotelElement = new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.presenceOfElementLocated(SpecialOffer));
                isHotelFound = true;
                System.out.println("Desired hotel found!");
                Select ChooseAmount = new Select(driver.findElement(this.Amount));
                ChooseAmount.selectByIndex(2);
                break;
            } catch (Exception e) {
                // If the hotel is not found, scroll down
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);"); // Scroll down by 1000 pixels
                System.out.println("Scrolling down... Attempt: " + (i + 1));
            }
        }

        return this;
    }


    public P03_BookingDetails clickContinueToBookButton() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.ReserveButton));
        driver.findElement(this.ReserveButton).click();

        return this;
    }

    public Boolean checkindatedetailspage() {

        return driver.getPageSource().contains("Wed, Oct 1");
    }


}
