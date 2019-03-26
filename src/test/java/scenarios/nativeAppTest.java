package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.APP_PATH;
import static setup.DriverSetup.driver;

public class nativeAppTest {

    @Test(groups = "native")
    public void nativeAppTest() throws MalformedURLException {

        //1. Click on the button Add contact
        WebElement abbButton = driver().findElement(By.id(APP_PATH + ":id/addContactButton"));
        abbButton.click();

        //2. Check that page with Target Account opens
        WebElement targetAccount = driver().findElement(By.id(APP_PATH + ":id/accountSpinner"));
        assertTrue(targetAccount.isDisplayed());

        //3. Check that keyboard exists
        assertNotNull(driver().getKeyboard());

       /* System.out.println("Native test complete");
        String appPackageName = "com.example.android.contactmanager:id/";
        By addBtn = By.id(appPackageName + "addContactButton");
        driver.findElement(addBtn).click();
        System.out.println("Simplest Appium test done");*/
    }

}



























