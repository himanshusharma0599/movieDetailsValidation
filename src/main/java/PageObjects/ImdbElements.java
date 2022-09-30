package main.java.PageObjects;

import org.openqa.selenium.By;

import static main.java.PageEvents.ImdbEvents.movieName;

public interface ImdbElements {
    String searchImdb="//input[@placeholder='Search IMDb']";
    String clickMovieNameImdb="//div[contains(text(),'"+movieName+"')]";
    String releaseDateImdb="//a[text()='Release date']/following::a[1]";
    String countryImdb="//span[text()='Country of origin']/following::a[1]";
}
