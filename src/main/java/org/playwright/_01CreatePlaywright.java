package org.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class _01CreatePlaywright {
   @Test
    public void createPlaywright(){
       Playwright playwright = Playwright.create();

       Browser browser=playwright.chromium().launch();
       Page page = browser.newPage();
       page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       browser.close();
       playwright.close();
   }
}