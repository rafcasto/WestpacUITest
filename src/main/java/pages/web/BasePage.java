package pages.web;


import controllers.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    BasePage(WebDriverController driver)
    {
        this.driver = driver.getDriver();
    }

    public WebElement FindElement(By locator)
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
