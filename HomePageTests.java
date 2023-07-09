package Tests;

import org.junit.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int numberOfAllItems = 6;
  
@ Test
public void verifySuccessfulAddToCart(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();
    
    try{
    Thread.sleep(5000);
    }catch(InterruptedException e){
    e.printStackTrace();
    }
}

@Test
public void numberOfItemsHomePage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyNumberOfProducts(numberOfAllItems);

    try{
        Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}