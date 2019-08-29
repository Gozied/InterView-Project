package Steps;

import Base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SelectItemPage;

public class SelectItem  extends TestBase {

    SelectItemPage selectitem= new SelectItemPage(driver);
    @And("^i Mouse over Women Menu to reveal options$")
    public void i_Mouse_over_Women_Menu_to_reveal_options() throws Throwable {
        selectitem.HoverWomen();

    }

    @When("^i click summer dresses$")
    public void i_click_summer_dresses() throws Throwable {
      selectitem.ClickSummerDresses();
    }

    @Then("^i should only see summer dresses in catalogue$")
    public void i_should_only_see_summer_dresses_in_catalogue() throws Throwable {
     selectitem.ValidateSearchResult();
     TestCleanUp();
    }

    @And("^i drag slider to set price range to \\$(\\d+)-(\\d+)\\$$")
    public void iDragSliderToSetPriceRangeTo$$(int arg0, int arg1)  {
        selectitem.MoveSlider();
    }

    @Then("^Returned items are within the above price range$")
    public void returnedItemsAreWithinTheAbovePriceRange() {
        selectitem.ConfirmPriceRange();
        TestCleanUp();
    }
}
