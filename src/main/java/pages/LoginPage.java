package pages;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class LoginPage {

    private WebDriver driver;

    private File inputFile;
    private SAXReader saxReader = new SAXReader();
    private Document document;

    private String username;
    private String password;

    private By usernameField;
    private By passwordField;
    private By loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        inputFile = new File(System.getProperty("user.dir") +"\\properties.xml");
        try {
            document = saxReader.read(inputFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        username = document.selectSingleNode("//page/username").getText();
        password = document.selectSingleNode("//page/password").getText();
        usernameField = By.id(username);
        passwordField = By.id(password);
        loginButton = By.cssSelector("#login button");
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
