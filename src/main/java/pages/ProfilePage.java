package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebElementUtils.waitForElement;


public class ProfilePage extends BasePage{

//    @FindBy(xpath = "//*[@id=\"page-container\"]/div[1]/div/div[2]/div/div/div[2]/div/div/ul/li[6]/div/div/span[2]/button[1]")
    @FindBy(css = ".user-actions-follow-button.js-follow-btn.follow-button")
    private WebElement followButton;


    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void ClickOnFollow(){
        followButton.click();
        waitForElement();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String getTextFollowButton(){
        return followButton.getText();
    }
}
