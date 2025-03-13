package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Home;
import pages.P02_SearchResult;
import pages.P03_BookingDetails;

import static utilities.Utility.captureScreenshot;

@Feature("Search Functionality")
@Epic("Search Epic")
public class TC02_HotelSelection extends TestBase {


    public TC02_HotelSelection()  {
    }

    @Description("Check the functionality of selecting a specific Hotel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Check Employee Search Function")
    public void checkHotelSelectionFunctionality_P() {


      //new P02_SearchResult(driver).scrolltoTolipHotel();
        //captureScreenshot(driver, "P_HotelSelection");
        Assert.assertTrue(new P01_Home(driver).checkindatehomepage().equals(new P03_BookingDetails(driver).checkindatedetailspage()));
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(new P03_AdminViewSystemUser(driver).checksearchrecord());
//        softAssert.assertAll();
    }
}
