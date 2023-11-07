package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login;

public class testLoginUsingDataProvider {

    public WebDriver driver;


    @Test (dataProvider = "getData")
    public void myTest1(String username,String password)  {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ocushare-dev-portal.azurewebsites.net/");
        login lgn = new login(driver);
        lgn.enterUsername(username);
        lgn.enterPassword(password);
        lgn.clkLgnbtn();
        lgn.print();

    }
    @DataProvider
    Object[][] getData()
    {
        Object[][] data = new Object[5][2];

        data[0][0] = "jaypatel";
        data[0][1] = "Michi@786";

        data[1][0] = "invalid-2";
        data[1][1] = " ";

        data[2][0] = " ";
        data[2][1] = " ";

        data[3][0] = "invalid-3";
        data[3][1] = "invalid-3";

        data[4][0] = "";
        data[4][1] = "";

        return data;
    }

}
