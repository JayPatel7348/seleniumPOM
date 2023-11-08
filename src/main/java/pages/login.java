package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class login {

    public WebDriver driver;

    @FindBy(xpath = "//input[@name='email']")
    WebElement usernameipt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordipt;

    @FindBy(xpath = "//button[normalize-space()='Log In']")
    WebElement lgnbtn;

    public login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearUsername()
    {
        usernameipt.clear();
    }
    public void enterUsername(String username)
    {
        usernameipt.sendKeys(username);
    }

    public void clearPasword()
    {
        passwordipt.clear();
    }
    public void enterPassword(String password)
    {
        passwordipt.sendKeys(password);
    }


    public void clkLgnbtn()
    {
        lgnbtn.click();
    }

    public void print()
    {
        System.out.println("Done");
    }


    public void screenshot() throws IOException {
        // 1. create the object reference of TakesScreenshot
        // assign the current driver to it typecast it to
        // TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. call the method getScreenshotAs() using the
        // ts (object reference of TakesScreenshot)
        // store the value in file object
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. copy this file object into a real image file
        FileUtils.copyFile(scrFile,new File("SS/"+fileName));


    }
}
