package example.stepdefs;

import example.pageobject.HomePage;
import example.pageobject.ProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class StepdefsLogin  {
    HomePage homePage = new HomePage();
    ProductsPage productsPage;
    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        homePage.goToPage(url);
    }

    @When("user login with the following credential")
    public void userLoginWithTheFollowingCredential(DataTable table) {
        Map<String,String> map = table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        homePage.login(username,password);


    }

    @Then("login should be succesfull")
    public void loginShouldBeSuccesfull() {

        productsPage = homePage.assertLoginSuccessfull();
    }

    @And("sort the product Z to A")
    public void sortTheProductZToA() {
        productsPage.sortZtoA();
    }
}
