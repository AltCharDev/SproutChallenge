package StepDefinition;

import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

import static Pages.SearchPage.tableId;

public class ASPDemo {

    WebDriver driver = null;
    String id = "";

    @Given("User inputs an ID number")
    public void userInputsAnIDNumber() {
        id = JOptionPane.showInputDialog("Enter ID number");

    }

    @When("Open Web Browser and Navigate to ASPDemo")
    public void openWebBrowserAndNavigateToASPDemo() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("User Navigates to ASPDemo website")
    public void userNavigatesToASPDemoWebsite() {
        driver.manage().window().maximize();
        driver.get("https://demo.aspnetawesome.com/");
    }

    @And("User Navigates to Grid page")
    public void userNavigatesToGridPage() {
        driver.findElement(By.xpath(SearchPage.GridLink)).click();
    }

    @And("User Selects Specific ID")
    public void userSelectsSpecificID() throws InterruptedException {
        Thread.sleep(1000);
        int pageNum = Integer.parseInt(driver.findElement(By.xpath(SearchPage.pageNum)).getText());
        int ctr = 1;
        int ctr2 = 2;
        int ctr3 = 1;

        while (ctr <= 10) {
            if (driver.findElement(By.xpath(tableId(ctr3))).getText().equals(id)) {
                break;
            } else if (ctr == 10) {
                if (ctr2 > pageNum) {
                    JOptionPane.showMessageDialog(null,"Error ID not found");
                    break;
                } else {
                    driver.findElement(By.xpath(SearchPage.pageNumSearch(ctr2+""))).click();
                    Thread.sleep(500);
                    ctr = 1;
                    ctr3 = 1;
                    ctr2++;
                }
            }
            ctr++;
            ctr3 = ctr3 + 7;
        }
    }

    @Then("User should see the table information")
    public void userShouldSeeTheTableInformation() {
        System.out.println(driver.findElement(By.xpath(SearchPage.person(id))).getText());
        System.out.println(driver.findElement(By.xpath(SearchPage.food(id))).getText());
        System.out.println(driver.findElement(By.xpath(SearchPage.country(id))).getText());
        System.out.println(driver.findElement(By.xpath(SearchPage.date(id))).getText());
        System.out.println(driver.findElement(By.xpath(SearchPage.chef(id))).getText());
    }

    @And("Close Browser")
    public void closeBrowser() {
        driver.close();
    }
}
