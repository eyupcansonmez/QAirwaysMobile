package org.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AppiumDriver<MobileElement> driver;
    protected boolean localAndroid = true;

    @BeforeScenario
    public void setUp() throws MalformedURLException {

        if (localAndroid) {
            System.out.println("ANDROID TEST STARTS FOR QATAR AIRWAYS");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.m.qr.home.onboarding.ui.OnBoardingActivity");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.m.qr");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
            URL url = new URL("http:127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
        }
    }
    @AfterScenario
    public void tearDown() {
        driver.quit();
    }
}

