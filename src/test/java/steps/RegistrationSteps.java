package steps;

import dto.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.NavigationComponent;
import pages.Pages;

import java.util.List;

public class RegistrationSteps implements En
{

    private Pages pages;
    private User userDetails;
    public RegistrationSteps(Pages pages,User userDetails)
    {
        this.pages = pages;
        this.userDetails = userDetails;
    }
    @Given("User sing up with details")
    public void userSingUpWithDetails(List<User> userList)
    {
        this.pages.navigationComponent.navigateToProfile();
        this.userDetails = userList.stream().findFirst().orElse(null);

    }

    @When("User submits form")
    public void userSubmitsForm()
    {
        this.pages.registrationPage.registration(this.userDetails);
        this.pages.registrationPage.submitForm();
    }

    @Then("User can read a {string} message")
    public void userCanReadAMessage(String expectedMessage)
    {
        Assert.assertEquals("message:",expectedMessage,this.pages.registrationPage.readMessage());
    }
}
