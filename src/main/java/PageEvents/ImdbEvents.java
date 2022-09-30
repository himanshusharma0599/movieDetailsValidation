package main.java.PageEvents;

import main.java.Utils.ElementFetch;
import main.java.PageObjects.ImdbElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static test.java.BaseTest.driver;

public class ImdbEvents {
    static String  releaseDateTxt=null;
   public static String countryTxt=null;
    public static String movieName="Pushpa: The Rise";
    public static LocalDate dateImdb=null;
    public void searchTheMovieNameImdb() throws InterruptedException {
        //Creating the object to fetch the element
        ElementFetch elementFetch=new ElementFetch();
        //Searching for the movie
        elementFetch.getWebElement("XPATH",ImdbElements.searchImdb).sendKeys(movieName);
        BaseTest.logger.pass("Entered the movie name in search field as: "+movieName);
        //Clicking the movie from suggestion's
        elementFetch.getWebElement("XPATH",ImdbElements.clickMovieNameImdb).click();
        BaseTest.logger.info("Clicked the movie name");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementFetch.getWebElement("XPATH",ImdbElements.releaseDateImdb));
        Thread.sleep(500);
        //Captures the Release Date value
         releaseDateTxt=elementFetch.getWebElement("XPATH",ImdbElements.releaseDateImdb).getText().substring(0, 17);;
        BaseTest.logger.info("Successfully navigated to Release date and Country details");
        BaseTest.logger.pass("Release Date at Imdb site: "+ releaseDateTxt);
        //This method change the current format of Date
        convertDateFormat();
        //Captures the Country value
        countryTxt=elementFetch.getWebElement("XPATH",ImdbElements.countryImdb).getText();
        BaseTest.logger.pass("Country at Imdb site: "+ countryTxt);
        Thread.sleep(500);


    }
    public static LocalDate getDateFromStringImdb(DateTimeFormatter format)
    {
        // Converting the string to date in the specified format
        LocalDate date = LocalDate.parse(releaseDateTxt, format);
        // Returning the converted date
        return date;
    }
    public static void convertDateFormat()
    {
        // Getting the format by creating an object of DateTImeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM d, yyyy");

        // Try block to check for exceptions
        try {
            // Getting the Date from String
           dateImdb = getDateFromStringImdb( format);
            // Printing the converted date
            BaseTest.logger.info("Imdb converted Date: "+dateImdb);
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
