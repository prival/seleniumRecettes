package recettes.selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {
//                "src/test/resources/recettes/selenium/categories.feature",
                "src/test/resources/recettes/selenium/recettes.feature",
        }
)
public class MainTest {

}
