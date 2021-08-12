package com.company;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class RegistrationPage  {
    public static SelenideElement CONTINUE_BUTTON = $("#continue");
    public static SelenideElement FIRSTNAME_FORM = $("input#first-name");
    public static SelenideElement LASTNAME_FORM = $("input#last-name");
    public static SelenideElement ZIP_CODE = $("input#postal-code");

    public static SelenideElement FINISH_BUTTON = $("#finish");
    public static SelenideElement CANCEL_BUTTON = $("button#cancel");

    public static SelenideElement ITEM_TOTAL = $("div.summary_subtotal_label");
    public static SelenideElement TAX = $("div.summary_tax_label");
    public static SelenideElement TOTAL = $("div.summary_total_label");



//Filling registration form
    public void setFirstName(String firstName){
        FIRSTNAME_FORM.sendKeys(firstName);
    }
    public void setLastnameName(String lastName){
        LASTNAME_FORM.sendKeys(lastName);    }

    public void setZipCode(String zipCode){
        ZIP_CODE.sendKeys(zipCode);    }

    public void registration() {
        CONTINUE_BUTTON.click();

    }

    //Cancelling order

    public void finish() {
        FINISH_BUTTON.click();
    }

    public void cancel() {
        CANCEL_BUTTON.click();
    }




    //Calculating and comparing total sum

    public double getTotalItem(){
        String totalItem = ITEM_TOTAL.getText().substring(ITEM_TOTAL.getText().lastIndexOf("$") + 1);
        return Double.parseDouble(totalItem);

    }

    public double getTax(){
        String tax = TAX.getText().substring(TAX.getText().lastIndexOf("$") + 1);
        return Double.parseDouble(tax);
    }

    public double getTotalSum() {
        String total = TOTAL.getText().substring(TOTAL.getText().lastIndexOf("$") + 1);
        return Double.parseDouble(total);
    }




    }






