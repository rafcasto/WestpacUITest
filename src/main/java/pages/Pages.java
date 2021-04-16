package pages;

import io.cucumber.java8.En;

public class Pages implements En
{
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public NavigationComponent navigationComponent;
    public Pages(
            LoginPage loginPage,
            RegistrationPage registrationPage,
            NavigationComponent navigationComponent
    )
    {
        this.loginPage = loginPage;
        this.registrationPage = registrationPage;
        this.navigationComponent = navigationComponent;
    }
}
