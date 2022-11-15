package Pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BookPage {

    Methods methods;
    Logger logger = LogManager.getLogger(BookPage.class);
    By btnOneWay = By.xpath("//android.widget.LinearLayout[@content-desc=\"One-way\"]");
    By btnFrom = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder");
    By inputDestination = By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext");
    By selectAirportFromList = By.id("com.m.qr:id/rvmp_item_ond_selection_list_root_view");
    By btnTo = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view");
    By openCalendar = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_date_holder_date_text_view");
    By btnCalendarConfirm = By.id("com.m.qr:id/fragment_calendar_confirm_button");
    By btnSearchFlights = By.id("com.m.qr:id/rvmp_booking_search_flights_button");
    By textFligthPageTitle = By.id("com.m.qr:id/rvmp_results_count");


    public BookPage() {
        methods = new Methods();
    }

    @Step("Make a one-way choice")
    public void oneWay() {
        methods.click(btnOneWay);
        logger.info("One-way flight selected");
    }

    @Step("Departure <from> , Landing <to> are selected")
    public void selectRota(String from, String to) {
        methods.click(btnFrom);
        methods.sendKeys(from, inputDestination);
        methods.click(selectAirportFromList);
        logger.info("Departure location selected");
        methods.click(btnTo);
        methods.sendKeys(to, inputDestination);
        methods.click(selectAirportFromList);
        logger.info("Landing place selected");

    }

    @Step("Departure date is selected the day after <number of days> from this day")
    public void selectDepartureDate(int numberofdays) {
        methods.click(openCalendar);
        By selectDepartureDay = By.xpath("//*[@text='" + methods.addDay(7) + "']");
        methods.click(selectDepartureDay);
        methods.click(btnCalendarConfirm);
        logger.info("Departure date selected");
    }

    @Step("Flight is sought")
    public void searchFlight() {
        methods.click(btnSearchFlights);
        methods.findElement(textFligthPageTitle);
        Assert.assertTrue(methods.getText(textFligthPageTitle).contains("results"));
        logger.info("Flight searched");
    }

}

