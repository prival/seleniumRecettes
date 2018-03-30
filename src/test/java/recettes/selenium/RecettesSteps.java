package recettes.selenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import recettes.selenium.categorie.Categories;
import recettes.selenium.database.RecettesDb;
import recettes.selenium.recette.Recettes;

public class RecettesSteps {

    private Admin admin;
    private Categories categories;
    private Recettes recettes;
    private RecettesDb recettesDb;

    private WebDriver driver;

    public RecettesSteps() {
        driver = World.haveDriver();

        admin = new Admin();
        categories = new Categories();
        recettes = new Recettes();
        recettesDb = new RecettesDb();
    }

//    @Given("^toutes les categories supprimées$")
//    public void toutes_les_categories_supprimees() throws Throwable {
//
//        recettesDb.supprimeToutesCategories();
//    }

//    @Given("^l'utilisateur va sur l'application$")
//    public void l_utilisateur_va_sur_l_application() throws Throwable {
//
//        /** accès local */
//        driver.navigate().to("http://localhost:8080/index");
//    }

//    @Given("^il va sur l'admin$")
//    public void il__va_sur_l_admin() throws Throwable {
//
//        admin.goAdmin(driver);
//    }

//    @Given("^il se connecte en admin$")
//    public void il_se_connecte_en_admin() throws Throwable {
//
//        admin.login(driver);
//    }

    @Given("^toutes les recettes supprimées$")
    public void toutes_les_recettes_supprimees() throws Throwable {

        recettesDb.supprimeToutesRecettes();
    }


    @When("^l'admin choisit la categorie (.+)$")
    public void l_admin_choisit_la_categorie(String libelle) throws Throwable {

        recettes.choisirCategorie(driver, libelle);
    }

    @When("^l'admin ajoute le titre de recette (.+)$")
    public void l_admin_ajoute_le_titre_de_recette(String libelle) throws Throwable {

        recettes.ajouterTitre(driver, libelle);
    }

    @When("^l'admin ajoute l'ingredient (.+)$")
    public void l_admin_ajoute_l_ingredient(String libelle) throws Throwable {

        recettes.ajouterPremierIngredient(driver, libelle);
    }

    @When("^l'admin ajoute l'étape (.+)$")
    public void l_admin_ajoute_l_etape(String libelle) throws Throwable {

        recettes.ajouterPremiereEtape(driver, libelle);
    }

    @When("^l'admin enregistre la recette$")
    public void l_admin_enregistre_la_recette() throws Throwable {

        recettes.enregistrerRecette(driver);
    }

    @When("^il modifie la recette (.+) en (.+)$")
    public void il_modifie_la_recette(String oldLibelle, String newLibelle) throws Throwable {

        categories.modifierCategorie(driver, oldLibelle, newLibelle);
    }

    @When("^il supprime la recette (.+)$")
    public void il_supprime_la_recette(String libelle) throws Throwable {

        categories.supprimerCategorie(driver, libelle);
    }

    @Then("^la recette (.+) est enregistrée en base avec comme ordre (.+)$")
    public void la_recette_est_enregistree_en_base_avec_comme_ordre(String libelle, int ordre) throws Throwable {

        recettesDb.verifieCreationRecette(libelle, ordre);
    }

    @Then("^l'ingrédient (.+) est enregistré en base avec comme ordre (.+)$")
    public void l_ingredient_est_enregistre_en_base_avec_comme_ordre(String libelle, int ordre) throws Throwable {

        recettesDb.verifieCreationIngredient(libelle, ordre);
    }

    @Then("^l'étape (.+) est enregistrée en base avec comme ordre (.+)$")
    public void l_etape_est_enregistree_en_base_avec_comme_ordre(String libelle, int ordre) throws Throwable {

        recettesDb.verifieCreationEtape(libelle, ordre);
    }

    @Then("^la recette (.+) apparait dans le menu sous la categorie (.+)$")
    public void la_recette_est_affichee_dans_la_liste_des_resultats(String libelleRecette, String libelleCategorie) throws Throwable {
        recettes.verifieRecetteSousCategorieMenu(driver, libelleRecette, libelleCategorie);
    }

    @Then("^la recette (.+) est supprimée en base")
    public void la_recette_est_modifiee_en_base(String libelle) throws Throwable {

        recettesDb.verifieSuppressionCategorie(libelle);
    }

    @Then("^la recette (.+) est la première affichée dans le menu$")
    public void la_recette_est_la_premiere_affichee_dans_le_menu(String libelle) throws Throwable {

        categories.verifieCategoriePremiereDuMenu(driver, libelle);
    }

    @Then("^la recette (.+) n'est plus affichée dans le menu")
    public void la_recette_n_est_plus_affichee_dans_le_menu(String libelle) throws Throwable {

        categories.verifieCategorieAbsenteDuMenu(driver, libelle);
    }
}
