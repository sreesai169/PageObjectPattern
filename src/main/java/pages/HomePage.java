package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebElementUtils.enterText;


public class HomePage extends BasePage{


    @FindBy(className = "search-input")
    private WebElement search;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement searchButton;

    @FindBy(css = ".DashboardProfileCard-screenname.u-inlineBlock.u-dir")
    private WebElement userScreenTag;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKey(String searchKey) {
        enterText(search, searchKey);
    }

    public void clickSearchButton(){
        searchButton.click();

    }

    public String returnUserTag(){
        return userScreenTag.getText();
    }


    public SearchResultsPage searchProfile(String searchKey) throws InterruptedException {
        enterSearchKey(searchKey);
        clickSearchButton();
        return new SearchResultsPage();
    }
}
