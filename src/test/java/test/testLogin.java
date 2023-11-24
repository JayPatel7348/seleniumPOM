package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.login;

public class testLogin {

    public WebDriver driver;

    @BeforeClass
    public void open()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void openUrl()
    {
        driver.get("https://ocushare-dev-portal.azurewebsites.net/");


    }


    @Test
    public void loginTest() throws InterruptedException {
        //driver.get("https://ocushare-dev-portal.azurewebsites.net/");
        login lgn = new login(driver);
        lgn.enterUsername("jaypatel");
        lgn.enterPassword("Michi@786");
        Thread.sleep(2000);
        lgn.clkLgnbtn();
        lgn.print();
    }

    @Test
    public void InValidloginTest() throws InterruptedException {
       // driver.get("https://ocushare-dev-portal.azurewebsites.net/");
        login lgn = new login(driver);
        lgn.enterUsername("jaypatel");
        lgn.enterPassword("24353tre");
        Thread.sleep(2000);
        lgn.clkLgnbtn();
        lgn.print();
    }

    @Test
    public void blankloginTest() throws InterruptedException {
       // driver.get("https://ocushare-dev-portal.azurewebsites.net/");
        login lgn = new login(driver);
        lgn.enterUsername(" ");
        lgn.enterPassword(" ");
        Thread.sleep(2000);
        lgn.clkLgnbtn();
        lgn.print();
    }

    @AfterClass
    public void close()
    {
       driver.quit();
    }

}
