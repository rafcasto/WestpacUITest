package pages.web;

import controllers.WebDriverController;
import org.openqa.selenium.By;
import pages.NavigationComponent;

public class WebNavigationComponent extends BasePage implements NavigationComponent
{
    private By registerBtn = By.xpath("//a[contains(text(),'Register')]");

   public WebNavigationComponent(WebDriverController driver) {
        super(driver);
    }

    @Override
    public void navigateToProfile()
    {
        FindElement(registerBtn).click();
    }
}
