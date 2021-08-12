package com.company;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FinalPage {

    public static SelenideElement FINAL_NOTICE =$("h2.complete-header");

public String getFinalNotice(){
    String finalNotice = FINAL_NOTICE.getText();
    return finalNotice;
}

public void currentURL(){
url();
    }
}

