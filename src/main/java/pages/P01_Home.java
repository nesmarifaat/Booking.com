package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.*;

public class P01_Home {

    //TODO: Define Webdriver
    WebDriver driver;

    //TODO: Define Constractor

    public P01_Home(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Enter The Location


    private final By location = By.xpath("//input[@name=\"ss\"]");
    private final By alxOption = By.xpath("(//div/ul/li/div/div/div/div[text()='Alexandria Governorate, Egypt'])[1]");
    //TODO: Choose Check-in and Check-out Dates
    private final By checkInDay = By.xpath("(//td[@role=\"gridcell\"])[1]");
    private final By checkoutDay = By.xpath("(//tbody/tr[3]/td[2])[1]");
    private final By nextMonth = By.xpath("(//div/div/div/button[@aria-label=\"Next month\"])[1]");
    private final By targetmonth = By.xpath("(//h3)[1]");
    private final By popup_exit = By.xpath("//button[text()='Decline']");


    //TODO: define action methods
    public P01_Home enterLocation(String location) {
        // call wait
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.location));
        driver.findElement(this.location).sendKeys(location);
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(alxOption));
        driver.findElement(this.alxOption).click();
        return this;
    }


    public P01_Home moveToCheckoutMonth() {
        String targetMonthName = "October 2025";

        for (int i = 0; i < 7; i++) {
            WebElement monthElement = driver.findElement(this.targetmonth);
            String currentMonthName = monthElement.getText();

            if (currentMonthName.equalsIgnoreCase(targetMonthName)) {
                break;
            }
            driver.findElement(this.nextMonth).click();
        }
        return this;
    }


    //TODO: Select Check in Date
    public P01_Home selectCheckInDate() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.checkInDay));
        driver.findElement(this.checkInDay).click();
        return this;
    }

    //TODO: Select Check out Date
    public P01_Home selectCheckOutDate() {
        // move to checkout date
        moveToCheckoutMonth();
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.checkoutDay));
        driver.findElement(this.checkoutDay).click();
        return this;
    }

    //TODO: Click Search Button
    private final By searchButton = By.xpath("//span[text()='Search']");

    public P01_Home clickSearchButton() throws InterruptedException {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.searchButton));
        driver.findElement(this.searchButton).click();

        return this;
    }

    public P01_Home closePopup() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.popup_exit));
        driver.findElement(this.popup_exit).click();
        return this;
    }

    public Boolean checkindatehomepage() {

        return driver.findElement(this.checkInDay).isDisplayed();
    }


}

