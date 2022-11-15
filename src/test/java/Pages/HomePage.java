package Pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage {

    Methods methods;
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage() {
        methods = new Methods();
    }

    By btnallow = By.id("com.m.qr:id/push_consent_allow");
    By barHomeTool = By.id("com.m.qr:id/rvmp_home_tool_bar_menu_icon");
    By btnBook = By.xpath("//*[@text='Book']");

    By btnSkipLocation = By.id("com.m.qr:id/skip_button");
    By btnSkip = By.id("com.m.qr:id/onboarding_skip_button");
    By btnPopupClose = By.id("com.m.qr:id/secondary_button");

    @Step("Accept notifications and check homepage has arrived")
    public void click() {
        methods.click(btnSkipLocation);
        methods.click(btnSkip);
        methods.click(btnallow);
        methods.click(btnPopupClose);
        methods.findElement(barHomeTool);
        logger.info("Home Page Loaded");
    }
    @Step("Switch to book page")
    public void clickBook() {

        methods.click(btnBook);
        logger.info("Book button clicked");
    }
}

