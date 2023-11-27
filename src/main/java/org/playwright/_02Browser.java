package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class _02Browser {
    @Test
    public void testHeadless(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)); // default true
        Page page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.close();
        browser.close();
        playwright.close();
    }
    @Test
    public void testChannel(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
                        //.setChannel("medge");
        Page page = browser.newPage();
        page.navigate("https://saucedemo.com");
        page.locator("//input[@id='user-name']").fill("standard_user");
        page.locator("//input[@id='password']").fill("secret_sauce");
        page.locator("//input[@id='login-button']").click();
        page.locator("(//button[.='Add to cart'])[1]").click();
        page.close();
        browser.close();
        playwright.close();
    }
    @Test
    public void multiBrowser(){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(500));
        Browser browser1 = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(500));
        Page page = browser.newPage();
        Page page1 = browser1.newPage();


    }
}
