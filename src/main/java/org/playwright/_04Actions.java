package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static utils.Utils.sleep;

public class _04Actions {
    Playwright playwright;
    Browser browser;
    Page page;
    Page page1;

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
    public void dragDrop(){

        page.navigate("https://demoqa.com/droppable");
        page.dragAndDrop("#draggable","#droppable");

}
    @Test
    public void dragDrop2(){

        page.navigate("https://demoqa.com/droppable");
        String source = "#draggable";
        String target = "#droppable";
        page.dragAndDrop(source, target);

    }
}
