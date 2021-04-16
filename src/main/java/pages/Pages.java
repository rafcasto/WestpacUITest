package pages;

import dto.User;
import io.cucumber.java8.En;

public class Pages implements En
{
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public NavigationComponent navigationComponent;
    public User userDetails;
    public Pages(
            LoginPage loginPage,
            RegistrationPage registrationPage,
            NavigationComponent navigationComponent,
            User userDetails
    )
    {
        this.loginPage = loginPage;
        this.registrationPage = registrationPage;
        this.navigationComponent = navigationComponent;
        this.userDetails = userDetails;
    }
}
