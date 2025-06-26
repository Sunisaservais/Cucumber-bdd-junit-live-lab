package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage {

    public PracticePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickLink(String linkText) {
        Driver.getDriver().findElement(By.partialLinkText(linkText)).click();
    }

}
