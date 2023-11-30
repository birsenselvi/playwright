package example.Base;

import com.microsoft.playwright.*;
import example.driver.Driver;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BaseTest {
    protected Page page;

    public BaseTest() {
        page = Driver.getPage();
    }

    public void textVisible(String text){
        Locator locator = page.getByText(text);
        assertThat(locator).isVisible();
    }


}
