package main.java.PageEvents;

import main.java.PageObjects.ImdbElements;
import main.java.PageObjects.WikiElements;
import main.java.Utils.ElementFetch;
import org.openqa.selenium.JavascriptExecutor;
import test.java.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static main.java.PageEvents.ImdbEvents.movieName;
import static test.java.BaseTest.driver;

public class WikiEvents {
    public static String countryWikiTxt=null;
    static String releaseDateWikiTxt=null;
    public static LocalDate dateWiki=null;
    public void searchTheMovieNameWiki() throws InterruptedException {
        //Creating the object to fetch the element
        ElementFetch elementFetch=new ElementFetch();
        //Searching for the movie
        elementFetch.getWebElement("XPATH", WikiElements.searchWiki).sendKeys(movieName);
        BaseTest.logger.pass("Entered the movie name in search field as: "+movieName);
        //Clicking the movie from suggestion's
        elementFetch.getWebElement("XPATH",WikiElements.clickMovieNameWiki).click();
        BaseTest.logger.info("Clicked the movie name");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elementFetch.getWebElement("XPATH",WikiElements.releaseDateWiki));
        Thread.sleep(500);
        BaseTest.logger.info("Successfully navigated to Release date and Country details");
        //Captures the Release Date value
        releaseDateWikiTxt=elementFetch.getWebElement("XPATH",WikiElements.releaseDateWiki).getText();
        BaseTest.logger.pass("Release Date: "+ releaseDateWikiTxt);
        //This method change the current format of Date
        convertDateFormatWiki();
        //Captures the Country value
        countryWikiTxt=elementFetch.getWebElement("XPATH",WikiElements.countryWiki).getText();
        BaseTest.logger.pass("Country: "+ countryWikiTxt);
        Thread.sleep(500);


    }
    public static LocalDate getDateFromStringWiki(DateTimeFormatter format)
    {
        // Converting the string to date in the specified format
        LocalDate date = LocalDate.parse(releaseDateWikiTxt, format);
        // Returning the converted date
        return date;
    }

    public static void convertDateFormatWiki()
    {
        // Getting the format by creating an object of DateTImeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");

        // Try block to check for exceptions
        try {
            // Getting the Date from String
        dateWiki = getDateFromStringWiki(format);
            // Printing the converted date
            BaseTest.logger.info("Wikipedia converted Date: "+dateWiki);
        }

        // Catch block to handle exceptions occurring if the String pattern is invalid
        catch (IllegalArgumentException e) {
            // Display the exception
            BaseTest.logger.info("Exception: " + e);
        }
        // If the String was unable to be parsed
        catch (DateTimeParseException e) {

            // Display the exception
            BaseTest.logger.info("Exception: " + e);
        }
    }
}
