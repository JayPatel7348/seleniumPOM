package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

   public  WebDriver driver;


   public Dashboard(WebDriver driver)
   {
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }
   @FindBy(xpath="(//img[@alt='Jay'])[2]")
    WebElement clickprofilepicture2;

   public void clkProfilePicture2()
   {
       clickprofilepicture2.click();
   }

}
