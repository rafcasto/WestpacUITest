package pages.web;

import controllers.WebDriverController;
import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;

import java.util.List;
import java.util.stream.Collectors;

public class WebRegistrationPage extends BasePage implements RegistrationPage {
    private By userName = By.id("username");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By registerBtn = By.xpath("//button[contains(text(),'Register')]");
    private By message = By.xpath("//div[contains(@class,'alert')]");

    public WebRegistrationPage(WebDriverController driver) {
        super(driver);
    }

    @Override
    public void registration(User user)
    {
        if (user == null) {
            throw new RuntimeException("Please provide user details ");
        }

        FindElement(userName).sendKeys(user.getUsername());
        FindElement(firstName).sendKeys(user.getFirstName());
        FindElement(lastName).sendKeys(user.getLastName());
        FindElement(password).sendKeys(user.getPassword());
        FindElement(confirmPassword).sendKeys(user.getConfirmPassword());
    }

    @Override
    public void submitForm()
    {
        FindElement(registerBtn).click();
    }

    @Override
    public String readMessage()
    {


        return getAlertMessage();
    }

    private String getAlertMessage()
    {

        int attempts = 0;
        boolean alertIsPresent = false;
        String alertMessage = null;
        while (!alertIsPresent && attempts <=3)
        {
            waitForSeconds();

            List<WebElement> alerts = driver.findElements(message).
                    stream().filter(x-> !x.getText().isEmpty()).
                    collect(Collectors.toList());

            alertIsPresent = !alerts.isEmpty();
            if(alertIsPresent)
            {
                WebElement alert = alerts.stream().findFirst().orElse(null);
                alertMessage = alert.getText();
            }
            attempts++;
        }
        return  alertMessage;
    }

    private void waitForSeconds()
    {
        try
        {
            Thread.sleep(1000);
        }catch (Exception ex){}

    }

}
