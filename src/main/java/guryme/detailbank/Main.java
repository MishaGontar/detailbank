package guryme.detailbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setBrowserName("firefox");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub/"), dc);

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        System.out.println(driver.getTitle());

        driver.quit();
        System.out.println("start");
    }
}
