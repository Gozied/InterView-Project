package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SelectItemPage {
    public WebDriver driver;
   //WebElements
    By Women = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    By SummerDresses = By.xpath("//*[@id=\'block_top_menu\']/ul/li[1]/ul/li[2]/ul/li[3]/a");
    By SlideBar = By.xpath("//*[@id=\'layered_price_slider\']/a[2]");
    By priceRange= By.id("layered_price_range");

    public SelectItemPage(WebDriver driver){
        this.driver=driver;
    }

    public void HoverWomen(){
      WebElement elem=driver.findElement(Women);
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).build().perform();
    }
    public void ClickSummerDresses(){
       WebElement element= driver.findElement(SummerDresses);
        ((JavascriptExecutor) this.driver)
                .executeScript("return arguments[0].click();", element);
    }

    public void ValidateSearchResult(){
        String pageTitle= "Summer Dresses - My Store";
        Assert.assertTrue(driver.getTitle().contains(pageTitle));
        System.out.println(pageTitle);
    }

    public void MoveSlider()  {
        WebElement slider = driver.findElement(SlideBar);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,-182,0).build().perform();
    }

    public void ConfirmPriceRange(){
        String text=  driver.findElement(priceRange).getText();
        System.out.println(text);
    }

}
