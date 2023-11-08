package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingCreditCard {

    WebDriver driver;

    public BillingCreditCard(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath="//button[normalize-space()='Billing']")
    WebElement clickbilling;
    @FindBy(xpath="//button[normalize-space()='Add new card']")
    WebElement addnewcard;
    @FindBy(xpath="/html/body/div/div/div[2]/main/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div/input")
    WebElement inputcardname;

    @FindBy(xpath="/html/body/div/div/div[2]/main/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div/input")
    WebElement inputcardnumber;

    @FindBy(xpath="/html/body/div/div/div[2]/main/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[3]/div[1]/div/input")
    WebElement inputexpiry;

    @FindBy(xpath="/html/body/div/div/div[2]/main/div/div/div[4]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[3]/div[2]/div/input")
    WebElement inputcvv;

    @FindBy(xpath="(//button[normalize-space()='Save Changes'])[1]")
    WebElement clicksave;

    public void clickBilling()
    {clickbilling.click();}
    public void clickAddNewCard()
    {addnewcard.click();}
    public void enterCardName(String name)
    {inputcardname.sendKeys(name);}
    public void enterCardNumber(String cardnumber)
    {inputcardnumber.sendKeys(cardnumber);}

    public void selectExpiryDate(String expirymonth,String expiryyear)
    {
        inputexpiry.sendKeys(expirymonth);
        inputexpiry.sendKeys(Keys.TAB);
        inputexpiry.sendKeys(expiryyear);
    }

    public void enterCvv(String cvv)
    {inputcvv.sendKeys(cvv);}

    public void clickSave()
    {clicksave.click();}


}
