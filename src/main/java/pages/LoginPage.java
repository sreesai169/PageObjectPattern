package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebElementUtils.enterText;
import static utils.WebElementUtils.waitForElement;

public class LoginPage extends BasePage{


//    @FindBy (name = "session[username_or_email]")
    @FindBy (css = ".text-input.email-input.js-signin-email")
    private WebElement userName;

    @FindBy(name = "session[password]")
    private WebElement password;

    @FindBy(css = "input[type=\"submit\"]" )
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String userNameValue) {
        enterText(userName,userNameValue);
    }

    public void enterPassword( String passwordValue) {
        enterText(password,passwordValue);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public HomePage login(String userNameValue, String passwordValue) {
        enterUserName(userNameValue);
        enterPassword(passwordValue);
        clickLoginButton();
        waitForElement();
        return new HomePage();
    }

}