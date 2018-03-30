package recettes.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Admin {

    public void goAdmin(WebDriver driver) {
        // on attend que le bouton goAdmin soit chargé
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("goAdmin")));

        driver.findElement(By.id("goAdmin")).click();
    }


    public void login(WebDriver driver) {
        try {
            WebElement nomLogin = driver.findElement(By.name("username"));
            WebElement motDePasse = driver.findElement(By.name("password"));
            nomLogin.clear();
            motDePasse.clear();

            nomLogin.sendKeys("root");
            motDePasse.sendKeys("dfjk");

            // submit
            driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        }
        catch (NoSuchElementException e) {
            System.out.println("INFO : admin à priori déjà connecté");
        }
    }
}
