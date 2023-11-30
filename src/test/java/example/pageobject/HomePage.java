package example.pageobject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import example.Base.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class HomePage extends BaseTest {

    Locator username = page.locator("//input[@name='user-name']");
    Locator password = page.locator("//input[@name='password']");
    Locator login = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    Locator productsTitle = page.locator("//span[@class='title' and text()='Products']");



    public void login(String user, String pass){
        username.fill(user);
        password.fill(pass);
        login.click();
    }
    public void goToPage(String url){
        page.navigate(url);
    }
    public ProductsPage assertLoginSuccessfull(){
        assertThat(productsTitle).isVisible();

        return new ProductsPage(page);

    }



}
