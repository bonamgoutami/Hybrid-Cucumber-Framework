package stepdefinitions;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import org.testng.Assert;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class LoginSteps {
   WebDriver driver;
   LoginPage loginPage;
        @Given("user opens browser and navigates to {string}")
            public void user_opens_browser_and_navigates_to(String url) throws InterruptedException {
                driver= new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                loginPage = new LoginPage(driver);

            }

        @When("user enter username {string} and password {string}")
            public void user_enter_username_and_password(String username, String password){
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
        }
        @And("user clicks on login button")
        public void user_clicks_on_login_button(){
            loginPage.clickLoginButton();
        }
        @Then("user should be navigated to products page")
    public void user_should_be_navigated_to_products_page() throws InterruptedException {
            driver.getCurrentUrl();
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
            Thread.sleep(1000);
            driver.quit();
        }

    @Then("error message should be displayed")

            public void  error_message_should_be_displayed() throws InterruptedException {
            System.out.println("is error displayed?"+ loginPage.isErrorDisplayed());
            Assert.assertTrue(loginPage.isErrorDisplayed());
            System.out.println(loginPage.getErrorMessage());
            Thread.sleep(500);
            driver.quit();
    }


    }

