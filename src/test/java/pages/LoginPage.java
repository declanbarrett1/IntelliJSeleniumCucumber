package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    WebDriver driver;

    @FindBy(id="txtUsername") WebElement usernameInput;
    @FindBy(id="txtPassword") WebElement passwordInput;
    @FindBy(id="btnLogin") WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void typeUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
