package test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.BillingCreditCard;
import pages.Dashboard;
import pages.SignUp;
import pages.login;

import java.io.FileInputStream;
import java.io.IOException;

public class testBillingCreditCard {

    WebDriver driver;

    @BeforeClass
    public void loginTest() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ocushare-dev-portal.azurewebsites.net/");


        login lgn = new login(driver);
        lgn.enterUsername("jaypatel");
        lgn.enterPassword("Michi@786");
        lgn.clkLgnbtn();
        Thread.sleep(3000);
        Dashboard dp=new Dashboard(driver);
        dp.clkProfilePicture2();
    }

    @Test (dataProvider = "getData")
    public void addCreditCard(String name,String cardnumber,String expirymonth,String expiryyear,String cvv) throws InterruptedException, IOException {

        driver.get("https://ocushare-dev-portal.azurewebsites.net/dashboard/account");

        Thread.sleep(1000);
        BillingCreditCard page = new BillingCreditCard(driver);
        page.clickBilling();
        page.clickAddNewCard();
        Thread.sleep(1000);
        page.enterCardName(name);
        page.enterCardNumber(cardnumber);
        page.selectExpiryDate(expirymonth,expiryyear);
        page.enterCvv(cvv);
        page.clickSave();

        Thread.sleep(2000);
        login lgn=new login(driver);
        lgn.screenshot();

        // Add assertions or verification steps as needed
    }

    @DataProvider
    Object[][] getData() throws IOException {

        // 1 . read the file
        FileInputStream fis = new FileInputStream("Data/CreditCard.xls");

        // 2. convert this file object into workbook object
        HSSFWorkbook workbook = new HSSFWorkbook(fis);


        // 3. select the sheet
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0; i<rowCount-1 ; i++)
        {
            HSSFRow row = sheet.getRow(i+1);

            for(int j=0 ;j<colCount ; j++)
            {

                HSSFCell cell = row.getCell(j);
             /*   if (cell==null)
                    data[i][j] ="";
                else {
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString().trim();
                   }
              */
                if (cell==null)
                    data[i][j] ="";
                else{
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString();
                }


            }

        }

        return data;
    }


}
