package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class ShoppingPage extends BasePage {
    
    public ShoppingPage (WebDriver driver){
        super(driver);
    }

    By itemName  = By.id("item_4_title_link");
    By itemName2  = By.id("item_1_title_link");
    By checkoutButtonBy = By.name("checkout");
    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By zipBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
        
public ShoppingPage verifyProductsOnPage (String item1, String item2){
    String actualText1 =  readText(itemName);
    String actualText2 =  readText(itemName2);
    assertTextEquals(actualText1, item1);
    assertTextEquals(actualText2, item2);
    return this;
}

public ShoppingPage verifyPrice (String firstName, String lastName, String zip){
    click(checkoutButtonBy);
    writeText(firstNameBy, firstName);
    writeText(lastNameBy, lastName);
    writeText(zipBy, zip);
    click(continueButtonBy);
    
    By itemTotalBy = By.className("summary_subtotal_label");
    By taxBy = By.className("summary_tax_label");
    By totalBy = By.className("summary_total_label");
    

    Double actualItemTotalBy = Double. parseDouble(readText(itemTotalBy).substring(13));
    Double actualTaxBy = Double. parseDouble(readText(taxBy).substring(6));
    Double actualTotalBy = Double. parseDouble(readText(totalBy).substring(8));
    
    assertEquals(actualTotalBy, actualItemTotalBy + actualTaxBy, 0);
    return this;
}

public ShoppingPage verifyOrder (String expectedText){
    By finishBy = By.name("finish");
    click(finishBy);
    By completeOrderBy = By.className("complete-header");
    String actualText = readText(completeOrderBy);
    assertTextEquals(expectedText, actualText);
    return this;
}
    
}