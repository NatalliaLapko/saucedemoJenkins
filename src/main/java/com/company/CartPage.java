package com.company;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class CartPage {

    public static SelenideElement CART_BUTTON = $("a.shopping_cart_link");
    public static SelenideElement ITEMS_LIST = $("div.inventory_list");
    public static SelenideElement CHECKOUT_BUTTON = $("#checkout");
    public static SelenideElement CART_LIST = $("div#cart_contents_container");
    public static SelenideElement FINAL_LIST = $("div#checkout_summary_container");



    public static void goToCart(){
        CART_BUTTON.click();
    }

    public static void addToCart() {

        ElementsCollection itemsCollection = CartPage.ITEMS_LIST.$$(By.cssSelector("div.inventory_item_description"));
        int itemsCollectionSize = itemsCollection.size();


        for (int i = 0;i <itemsCollectionSize; i++) {
            itemsCollection.get(i).$((By.xpath(".//button[text()='Add to cart']"))).click();
        }
    }


    public void purchase () {
        CHECKOUT_BUTTON.click();
    }

}