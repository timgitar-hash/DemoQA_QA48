package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectMenuPage selectOldStyle(String colour) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(colour);
        return this;
    }


    public SelectMenuPage verifyColour() {
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assert.assertTrue(shouldHaveText(oldSelectMenu,firstSelectedOption,5));
        return this;
    }

    @FindBy(id = "cars")
    WebElement selectcars;
    public SelectMenuPage standartMultiSelect(String[] cars) {
        Select multi = new Select(selectcars);
        for (int i=0;i<cars.length;i++){
            if(multi.isMultiple()){
                multi.selectByVisibleText(cars[i]);

            }

        }
        return this;

    }
}
