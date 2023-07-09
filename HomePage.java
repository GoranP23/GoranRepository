package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }
    
    By homePageTitleBy = By.className("title");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItems = By.className("inventory_item");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");


    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyProductAddedToCart (){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoppingCartBadgeBy);
        click(shoppingCartBadgeBy);
        return this;
    }

    public HomePage verifyNumberOfProducts(int expectedInt){
        int actualInt = countItems(numberOfItems);
        assertIntegerEquals(expectedInt, actualInt);
        return this;
    }

    public HomePage clickOnMenuButton(){
        click (menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton(){
        click (logoutButtonBy);
        return this;
    }
    
}