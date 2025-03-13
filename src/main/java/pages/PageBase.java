package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class PageBase {



    // long explicit wait
    public static WebDriverWait longWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // short explicit wait
    public static WebDriverWait shortWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public static void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                //System.out.println("Ready State: " + readyState);
                return (Boolean) readyState.equals("complete");
            }
        });
    }

    public static WebElement scrollToElement(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long startTime = System.currentTimeMillis();
        long timeoutMillis = timeoutSeconds * 1000L;

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (element.isDisplayed()) {
                    return element;
                }
            } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // Element not found or not visible yet
            }

            js.executeScript("window.scrollBy(0, 250);"); // Scroll down
            try {
                Thread.sleep(250); // Small delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted during scroll delay.", e);
            }
        }

        throw new org.openqa.selenium.TimeoutException("Element with locator " + locator + " not found or visible within " + timeoutSeconds + " seconds");
    }

    // TODO: Scroll to view Element
    public static void scrollToViewElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }



}
