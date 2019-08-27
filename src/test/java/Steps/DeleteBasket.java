package Steps;

import Base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;
import pages.DeleteBasketPage;

import java.io.IOException;

public class DeleteBasket extends TestBase
{
    DeleteBasketPage basket = new DeleteBasketPage(driver);




    @Given("^i login successfully$")
    public void i_login_successfully() {
        basket.SuccessfulLogIn();

    }

    @Given("^i add a dress to my Shopping Cart$")
    public void i_add_a_dress_to_my_Shopping_Cart() {
        basket.ClickDresses();
        basket.AddDressToCart();

    }

    @Given("^i confirm that Cart has a delete button$")
    public void i_confirm_that_Cart_has_a_delete_button() {
      basket.ConfirmDeleteButton();
    }

    @When("^i delete dress from Shopping cart$")
    public void i_delete_dress_from_Shopping_cart() {
     basket.DeleteItemFromCart();
    }

    @Then("^Banner should displays shopping cart is empty$")
    public void banner_should_displays_shopping_cart_is_empty() {
        basket.ConfirmCartStatus();
        TestCleanUp();
    }

}
