package Pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FlyingPage {

    Methods methods;
    Logger logger = LogManager.getLogger(FlyingPage.class);
    static String flightTime;
    static String landingTime;

    By selectFlight = By.id("com.m.qr:id/rvmp_item_search_result_root_view");
    By btnSelectThisFare = By.id("com.m.qr:id/rvmp_activity_flight_details_select_button");
    By textFlightTimeDetailsPage = By.id("com.m.qr:id/from_time");
    By textLandingTimeDetailsPage = By.id("com.m.qr:id/to_time");
    By textFlightTimeFlightPage = By.id("com.m.qr:id/rvmp_departure_time");
    By textLandingTimeFlightPage = By.id("com.m.qr:id/rvmp_arrival_time");
    By btnLogin = By.id("com.m.qr:id/button_continue");

    public FlyingPage() {
        methods = new Methods();
    }

    @Step("The flight is selected")
    public void selectPlane() {
        methods.findElement(selectFlight);
        flightTime = methods.getText(textFlightTimeFlightPage);
        landingTime = methods.getText(textLandingTimeFlightPage);
        methods.click(selectFlight);
        logger.info("Flight selected");
        methods.click(btnSelectThisFare);
    }
    @Step("Flight times are checked")
    public void checkFlightTime() {
        methods.findElement(btnLogin);
        Assert.assertEquals("Departure time is wrong", flightTime, methods.getText(textFlightTimeDetailsPage));
        Assert.assertEquals("Return time is wrong", landingTime, methods.getText(textLandingTimeDetailsPage));
        logger.info("Flight times checked");
    }
}

