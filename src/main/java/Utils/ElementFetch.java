package main.java.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.internal.BaseTestMethod;
import test.java.BaseTest;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        if (identifierType == "XPATH") {
            return BaseTest.driver.findElement(By.xpath(identifierValue));
        } else {
            return null;
        }
    }
}