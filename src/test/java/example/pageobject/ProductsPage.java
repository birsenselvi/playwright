package example.pageobject;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import example.Base.BaseTest;
import example.driver.Driver;

public class ProductsPage  extends BaseTest{

    Browser browser = Driver.getBrowser();
    Page p = Driver.getPage();

    Locator sortTheProducts;

    public ProductsPage(Page page) {
        sortTheProducts = page.locator(".product_sort_container");
        this.page = page;
    }
    public void sortZtoA(){
        sortTheProducts.selectOption("za");
    }

}
