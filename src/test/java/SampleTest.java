package test.java;

import main.java.PageEvents.ImdbEvents;
import main.java.PageEvents.WikiEvents;
import org.testng.Assert;
import org.testng.annotations.Test;

import static main.java.PageEvents.ImdbEvents.countryTxt;
import static main.java.PageEvents.ImdbEvents.dateImdb;
import static main.java.PageEvents.WikiEvents.countryWikiTxt;
import static main.java.PageEvents.WikiEvents.dateWiki;

public class SampleTest extends BaseTest {
    @Test
    public void compareMovieDetails() throws InterruptedException {
        ImdbEvents imdbEvents=new ImdbEvents();
        WikiEvents wikiEvents=new WikiEvents();
        //Url for Imdb Site
        driver.navigate().to("https://www.imdb.com/");
        BaseTest.logger.info("Successfully navigated to Imdb Homepage");
        //Method to capture the details from Imdb Site
        imdbEvents.searchTheMovieNameImdb();
        Thread.sleep(2000);
        //Url for Wikipedia Site
        driver.navigate().to("https://en.wikipedia.org/");
        BaseTest.logger.info("Successfully navigated to Wikipedia Homepage");
        //Method to capture the details from Wikipedia Site
        wikiEvents.searchTheMovieNameWiki();
        //Validation for checking the Release dates from both sites are matching or not
        try{
            Assert.assertEquals(dateImdb, dateWiki);
        }catch(AssertionError e){
            BaseTest.logger.fail("Date's are not matching");
            throw e;
        }
        BaseTest.logger.pass("Date of Release on Imdb: "+dateImdb+" and Date of Release on Wikipedia: "+dateWiki+" is matching");

        //Validation for checking the Country from both sites are matching or not
        try{
            Assert.assertEquals(countryTxt, countryWikiTxt);
        }catch(AssertionError e){
            BaseTest.logger.fail("Country is not matching");
        }
        BaseTest.logger.pass("Country on Imdb: "+countryTxt+" and Country on Wikipedia: "+countryWikiTxt+" is matching");
        Thread.sleep(2000);
    }
}
