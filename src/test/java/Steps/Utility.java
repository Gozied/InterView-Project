package Steps;

import Base.TestBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;

import java.io.IOException;

import static Base.TestBase.CONFIG;

public class Utility extends TestBase {

    @Given("^i navigate to  home page$")
        public void iNavigateToHomePage () throws IOException {
            InitializeDriver();
            driver.get(CONFIG.getProperty("URL"));
            driver.manage().window().maximize();
        }

        @And("^i click sign in$")
        public void i_click_sign_in () {
            CreateAccountPage ca = new CreateAccountPage(driver);
            ca.ClickSignInLink();
        }
    }

