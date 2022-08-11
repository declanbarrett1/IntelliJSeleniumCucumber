package tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.LoginPage;
import utilities.Screenshotting;

import java.time.Duration;



public class loginStepsWithNoExternalData {
    WebDriver driver;
    LoginPage loginPage;
    String className = this.getClass().getSimpleName();

    @Given("User Loads Up Browser")
    public void user_loads_up_browser() {
        driver = new SafariDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);


    }
    @When("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }
    @And("User inputs username")
    public void user_inputs_username() {
      loginPage.typeUsername("Admin");
    }
    @And("User inputs password")
    public void user_inputs_password() {
      loginPage.typePassword("admin123");
    }
    @And("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
        loginPage.sleep(4000);
        Screenshotting.takeScreenshot(driver,className);
    }
    @Then("validate login success")
    public void validate_login_success() {
        System.out.println(driver.getCurrentUrl());
        boolean isVisible = driver.findElement(By.id("menu_admin_viewAdminModule")).isDisplayed();
        Screenshotting.takeScreenshot(driver,className);
        Assert.assertTrue(isVisible);
    }
    @And("browser teardown")
    public void browser_teardown() {
        driver.close();
    }
}
