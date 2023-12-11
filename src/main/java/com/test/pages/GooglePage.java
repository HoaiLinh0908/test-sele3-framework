package com.test.pages;

import com.senelium.element.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GooglePage {

    @Step("Search {0}")
    public void search(String keyword) {
        Element search = new Element(By.cssSelector("textarea[type='search']"));
        search.type(keyword);
    }

    @Step("Verify the search is displayed")
    public boolean isSearchBarDisplayed() {
        Element search = new Element(By.cssSelector("textarea[type='search']"));
        return search.isDisplayed();
    }
}
