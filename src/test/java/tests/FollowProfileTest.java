package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Config;
import utils.DriverFactory;

import static utils.Config.SEARCHKEY;
import static utils.Config.USERNAME;

public class FollowProfileTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public ProfilePage profilePage;
    public SearchResultsPage searchResultsPage;
    public SearchPeopleCategoryResultsPage searchPeopleCategoryResultsPage;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriver driver=DriverFactory.getDriver();
        String baseUrl =Config.URL;
        driver.get(baseUrl);
        loginPage=new LoginPage();
        homePage= loginPage.login(Config.USERNAME,Config.PASSWORD);
        Assert.assertEquals(Config.USERNAME,homePage.returnUserTag());
    }

    @Test
    public void verifyFollowingProfileTest() throws InterruptedException {
        searchResultsPage=homePage.searchProfile(SEARCHKEY);
        searchPeopleCategoryResultsPage=searchResultsPage.ClickOnSearchPeopleButton();
        profilePage=searchPeopleCategoryResultsPage.clickOnProfile(SEARCHKEY);
        String follow=profilePage.getTextFollowButton();
        if (follow.equalsIgnoreCase("Follow\nFollow")){
            profilePage.ClickOnFollow();
        }else if(follow.equalsIgnoreCase("Following\nFollowing")){
            System.out.println("User is already following " + SEARCHKEY);
        }
        profilePage.refreshPage();
        Assert.assertEquals(profilePage.getTextFollowButton(),"Following\nFollowing","User is not being followed");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        profilePage.ClickOnFollow();
        DriverFactory.closeDriver();

    }

}
