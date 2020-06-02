package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private String formAuthenticationLink = "Form Authentication";
    private String DropDownLink = "Dropdown";
    private String HoverLink = "Hovers";
    private String largeAndDeepDomlink = "Large & Deep DOM";
    private String multipleWindowslink = "Multiple Windows";
    //By.xpath("//a[[contains(text(),'SAP M')]]")

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication(){
        clickLink(formAuthenticationLink);
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown(){
        clickLink(DropDownLink);
        return new DropDownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink(HoverLink);
        return new HoversPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink(largeAndDeepDomlink);
        return new LargeAndDeepDomPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows(){
        clickLink(multipleWindowslink);
        return new MultipleWindowsPage(driver);
    }
}
