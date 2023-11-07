package test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login;

import java.io.FileInputStream;
import java.io.IOException;

public class testLoginUsingExcel {

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
    Object[][] getData() throws IOException {

        // 1 . read the file
        FileInputStream fis = new FileInputStream("Data/myData1.xls");

        // 2. convert this file object into workbook object
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        // 3. select the sheet
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for (int i=0; i<rowCount ; i++)
        {
            //HSSFRow row = sheet.getRow(i);

            data[i][0] = sheet.getRow(i).getCell(0).toString().trim();
            data[i][1] = sheet.getRow(i).getCell(1).toString().trim();

        }

        return data;
    }

}
