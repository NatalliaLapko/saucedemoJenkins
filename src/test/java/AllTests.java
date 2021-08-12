
import static com.codeborne.selenide.WebDriverRunner.url;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.company.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    RegistrationPage registrationPage = new RegistrationPage();
    FinalPage finalPage = new FinalPage();


    @BeforeEach
    @DisplayName("LogIn")

    public void login() throws IOException {

        loginPage.openLoginPage();
        loginPage.login();
        Assertions.assertEquals(Links.loginPage, url(), "Wrong page!");
    }

    @AfterEach
    @DisplayName("LogOut")
    public void logout(){
        loginPage.logout();
    }

    @Test
    @DisplayName("Ordering")
    @Order(2)
    public void purchase() throws IOException {

        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.setFirstName("Test");
        registrationPage.setLastnameName("User");
        registrationPage.setZipCode("123456");
        registrationPage.registration();
        registrationPage.finish();
        finalPage.currentURL();
        String notice = finalPage.getFinalNotice();

        Assertions.assertEquals(Links.checkoutComplete, url(), "Wrong page!");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", notice, "Wrong message!");

    }

    @Test
    @DisplayName("Order cancellation")
    @Order(3)
    public void orderCancellation()  {


        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.setFirstName("Default");
        registrationPage.setLastnameName("User");
        registrationPage.setZipCode("111111");
        registrationPage.registration();
        registrationPage.cancel();


        Assertions.assertEquals(Links.inventory, url());

    }


    @Test
@DisplayName("Items Removing")
    @Order(1)
    public void removeItemsFromCart() throws IOException {

        cartPage.addToCart();
        cartPage.goToCart();
        ElementsCollection cartItemsCollection = CartPage.CART_LIST.$$(By.cssSelector("div.cart_item"));
        int colSize = cartItemsCollection.size();

        for (int i = 0; i < colSize; i++) {
            cartItemsCollection.first().$((By.xpath(".//button[text()='Remove']"))).click();
        }

        colSize = cartItemsCollection.size();

       Assertions.assertEquals( 0, colSize);




    }


    @Test
    @DisplayName("Total Sum Calculation")
    @Order(4)
    public void totalItems() throws IOException {

        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.setFirstName("User");
        registrationPage.setLastnameName("Test");
        registrationPage.setZipCode("5415549");
        registrationPage.registration();
        ElementsCollection cartItemsCollection = CartPage.FINAL_LIST.$$(By.cssSelector("div.cart_item_label"));
        int colSize = cartItemsCollection.size();

        double totalItemSum = 0;
        double itemPrice = 0;
        for (int i = 0; i < colSize; i++) {
            String temp = cartItemsCollection.get(i).$(By.cssSelector("div.inventory_item_price")).getText();
            temp = temp.substring(1);
            itemPrice = Double.parseDouble(temp);
            totalItemSum += itemPrice;

        }

        double expectedSum =  totalItemSum + registrationPage.getTax();


         System.out.println("Total Item = " + totalItemSum);
         System.out.println("Tax = " + registrationPage.getTax());
         System.out.println("Total Sum = " + expectedSum);
         System.out.println("RealSum = " + registrationPage.getTotalSum() + "\n" + "ExpectedSum = " + expectedSum);

        Assertions.assertEquals(registrationPage.getTotalItem(), totalItemSum);
        Assertions.assertEquals(registrationPage.getTotalSum(), expectedSum);




    }
}















