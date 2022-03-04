import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drvs/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.rshb.ru/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        WebElement internetButton = driver.findElement(By.xpath("//*[@id='ibankouter']"));
        internetButton.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://online.rshb.ru/b1/ib6/wf2/retail/ib/loginretaildefault"));
        String title = driver.getTitle();
        System.out.println(title);


        WebElement tableLogin = driver.findElement(By.id("login-tabs"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfNestedElementLocatedBy(tableLogin, By.id("textfield")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='textfield']")));
        WebElement login = driver.findElement(By.id("textfield"));
        WebElement password = driver.findElement(By.id("passwordfield"));


            String text = null;
            login.sendKeys("тест");
            text = login.getText();

            System.out.println(login.getText());
            password.sendKeys("тест");


            System.out.println(login.getText());
            System.out.println(password.getText());


        WebElement signBtn = driver.findElement(By.xpath("//*[@class='ib-button-space']"));
        signBtn.click();


        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='t-error']")));
        WebElement errorField = null;
        errorField = driver.findElement(By.xpath("//*[@class='t-error']"));
        if(errorField != null) {
            System.out.println("УРААА");
        }

        driver.quit();
    }
}