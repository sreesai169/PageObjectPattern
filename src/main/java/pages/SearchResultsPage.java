package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "a[data-nav=\"search_filter_users\"")
    private WebElement searchPeopleButton;


    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public SearchPeopleCategoryResultsPage ClickOnSearchPeopleButton() {
        searchPeopleButton.click();
        return new SearchPeopleCategoryResultsPage();
    }
}
