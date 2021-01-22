package auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    final static String TITLESearchPage = "AR51 1AA, Area51";
    final static String TITLE = "Enter your postcode";
    final static String Content = "Login by entering the email address of a User that is saved in the database.";
    WebDriver driver;
    String xpathHeading = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div[2]/nav";
    String xpathLink = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div[2]/nav/div[2]/a[1]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPinCodeSearch() {
        String actualTitle = driver.findElement(By.xpath("//span[contains(.,'Enter your postcode')]")).getText();
        assertEquals(actualTitle, TITLE,
                "Actual title " + actualTitle + " should be same as expected " + TITLE);
    }
    public void verifyPinCodeSearchEntered(String pin) {
     driver.findElement(By.name("postcode")).sendKeys(pin);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

       String val =  driver.findElement(By.xpath("//h1[contains(.,'AR51 1AA, Area51')]")).getText();
        assertEquals(val, TITLESearchPage,
                "Actual title " + val + " should be same as expected " + TITLESearchPage);
    }

    public void verifySearchResultByValue(String Data) {
        driver.findElement(By.id("dish-search")).sendKeys(Data);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        {
            List<WebElement> elements3 = driver.findElements(By.xpath("//h3[contains(.,'Demo - C')]"));
            assert (elements3.size() > 0);
        }
    }
    public void verifyPinCodeSearchChanged(String newpincode) {
        driver.findElement(By.linkText("change location")).click();
        driver.findElement(By.name("postcode")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("postcode")).sendKeys(Keys.DELETE);

        driver.findElement(By.name("postcode")).sendKeys(newpincode);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();

        String val =  driver.findElement(By.xpath("//h1[contains(.,'AR6 2AA, Ar62aa')]")).getText();
        assertEquals(val, "AR6 2AA, Ar62aa",
                "Actual title " + val + " should be same as expected " + "AR6 2AA, Ar62aa");
    }
    public void verifySearchResult(String option) {
        List<WebElement> elements = driver.findElements(By.xpath("//h3[contains(.,'Pizza Hut - Shell Menu')]"));
        assert (elements.size() > 0);
        if (option.contains("option and new"))
        {
            driver.findElement(By.xpath("//div[3]/span[3]/label")).click();
        {
            List<WebElement> elements2 = driver.findElements(By.xpath("//h3[contains(.,'Load Testaurant')]"));
            assert (elements2.size() > 0);
        }
            driver.findElement(By.xpath("//main[@id='skipToMain']/div[3]/div/main/div/div/div/div/div/div[5]/span[4]/label")).click();
        {
            List<WebElement> elements3 = driver.findElements(By.xpath("//h3[contains(.,'Demo - Sticky Sisters')]"));
            assert (elements3.size() > 0);
        }
            driver.findElement(By.xpath("//button[contains(.,'Reset')]")).click();
            driver.findElement(By.xpath("//main[@id='skipToMain']/div[3]/div/main/div/div/div/div/div/div[4]/button")).click();
            {
                List<WebElement> elements4 = driver.findElements(By.xpath("//h3[contains(.,'Pizza Hut - Shell Menu')]"));
                assert(elements4.size() > 0);
            }}
    }
}
