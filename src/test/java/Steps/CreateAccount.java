package Steps;

import Base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CreateAccountPage;

import java.io.IOException;

public class CreateAccount extends TestBase {
    CreateAccountPage createAccount = new CreateAccountPage(driver);

    @And("^i type email address in other to register$")
    public void iTypeEmailAddressInOtherToRegister() {
        createAccount.EnterEmail();
    }

    @And("^i click create account button$")
    public void iClickCreateAccountButton() {
        createAccount.SubmitEmailToRegister();
    }

    @And("^i Enter Personal Information$")
    public void iEnterPersonalInformation() {
        createAccount.TickTitle();
        createAccount.EnterFirstName();
        createAccount.EnterLastName();
        createAccount.EnterPassword();
        createAccount.EnterDateOfBirth();
    }

    @And("^i Enter Address and Contact details$")
    public void iEnterAddressAndContactDetails() {
        createAccount.EnterAddress();
        createAccount.EnterContactDetails();
    }

    @When("^i click register button to complete registration$")
    public void iClickRegisterButtonToCompleteRegistration() {
        createAccount.SubmitRegistration();
    }

    @Then("^i verify account name to confirm Account has been created$")
    public void iVerifyAccountNameToConfirmAccountHasBeenCreated() {
        createAccount.ConfirmAccountName();
        TestCleanUp();

    }
}
