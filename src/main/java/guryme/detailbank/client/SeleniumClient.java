package guryme.detailbank.client;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Getter
public class SeleniumClient {
    WebDriver driver;
    WebDriverWait wait;

    public SeleniumClient() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("firefox");
        try {
            driver = new RemoteWebDriver(new URL("http://firefox:4444/wd/hub/"), dc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
