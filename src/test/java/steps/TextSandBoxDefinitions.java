package steps;
import io.cucumber.java.en.*;
import pages.TextSandBoxPage;
public class TextSandBoxDefinitions {

    TextSandBoxPage textSandBox =  new TextSandBoxPage();


    @Given("Voy a la pagina textSandBox")
    public void navigateToUrl(){
        textSandBox.navigateToSandBox();
    }

    @When("Elijo el modulo {string}")
        public void selectModule(String modulo){
            textSandBox.clickOpcion(modulo);
        }
}
