package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import org.testng.Assert;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.util.Set;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    String parentWindow;

    @Given("user opens browser and navigates to {string}")
    public void user_opens_browser_and_navigates_to(String url) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);

    }

    @When("user enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user should be navigated to products page")
    public void user_should_be_navigated_to_products_page() throws InterruptedException {
        driver.getCurrentUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Thread.sleep(1000);

    }

    @Then("error message should be displayed")

    public void error_message_should_be_displayed() throws InterruptedException {
        System.out.println("is error displayed?" + loginPage.isErrorDisplayed());
        Assert.assertTrue(loginPage.isErrorDisplayed());
        System.out.println(loginPage.getErrorMessage());
        Thread.sleep(500);

    }

    @And("user clicks on Twitter link in footer")
    public void user_clicks_on_Twitter_link_in_footer() {
        parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle is " + parentWindow);
        loginPage.clickTwitterPage();
    }

    @Then("user should switch to Twitter window  and verify title")
    public void user_should_switch_to_Twitter_window_and_verify_title() {
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All window handles" + allWindows.size());
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("current title: " + driver.getTitle());
                System.out.println("child url:" + driver.getCurrentUrl());
                Assert.assertTrue(driver.getTitle().contains("Twitter")||driver.getTitle().contains("X"));
            }

        }
    }


    @And("user should close child window and come back to parent window")
    public void user_should_close_child_window_and_come_back_to_parent_window() {
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println("Back to window: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
        driver.quit();
    }

    @After
            public void tearDown(){
            if (driver != null)
                driver.quit();
        }
    }







