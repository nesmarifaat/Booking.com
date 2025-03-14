package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_Reservation {
    //TODO: Define Webdriver
    WebDriver driver;

    //TODO: Define Constractor

    public P04_Reservation(WebDriver driver) {
        this.driver = driver;
    }

    private final By ReservedHotelName = By.xpath("//h1[text()='Tolip Hotel Alexandria']");

    //To assert that the reservation Page contains the correct Hotel Name
    public Boolean comparehotelname() {

        return driver.findElement(this.ReservedHotelName).getText().equals("Tolip Hotel Alexandria");
    }
}
