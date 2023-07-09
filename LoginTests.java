package Tests;

import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUsername = "test";
    String invalidPassword = "test";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    

@Test
public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
    
@Test
public void verifyUnsuccessfulEmptyUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccessfulLogin(emptyUsernameError);
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccessfulLogin(emptyPasswordError);
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulInvalidLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUsername, invalidPassword);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.clickOnLogoutButton();
    loginPage.verifyLogout();
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}