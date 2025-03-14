package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Home;
import pages.P02_SearchResult;
import pages.P03_BookingDetails;
import pages.P04_Reservation;
import retrytest.Retry;

import java.io.IOException;


import static utilities.Utility.*;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC01_LocationSearch extends TestBase {


    String location = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//SearchData.json", "location");


    public TC01_LocationSearch() throws IOException, ParseException {
    }

    @Description("Check Search Functionality With Valid Location")
    @Severity(SeverityLevel.CRITICAL)

    @Test(priority = 1, description = "Search With Valid Location", retryAnalyzer = Retry.class)
    public void searchwithvaliddata_P() throws InterruptedException {

//
        new P01_Home(driver).enterLocation(location).moveToCheckoutMonth().selectCheckInDate().selectCheckOutDate().closePopup().clickSearchButton();


        //new P02_SearchResult(driver).closePopup2();
       driver.navigate().refresh();

        new P02_SearchResult(driver).scroll();
        Thread.sleep(10000);
        Assert.assertTrue(new P03_BookingDetails(driver).checkindatedetailspage());
        new P03_BookingDetails(driver).selectamout().clickContinueToBookButton();
        Thread.sleep(1000);
        Assert.assertTrue(new P04_Reservation(driver).comparehotelname());

        captureScreenshot(driver, "P_Search");

    }


}

