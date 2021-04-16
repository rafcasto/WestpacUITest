package pages.web;

import controllers.WebDriverController;
import pages.LoginPage;
import org.openqa.selenium.By;

public class WebLoginPage extends BasePage implements LoginPage {

    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By error = By.xpath("//h3[@data-test='error']");

    public WebLoginPage(WebDriverController driver) {
        super(driver);
    }

    @Override
    public void Login(String user, String password) {
        FindElement(this.userName).sendKeys(user);
        FindElement(this.password).sendKeys(password);
        FindElement(this.loginButton).click();
    }

    @Override
    public String ReadError() {
        return driver.findElement(error).getText();
    }
}
