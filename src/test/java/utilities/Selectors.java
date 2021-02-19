package utilities;

import org.openqa.selenium.By;

public class Selectors {
    public static By username = By.cssSelector("input[name= 'username']");
    public static By password = By.cssSelector("input[type='password']");
    public static By addUser = By.cssSelector("a[href='addauser.php']");
    public static By saveButton = By.cssSelector("input[type='button']");
    public static By userNameInput = By.xpath("//*[text()=' Artur']");
    public static By goToLoginPage = By.cssSelector("a[href='login.php']:nth-child(7)");
    public static By testLoginButton = By.cssSelector("input[type='button']");
    public static By alertMessage = By.cssSelector("center>b");


    //////////////////////////    Selectors for Part Two     /////////////////////////////

    public static By usernameMersys = By.cssSelector("input[formcontrolname='username']");
    public static By passwordMersys = By.cssSelector("input[formcontrolname='password']");
    public static By loginButtonMersys = By.cssSelector("button[aria-label='LOGIN']");
//    public static By titleOfMersysWebSite = By.cssSelector("h3[_ngcontent-yjb-c306]");
//    public static By titleOfMersysWebSiteSecond = By.cssSelector("span[_ngcontent-iaf-c307]:nth-child(2)");
    public static By menu = By.cssSelector("svg[data-icon=\"bars\"]");
    public static By alert = By.cssSelector("div[role='alertdialog']");


}
