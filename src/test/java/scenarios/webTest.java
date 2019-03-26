package scenarios;

import org.testng.annotations.Test;

import java.io.IOException;

import static entities.OptionsKeys.TITLE;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.*;

public class webTest {

    @Test(groups = "web")
    public void webTest() throws IOException {

        //1. Open page in browser
        driver().get(SUT);

        //2. Check that page title is rigth
        waits().until(urlMatches(SUT + "/"));
        assertEquals(driver().getTitle(), TITLE.key);
    }

   /*@Test
    public void webTest() throws InterruptedException{
        driver.get("http://iana.org");
       // wait.until(ExpectedCondition.urlToBe(SUT+"/"));
        System.out.println("Site opening done");
    }*/

}
