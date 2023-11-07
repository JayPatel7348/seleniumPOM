package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUp;

public class testSignUp {
    public WebDriver driver;


    @BeforeTest
    public void setUp() {
        // Set up the WebDriver and open the web page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ocushare-dev-portal.azurewebsites.net/register");

        // Initialize the Page Object

    }

    @Test
    public void fillFormAndSubmit() {

        SignUp page = new SignUp(driver);
        // Perform actions using Page Object methods
        page.enterTextInTextBox1("Jay");
        page.enterTextInTextBox2(" ");
        page.enterTextInTextBox3("Patel");
        page.enterTextInTextBox4("jeveyac175@qianhost.com");
        page.enterTextInTextBox5("Admin@123");
        page.enterTextInTextBox6("Admin@123");
        page.clickPolicyCheckbox();
        page.clickSubmitButton();

        // Add assertions or verification steps as needed
    }

    @AfterTest
    public void cleanUp() {
      //driver.quit();

    }

    // Clean up resources in the @AfterTest method
}

