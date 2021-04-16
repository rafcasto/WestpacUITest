package pages.web;

import controllers.WebDriverController;
import org.openqa.selenium.By;
import pages.NavigationComponent;

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
        FindElement(navBarItems);
        return driver.findElements(navBarItems).get(PROFILE_NAME).getText();
    }
}
