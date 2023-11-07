package test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login;

import java.io.FileInputStream;
import java.io.IOException;

public class testLoginUsingExcel2 {

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

        Object[][] data = new Object[rowCount-1][2];

        for (int i=0; i<rowCount-1 ; i++)
        {
            HSSFRow row = sheet.getRow(i+1);

            HSSFCell username = row.getCell(0);

            if (username==null)
                data[i][0] ="";
            else {
                username.setCellType(CellType.STRING);
                data[i][0] = username.toString().trim();
            }

            HSSFCell password = row.getCell(1);
            if (password==null)
                data[i][1] ="";
            else {
                password.setCellType(CellType.STRING);
                data[i][1] = password.toString().trim();
            }

        }

        return data;
    }

}
