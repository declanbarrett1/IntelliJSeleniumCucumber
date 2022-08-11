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

public class loginStepsWithData {
    WebDriver driver;
    LoginPage loginPage;
    String className = this.getClass().getSimpleName();

    @Given("User Has Opened Browser")
    public void user_has_opened_browser() {
        driver = new SafariDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }
    @When("User has gone to OrangeHRM")
    public void user_has_gone_to_orange_hrm() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }
    @And("User inputs username {string} and password {string}")
    public void user_inputs_username_and_password(String username, String password) {
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
    }
    @And("User clicks to login")
    public void user_clicks_to_login() {
        loginPage.clickLogin();
        loginPage.sleep(10000);
    }
    @Then("Validate Login")
    public void validate_login() {
      System.out.println(driver.getCurrentUrl());
      boolean isVisible = driver.findElement(By.id("menu_admin_viewAdminModule")).isDisplayed();
      Screenshotting.takeScreenshot(driver,className);
      Assert.assertTrue(isVisible);
    }
    @And("Quit Browser")
    public void quit_browser() {
        driver.quit();
    }
}
