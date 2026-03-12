package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseUI {
    public static void waitAndClick(WebElement element){
        waitUntilClickable(20, element);
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String keys){
        waitUntilVisible(20, element);
        element.sendKeys(keys);
    }

    public void jsClick(WebElement element){
        waitUntilClickable(20, element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void jsSendKeys(WebElement element, String value){
        waitUntilVisible(20, element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", element);
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public static WebDriverWait explicitWait(int seconds){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public static void waitUntilClickable(int seconds, WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(int seconds, WebElement element){
        new  WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }



}


