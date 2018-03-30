package recettes.selenium.recette;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Recettes {

    public void choisirCategorie(WebDriver driver, String libelle) {
        Select TypeCategorie = new Select(driver.findElement(By.id("categorie")));
        TypeCategorie.selectByVisibleText(libelle);
    }

    public void ajouterTitre(WebDriver driver, String libelle) {
        driver.findElement(By.id("libelle")).sendKeys(libelle);
    }

    public void ajouterPremierIngredient(WebDriver driver, String libelle) {
        List<WebElement> ingredients = driver.findElements(By.name("ingredientName"));
        ingredients.get(0).sendKeys(libelle);
    }

    public void ajouterIngredientSuivant(WebDriver driver, String libelle) {
        driver.findElement(By.id("ingredientButtonPlus")).click();
        List<WebElement> ingredients = driver.findElements(By.name("ingredientName"));
        ingredients.get(ingredients.size() - 1).sendKeys(libelle);
    }

    public void ajouterPremiereEtape(WebDriver driver, String libelle) {
        List<WebElement> etapes = driver.findElements(By.name("etapeName"));
        etapes.get(0).sendKeys(libelle);
    }

    public void ajouterEtapeSuivante(WebDriver driver, String libelle) {
        driver.findElement(By.id("etapeButtonPlus")).click();
        List<WebElement> etapes = driver.findElements(By.name("etapeName"));
        etapes.get(etapes.size() - 1).sendKeys(libelle);
    }

    public void enregistrerRecette(WebDriver driver) {
        driver.findElement(By.id("buttonCreer")).click();
    }

    public void verifieRecetteSousCategorieMenu(WebDriver driver, String libelleRecette, String libelleCategorie) {

        boolean result = false;

        try {
            WebElement categorie = driver.findElement(By.name(libelleCategorie));
            WebElement recette = categorie.findElement(By.name(libelleRecette));

            result = true;
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true, result);
    }
}
