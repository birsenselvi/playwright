package org.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static utils.Utils.sleep;

public class _05Locators {
    Playwright playwright;
    Browser browser;
    Page page;
   String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeTest
    public void beforeTest() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setSlowMo(1000)
        );

        page = browser.newPage();

    }

    @AfterTest
    public void afterTest() {
        sleep(3);
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void test1(){
        page.navigate(url);
        Locator username = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username"));
        username.fill("Admin");
        Locator password = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
        password.fill("admin123");
        // testng
        // Assert.assertTrue(admin.isVisible());
        // playwright
        // assertThat(admin).isVisible()
    }
    @Test
    public void testFocus(){
        page.navigate(url);
        Locator username = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username"));
        username.fill("Admin");
        Locator password = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
        password.fill("admin123");
        username.focus();
        password.focus();
        username.focus();
        password.focus(); // üzerine gelir aktiflestirir.
    }
    @Test
    public void testHover(){
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        Locator bild1 = page.locator(".figure:nth-of-type(1)");
        Locator bild2 = page.locator(".figure:nth-of-type(2)");
        Locator bild3 = page.locator(".figure:nth-of-type(3)");
        Locator bild4 =page.locator(".figure:nth-of-type(3)");
        Locator[] bilds = {page.locator(".figure:nth-of-type(1)"), page.locator(".figure:nth-of-type(2)"),
                page.locator(".figure:nth-of-type(3)"), page.locator(".figure:nth-of-type(3)")
        };
        for(Locator loc : bilds){
        loc.hover();
        sleep(2);
        }
    }
    @Test
    public void testHover2(){
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        for(Locator locator : page.locator(".figure").all()){
            locator.hover();
            sleep(2);
        }
    }
}
