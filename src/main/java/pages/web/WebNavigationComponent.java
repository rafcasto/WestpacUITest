package pages.web;

import controllers.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.NavigationComponent;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebNavigationComponent extends BasePage implements NavigationComponent
{
    private By registerBtn = By.xpath("//a[contains(text(),'Register')]");
    private By navBarItems = By.className("nav-item");
    private int PROFILE_NAME = 0;
    private int PROFILE = 1;
    private int PROFILE_LOGOUT = 2;

   public WebNavigationComponent(WebDriverController driver) {
        super(driver);
    }

    @Override
    public void navigateToProfile()
    {
        FindElement(registerBtn).click();
    }

    @Override
    public String readProfileName()
    {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);


        List<WebElement> navBarOptions = (List<WebElement>) wait.until(new Function<WebDriver, List<WebElement>>(){

            public List<WebElement> apply(WebDriver driver ) {
                return driver.findElements(navBarItems);
            }
        });
        return navBarOptions.get(PROFILE_NAME).getText();
    }
}
