package com.company;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.io.IOException;


public class LoginPage{

    public static SelenideElement USERNAME_FIELD = $("#user-name");
    public static SelenideElement PASSWORD_FIELD = $("#password");
    public static SelenideElement LOGIN_BUTTON = $("#login-button");
    public static SelenideElement MENU_BUTTON = $("#react-burger-menu-btn");
    public static SelenideElement LOGOUT_BUTTON = $("#logout_sidebar_link");
    public static SelenideElement ERROR_MESSAGE =$("div.error-message-container ");



    public void login() throws IOException{
        USERNAME_FIELD.sendKeys("standard_user");
        PASSWORD_FIELD.sendKeys("secret_sauce");
        LOGIN_BUTTON.click();

    }

    public void openLoginPage(){
        open("https://www.saucedemo.com/");
    }

    public void logout() {
        MENU_BUTTON.click();
        LOGOUT_BUTTON.click();
    }


}
