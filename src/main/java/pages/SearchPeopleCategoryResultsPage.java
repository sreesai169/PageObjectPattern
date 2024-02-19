package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.WebElementUtils.waitForElement;

public class SearchPeopleCategoryResultsPage extends BasePage{

    @FindBy(css = ".u-linkComplex-target")
    private List<WebElement> searchPeopleButton;


    public SearchPeopleCategoryResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public ProfilePage clickOnProfile(String searchKey){
        waitForElement();
        for (WebElement e: searchPeopleButton){
            if(e.getText().equalsIgnoreCase(searchKey)){
                e.click();
            }
        }
        waitForElement();
        return new ProfilePage();
    }
}
