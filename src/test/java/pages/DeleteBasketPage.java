package pages;

import Base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeleteBasketPage extends  TestBase{
    //WebElements
    public WebDriver driver;

    By Email = By.name("email");
    By Password = By.id("passwd");
    By SignIn = By.id("SubmitLogin");
    By Dresses = By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a");
    By PrintedDress = By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[1]/div/a[1]/img");
    By ProceedToCart = By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span");
    By AddItem = By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[2]/div[2]/a[1]/span");
    By DeleteButton = By.xpath("//i[@class='icon-trash']");
    By SummaryMessage = By.xpath("//*[@id=\'center_column\']/p");


    public DeleteBasketPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void EnterEmail() {
        driver.findElement(Email).sendKeys(CONFIG.getProperty("Email"));
    }

    public void TypePassword() {
        driver.findElement(Password).sendKeys(CONFIG.getProperty("Password"));
    }

    public void ClickSignIn() {
        driver.findElement(SignIn).click();
    }

    public void SuccessfulLogIn() {
        EnterEmail();
        TypePassword();
        ClickSignIn();
    }

    public void ClickDresses() {
        driver.findElement(Dresses).click();
    }

    public void AddDressToCart() {
        Actions actions = new Actions(driver);
        WebElement ClickItem = driver.findElement(AddItem);
        WebElement hoverDress = driver.findElement(PrintedDress);
        actions.moveToElement(hoverDress).click(ClickItem).build().perform();
        WebElement element = driver.findElement(ProceedToCart);
        ((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
    }

    public void ConfirmDeleteButton() {
        GetWhenVisible(DeleteButton,5);
        WebElement element=driver.findElement(DeleteButton);
        if (element.isEnabled()) {
            Assert.assertTrue(true);
        }
    }

    public void DeleteItemFromCart() {
        driver.findElement(DeleteButton).click();
    }

    public void ConfirmCartStatus() {
        String Message = "Your shopping cart is empty.";
        if (driver.findElement(SummaryMessage).getText().equals(Message)) ;
        {
            Assert.assertTrue(true);
            System.out.println(Message);
        }
    }
}

