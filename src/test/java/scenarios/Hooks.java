package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import setup.TestProperties;

import java.io.IOException;
import java.net.MalformedURLException;

import static setup.DriverSetup.driver;
import static setup.DriverSetup.prepareDriver;
import static setup.DriverSetup.setProperties;

public class Hooks {

    @Parameters("property path")
    @BeforeSuite(groups = {"web", "native"})
    public void setUp(String path) throws IOException {
        setProperties(new TestProperties(path).getCurrentProps());
        prepareDriver();
        System.out.println("setUp");
    }

    @AfterSuite(groups = {"web", "native"})
    public void tearDown() throws MalformedURLException {
        driver().quit();
        System.out.println("tearDown");
    }

}
