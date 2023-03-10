package qa.guru.demoqa.config;


import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void config() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.reportsUrl = config.videoUrl();
        if (config.isRemote()) {
            Configuration.remote = config.getSelenoidUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
