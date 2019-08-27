package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage
{
    public WebDriver driver;
   //WebElement
    By SingInLink = By.cssSelector("a.login");
    By EmailCreate=By.id("email_create");
    By SubmitEmail=By.id("SubmitCreate");
    By Title=By.id("id_gender1");
    By FirstName=By.id("customer_firstname");
    By LastName=By.id("customer_lastname");
    By Password=By.id("passwd");
    By Birthday=By.id("days");
    By BirthMonth=By.id("months");
    By BirthYear=By.id("years");
    By Address=By.id("address1");
    By City=By.id("city");
    By State=By.id("id_state");
    By PostalCode=By.id("postcode");
    By RegisterButton=By.id("submitAccount");
    By MobilePhone=By.id("phone_mobile");
    By AccountName=By.cssSelector("a.account");

//Constructor
   public  CreateAccountPage(WebDriver driver)
   {
    this.driver=driver;
   }
//Actions
   public void ClickSignInLink(){
        driver.findElement(SingInLink).click();
   }

   public void EnterEmail( ){
       int random;
       random = 100 + (int)(Math.random()*((1000-1) +1));
       driver.findElement(EmailCreate).sendKeys("William" + random + "@gmail.com");
       System.out.println("William" + random + "@gmail.com");
   }

    public void SubmitEmailToRegister(){
        driver.findElement(SubmitEmail).click();
    }
   public void TickTitle(){
        driver.findElement(Title).click();
   }

    public void EnterFirstName(){
        driver.findElement(FirstName).sendKeys("William");
    }

    public void EnterLastName(){
        driver.findElement(LastName).sendKeys("Clark");
    }

    public void EnterPassword(){
        driver.findElement(Password).sendKeys("Test1234!");
    }

    public void EnterBirthDay(){
        Select sl = new Select(driver.findElement(Birthday));
        sl.selectByValue("25");
    }

    public void EnterBirthMonth(){
        Select sl = new Select(driver.findElement(BirthMonth));
        sl.selectByValue("2");
    }

    public void EnterBirthYear(){
        Select sl = new Select(driver.findElement(BirthYear));
        sl.selectByValue("1988");
    }

    public void EnterAddress(){
        driver.findElement(Address).sendKeys("30, Briggate");
   }

    public void EnterDateOfBirth(){
       EnterBirthDay();
       EnterBirthMonth();
       EnterBirthYear();
    }

    public void EnterCity(){
       driver.findElement(City).sendKeys("New York");

    }

    public void EnterState(){
        Select sl = new Select(driver.findElement(State));
        sl.selectByIndex(3);
    }

    public void EnterMobilePhone(){
        driver.findElement(MobilePhone).sendKeys("+17220678867");
   }

    public void EnterPostCode(){
        driver.findElement(PostalCode).sendKeys("10005");
    }

    public void EnterContactDetails(){
       EnterState();
       EnterMobilePhone();
       EnterCity();
       EnterPostCode();
   }

    public void SubmitRegistration(){
       driver.findElement(RegisterButton).click();
    }
    public void ConfirmAccountName(){
       String Expected = "William Clark";
      String Actual = driver.findElement(AccountName).getText();
        Assert.assertEquals(Expected,Actual);
        System.out.print(Actual);
    }
}

