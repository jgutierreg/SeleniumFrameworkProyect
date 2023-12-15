package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {

    private String seachTextField = "//textarea[@id='APjFqb']";


    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

    public void enterSearchCriteria(String criteria) {
        write(seachTextField, criteria);
    }
}
