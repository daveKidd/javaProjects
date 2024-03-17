import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseGoogle {
    public static void main(String[] args) {
        // tells where to get chromedriver so we can start automating the browser
        //System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();


        // creates a new instace of ChromeDriver()
        WebDriver driver = new ChromeDriver();

        // opens up Google in chromedriver.exe
        driver.get("http://www.google.com");

        // looks for the search box on the screen using it's name attribute "q"
        WebElement searchBox = driver.findElement(By.name("q"));

        // automatically sends the text "Dev10" into the search box we found
        searchBox.sendKeys("Dev10");

        // looks for the button that submits the search using it's name attribute "btnK"
        WebElement searchButton = driver.findElement(By.name("btnK"));

        // The search button is a submit button type so we use .submit() to start the search
        searchButton.submit();

        // looks for the result of the Google search and clicks on it
        driver.findElement(By.partialLinkText("Dev10 Consultants - Genesis10")).click();
    }
}

