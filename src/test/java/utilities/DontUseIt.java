package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DontUseIt {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    public void pageOne(){
        PageFactory.initElements(driver, this); }

    @FindBy(css = "@FindBy(css = input[name= 'username']")
    private WebElement userNameInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[type='button']")
    private WebElement saveButton;


}/////////////////////           LEAVE IT FOR FUTURE UPDATE                //////////////////////////////
