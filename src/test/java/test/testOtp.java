package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Otp;

public class testOtp {
    WebDriver driver;


    @BeforeTest
    public void setUp() {
        // Set up the WebDriver and open the web page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ocushare-dev-portal.azurewebsites.net/auth/verify");

        // Initialize the Page Object

    }

    @Test
    public void fillOtpAndVerify() {

        Otp page = new Otp(driver);
        // Perform actions using Page Object methods
        page.enterTextInTextBox1("1");
        page.enterTextInTextBox2("1");
        page.enterTextInTextBox3("1");
        page.enterTextInTextBox4("1");
        page.enterTextInTextBox5("1");
        page.enterTextInTextBox6("1");
        page.clickVerifyButton();

        // Add assertions or verification steps as needed
    }

    // Clean up resources in the @AfterTest method
}

