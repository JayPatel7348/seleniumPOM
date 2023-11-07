package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Otp {
    WebDriver driver;

    // Constructor to initialize the driver and Page Factory
    public Otp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Define WebElement locators using @FindBy annotation
    @FindBy(xpath = "(//input[@id='field-code'])[1]")
    private WebElement textBox1;

    @FindBy(xpath = "(//input[@id='field-code'])[2]")
    private WebElement textBox2;

    @FindBy(xpath = "(//input[@id='field-code'])[3]")
    private WebElement textBox3;

    @FindBy(xpath = "(//input[@id='field-code'])[4]")
    private WebElement textBox4;

    @FindBy(xpath = "(//input[@id='field-code'])[5]")
    private WebElement textBox5;

    @FindBy(xpath = "(//input[@id='field-code'])[6]")
    private WebElement textBox6;

    @FindBy(xpath = "//button[normalize-space()='Verify']")
    private WebElement clkverifyButton;

    // Methods to interact with the elements
    public void enterTextInTextBox1(String text) {
        textBox1.sendKeys(text);
    }

    public void enterTextInTextBox2(String text) {
        textBox2.sendKeys(text);
    }

    public void enterTextInTextBox3(String text) {
        textBox3.sendKeys(text);
    }

    public void enterTextInTextBox4(String text) {
        textBox4.sendKeys(text);
    }

    public void enterTextInTextBox5(String text) {
        textBox5.sendKeys(text);
    }

    public void enterTextInTextBox6(String text) {
        textBox6.sendKeys(text);
    }

    public void clickVerifyButton() {
        clkverifyButton.click();
    }
}

