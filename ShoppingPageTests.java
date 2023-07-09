package Tests;

import org.junit.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingPage;

public class ShoppingPageTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public ShoppingPage shoppingPage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String firstName = "Goran";
    String lastName = "Popovic";
    String zip = "11000";
    String item1 = "Sauce Labs Backpack";
    String item2 = "Sauce Labs Bolt T-Shirt";
    String verifyOrder = "Thank you for your order!";
            
@ Test
public void verifyProductsOnCart(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ShoppingPage shoppingPage = new ShoppingPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();
    shoppingPage.verifyProductsOnPage(item1, item2);

    try{
    Thread.sleep(5000);
    }catch(InterruptedException e){
    e.printStackTrace();
    }
}

@Test
public void verifyPrice(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ShoppingPage shoppingPage = new ShoppingPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();
    shoppingPage.verifyProductsOnPage(item1, item2);
    shoppingPage.verifyPrice(firstName, lastName, zip);

    try{
    Thread.sleep(5000);
    }catch(InterruptedException e){
    e.printStackTrace();
    }
}


@Test
public void verifyOrder(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ShoppingPage shoppingPage = new ShoppingPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();
    shoppingPage.verifyProductsOnPage(item1, item2);
    shoppingPage.verifyPrice(firstName, lastName, zip); 
    shoppingPage.verifyOrder(verifyOrder);
    
    try{
    Thread.sleep(5000);
    }catch(InterruptedException e){
    e.printStackTrace();
    }
}

}