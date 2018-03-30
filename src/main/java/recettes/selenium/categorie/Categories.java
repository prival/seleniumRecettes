package recettes.selenium.categorie;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Categories {


    public void goGestionCategories(WebDriver driver) {
        driver.findElement(By.id("goGestionCategories")).click();
    }


    public void creerCategorie(WebDriver driver, String libelle) {
        driver.findElement(By.id("libelleCategorie")).sendKeys(libelle);
        driver.findElement(By.id("creerCategorie")).click();
    }


    public void modifierCategorie(WebDriver driver, String oldLibelle, String newLibelle) {
        driver.findElement(By.id("id_" + oldLibelle)).click();

        driver.findElement(By.id("libelle")).clear();
        driver.findElement(By.id("libelle")).sendKeys(newLibelle);

        driver.findElement(By.id("buttonModifier")).click();
    }


    public void supprimerCategorie(WebDriver driver, String libelle) {
        WebElement tr = driver.findElement(By.id("tr_id_" + libelle));
        tr.findElement(By.name("supprimer")).click();

        // confirme la suppression
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void verifieCategoriePresente(WebDriver driver, String libelle) {
        boolean result = false;
        try {
            driver.findElement(By.xpath("//span[contains(text(), '" + libelle + "')]"));
            result = true;
        }
        catch (NoSuchElementException e) {
            result = false;
            e.printStackTrace();
        }

        Assert.assertEquals(true, result);
    }


    public void verifieCategoriePremiereDuMenu(WebDriver driver, String libelle) {

        List<WebElement> list = driver.findElements(By.className("menu-first"));

        String text = list.get(0).getText();

        Assert.assertEquals(text, libelle);
    }


    public void verifieCategorieAbsenteDuMenu(WebDriver driver, String libelle) {

        boolean result = false;

        List<WebElement> list = driver.findElements(By.className("menu-first"));

        for (WebElement elmt : list) {
            if (libelle.equals(elmt.getText())) {
                result = true;
            }
        }

        Assert.assertEquals(false, result);
    }
}
