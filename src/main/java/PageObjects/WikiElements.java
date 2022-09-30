package main.java.PageObjects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static main.java.PageEvents.ImdbEvents.movieName;

public interface WikiElements {
    String searchWiki="//input[@placeholder='Search Wikipedia']";

    String clickMovieNameWiki="//span[contains(text(),'"+movieName+"')]";

    String releaseDateWiki="//div[text()='Release date']/following::li[1]";

    String countryWiki="//th[text()='Country']/following::td[1]";

}
