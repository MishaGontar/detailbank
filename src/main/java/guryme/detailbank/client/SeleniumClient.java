package guryme.detailbank.client;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

@Getter
@Log4j2
public class SeleniumClient {
    WebDriver driver;
    WebDriverWait wait;

    public SeleniumClient() {
        log.info("Start constructor: SeleniumClient");
        setupDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("End constructor: SeleniumClient");
    }

    @SneakyThrows
    private void setupDriver() {
        log.info("Start: setupDriver()");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        try {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
            log.info("driver setup by default");
        } catch (Exception e) {
            log.warn("Can't start firefox driver , try with remote driver . ", e);
            driver = new RemoteWebDriver(new URL("http://firefox:4444/wd/hub/"), firefoxOptions);
        }
        log.info("End: setupDriver()");
    }
}
