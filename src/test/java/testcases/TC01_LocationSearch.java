package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Home;
import pages.P03_BookingDetails;
import retrytest.Retry;

import java.io.IOException;

import static pages.PageBase.waitForPageLoad;
import static utilities.Utility.*;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC01_LocationSearch extends TestBase {


    String location = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "location");


    public TC01_LocationSearch() throws IOException, ParseException {
    }

    @Description("Check Search Functionality With Valid Location")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Search With Valid Location", retryAnalyzer = Retry.class)
    public void searchwithvaliddata_P() throws InterruptedException {
        // TODO: wait DOM page load
        waitForPageLoad(driver);
        System.out.println(location);

        new P01_Home(driver).enterLocation(location).moveToCheckoutMonth().selectCheckInDate().selectCheckOutDate().closePopup().clickSearchButton();

        captureScreenshot(driver, "P_Search");
        //Assert.assertTrue(new P02_Home(driver).checkvisabilityofdashboard());
        Assert.assertTrue(new P01_Home(driver).checkindatehomepage().equals(new P03_BookingDetails(driver).checkindatedetailspage()));


    }

//        // TODO: wait DOM page load
//        waitForPageLoad(driver);


}
