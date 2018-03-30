package recettes.selenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import recettes.selenium.categorie.Categories;
import recettes.selenium.database.RecettesDb;

public class CategoriesSteps {

    private Admin admin;
    private Categories categories;
    private RecettesDb recettesDb;

    private WebDriver driver;

    public CategoriesSteps() {
        driver = World.haveDriver();

        admin = new Admin();
        categories = new Categories();
        recettesDb = new RecettesDb();
    }

    @Given("^toutes les categories supprimées$")
    public void toutes_les_categories_supprimees() throws Throwable {

        recettesDb.supprimeToutesCategories();
    }

    @Given("^l'utilisateur va sur l'application$")
    public void l_utilisateur_va_sur_l_application() throws Throwable {

        /** accès local */
        driver.navigate().to("http://localhost:8080/index");
    }

    @Given("^il va sur l'admin$")
    public void il__va_sur_l_admin() throws Throwable {

        admin.goAdmin(driver);
    }

    @Given("^il se connecte en admin$")
    public void il_se_connecte_en_admin() throws Throwable {

        admin.login(driver);
    }

    @Given("^l'admin va sur la gestion des catégories$")
    public void l_admin_va_sur_la_gestion_des_categories() throws Throwable {

        categories.goGestionCategories(driver);
    }

    @When("^il créé la catégorie (.+)$")
    public void il_cree_la_categorie_categorie(String libelle) throws Throwable {

        categories.creerCategorie(driver, libelle);
    }

    @When("^il modifie la categorie (.+) en (.+)$")
    public void il_modifie_la_categorie(String oldLibelle, String newLibelle) throws Throwable {

        categories.modifierCategorie(driver, oldLibelle, newLibelle);
    }

    @When("^il supprime la catégorie (.+)$")
    public void il_supprime_la_categorie(String libelle) throws Throwable {

        categories.supprimerCategorie(driver, libelle);
    }

    @Then("^la catégorie (.+) est enregistrée en base avec comme ordre (.+)$")
    public void la_categorie_est_enregistree_en_base(String libelle, int ordre) throws Throwable {

        recettesDb.verifieCreationCategorie(libelle, ordre);
    }

    @Then("^la categorie (.+) est supprimée en base")
    public void la_categorie_est_modifiee_en_base(String libelle) throws Throwable {

        recettesDb.verifieSuppressionCategorie(libelle);
    }

    @Then("^la categorie (.+) est affichée dans la liste des résultats$")
    public void la_categorie_est_affichee_dans_la_liste_des_resultats(String libelle) throws Throwable {
        admin.goAdmin(driver);
        categories.goGestionCategories(driver);
        categories.verifieCategoriePresente(driver, libelle);
    }

    @Then("^la categorie (.+) est la première affichée dans le menu$")
    public void la_categorie_est_la_premiere_affichee_dans_le_menu(String libelle) throws Throwable {

        categories.verifieCategoriePremiereDuMenu(driver, libelle);
    }

    @Then("^la catégorie (.+) n'est plus affichée dans le menu")
    public void la_categorie_n_est_plus_affichee_dans_le_menu(String libelle) throws Throwable {

        categories.verifieCategorieAbsenteDuMenu(driver, libelle);
    }
}
