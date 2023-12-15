package steps;


import io.cucumber.java.en.*;
import pages.GooglePage;


public class GoogleDefinitions {

    GooglePage google = new GooglePage();


    @Given("Voy a google")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("busco en google{string}")
    public void enterSearchCriteria(String texto){
        google.enterSearchCriteria(texto);
    }
    @Then("Obtengo resultados")
    public void validateResults(){

    }
}
