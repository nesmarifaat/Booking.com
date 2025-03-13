package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_BookingDetails {

    //TODO: Define Webdriver
    WebDriver driver;

    //TODO: Define Constractor

    public P03_BookingDetails(WebDriver driver) {
        this.driver = driver;
    }

    private final By ChosenCheckinDate = By.xpath("//span[text()=\"Wed, Oct 1\"]");
    private final By ChosenCheckoutDate = By.xpath("//span[text()=\"Tue, Oct 14\"]");
    private final By BedSelection = By.xpath("(//ul[@class=\"rt-bed-types\"])[3]");
    private final By Amount = By.xpath("(//select)[1]");
    private final By ReserveButton = By.xpath("(//button[@type=\"submit\"])[3]");



    public Boolean checkindatedetailspage(){

        return driver.findElement(this.ChosenCheckinDate).isDisplayed();
    }


    public Boolean checkoutdatedetailspage(){

        return driver.findElement(this.ChosenCheckoutDate).isDisplayed();
    }


}
