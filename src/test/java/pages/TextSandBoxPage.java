package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TextSandBoxPage extends BasePage{

    public TextSandBoxPage() {
        super(driver);
    }

    public void navigateToSandBox(){
        navigateTo("https://the-internet.herokuapp.com/");
    }

    public void clickOpcion(String text){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement modulo = driver.findElement(By.xpath("//a[contains(.,'"+text+"')]"));
        modulo.click();
    }

}
