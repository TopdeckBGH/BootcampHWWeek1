package Week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();

        WebElement webElementMainPage = driver.findElement(By.cssSelector(".cart-dropdown :nth-child(1)"));
        webElementMainPage.click();
        WebElement webElementSignUp = driver.findElement(By.cssSelector("a[data-tracking-label=\"ÜyeOl\"]"));
        webElementSignUp.click();

        WebElement webElementLoginMail = driver.findElement(By.cssSelector("[placeholder=\"E-Posta Adresiniz\"]"));
        webElementLoginMail.sendKeys("yanlismail@gmail.com");
        WebElement webElementLoginPW = driver.findElement(By.cssSelector("[placeholder=\"Şifreniz\"]"));
        webElementLoginPW.sendKeys("1234");


        driver.manage().timeouts().implicitlyWait( 5000, TimeUnit.MILLISECONDS);

        WebElement webElementSignUpError = driver.findElement(By.cssSelector("[id=RegisterFormView_Password-error]"));
        if (webElementSignUpError.getText() == null)
        {
            System.out.println("Verilen sürede hata alınamadı.");
        }
        driver.manage().timeouts().implicitlyWait( 5000, TimeUnit.MILLISECONDS);
        System.out.println(webElementSignUpError.getText());

        driver.close();
    }
}
