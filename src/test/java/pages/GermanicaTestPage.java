package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class GermanicaTestPage extends BasePage {

    public GermanicaTestPage() {
        super(driver);}

    //Locators Login
    private String inputEmail= "//input[@id='email']";
    private String inputPassword = "//input[@id='password']";
    private  String alertCredentials = "//span[contains(@role,'alert')]";
    private String checkBoxRememberMe = "//input[@id='remember']";
    private String btnLogin = "//button[@type='submit']";
    String btnAgregarUsuario = "//button[@class='btn btn-outline-primary']";
    String dropdownRol= "//select[@id='role']";
    String dropdownStatus = "//select[@id='status']";
    String inputUserName = "//input[@id='name']";
    String emailUserCreated = "//table[contains(@id,'usuarios')]/tbody/tr[3]/td[2]";
    String inputAddProductTextArea ="//textarea[@id='descripcion']";
    String inputAddProductPrice = "//input[@id='precio']";
    String inputSearch = "//input[@type='search']";
    String dropdownCustomerForContact = "//select[@name='id_cliente']";
    String inputNameUserInModuleContact = "//input[contains(@id,'nombre')]";
    String inputPhoneNumber = "//input[@id='telefono']";
    String inputAnex="//input[@id='anexo']";
    String inputEmailCustomerContact="//input[@id='correo']";
    String orderForNameBtn = "(//th[@tabindex='0'])[2]";
    String inputRutNewCustomer = "//input[@id='rut']";
    String dropDownGiro = "//select[@id='giro']";
    String inputRazonSocial = "//input[@id='razon_social']";
    String inputDireccion = "//input[@id='direccion']";
    String dropDownRegion = "//select[@id='region_id_from']";
    String dropDownProvincia = "//select[@id='provincia_id_from']";
    String dropDownComuna = "//select[@id='comuna_id_from']";
    String inputContactoUno= "//input[@id='contacto1']";
    String inputContactoDos= "//input[@id='contacto2']";
    String inputFax = "//input[@id='fax']";
    String inputFechaEmision = "//input[@id='fecha_emision']";
    String inputFechaEntrega = "//input[@id='fecha_entrega']";
    String dropDownFormaDePago = "//select[contains(@id,'pago')]";
    String dropDownProducto = "//select[@id='producto']";
    String inputCount="//input[@id='cantidad']";
    String inputBtnFinalizar = "//input[@id='grabar']";
    String inputButtonActualizar="//input[@id='actualizar']";
    String inputIva ="//input[@id='iva']";



    //Locators BaseMenu

    public void navigateToGermanica() {navigateTo("http://germanica.test/");
    }
    //Iniciar Sesion
    public void sendKeysToInputEmail(String texto){
        write(inputEmail,texto);
    }
    public void sendKeysToInputPass(String texto){
        write(inputPassword,texto);
    }
    public void clickCheckBoxRemember(){
        clickElement(checkBoxRememberMe);
    }
    public void clickBtnLogin(){
        clickElement(btnLogin);
    }
    public void clickToModule(String modulo){
        clickElement("//a[@href='http://germanica.test/"+modulo+"']");
    }
    public void clickBtnAddUser(){
        clickElement(btnAgregarUsuario);
    }
    public void selectOptionOfDropdownRole(String text){
        selectFromDropDownByText(dropdownRol,text);
    }
    public void selectOptionOfDropdownStatus(String text){
        selectFromDropDownByText(dropdownStatus,text);
    }
    public void sendKeysToInputUserName(String texto){
        write(inputUserName,texto);
    }
    public String getTextEmailOfTableUsers() {
        WebElement correo = find(emailUserCreated);
        return correo.getText();
    }
    public boolean alertCredentialsIsVisible(){
        return find(alertCredentials).isDisplayed();
    }
    public void clickBtnDownloadFileUsers(String tipoArchivo){clickElement("//button[contains(.,'"+tipoArchivo+"')]");}
    public void clickButton(String textoBoton){clickElement("//button[contains(.,'"+textoBoton+"')]");}
    public void sendKeysInputTextAreaProduct(String texto){
        write(inputAddProductTextArea,texto);
    }
    public void sendKeysInputPriceProduct(String texto){
        write(inputAddProductPrice,texto);
    }
    public void sendKeysInputSearch(String texto){
        write(inputSearch,texto);
    }
    public void clickBtnTableProduct(String texto){clickElement("//a[contains(.,'"+texto+"')]");}
    public boolean nameProductOfTable(String texto){return find("//td[contains(.,'"+texto+"')]").isDisplayed();}
    public void selectOptionOfDropdownCustomerContact(String texto){selectFromDropDownByText(dropdownCustomerForContact,texto);}
    public void  sendKeysInputNameUserContact(String text){write(inputNameUserInModuleContact,text);}
    public void sendKeysInputEmailCustomerContact(String text){write(inputEmailCustomerContact,text);}
    public void  sendKeysInputPhoneNumberContact(String text){write(inputPhoneNumber,text);}
    public void  sendKeysInputAnexContact(String text){write(inputAnex,text);}
    public void clickBtnPestana(String text){clickElement("//a[contains(.,'"+text+"')]");}
    public void clickBtnOrder(){clickElement(orderForNameBtn);}
    public void textNameRowIsDisplayed(String text){find("//td[contains(.,'"+text+"')]").isDisplayed();}
    public void sendKeysInputRutNewCustomer(String text){write(inputRutNewCustomer,text);}
    public void selectOptionOfDropdownNewCustomerRegion(String texto){selectFromDropDownByText(dropDownRegion,texto);}
    public void selectOptionOfDropdownNewCustomerProvincia(String texto){selectFromDropDownByText(dropDownProvincia,texto);}
    public void selectOptionOfDropdownNewCustomerComuna(String texto){selectFromDropDownByText(dropDownComuna,texto);}
    public void selectOptionOfDropdownNewCustomerGiro(String texto){selectFromDropDownByText(dropDownGiro,texto);}
    public void sendKeysInputRazonSocialNewCustomer(String text){write(inputRazonSocial,text);}
    public void sendKeysInputDireccionNewCustomer(String text){write(inputDireccion,text);}
    public void sendKeysInputContactoNewCustomer(String text){write(inputContactoUno,text);}
    public void sendKeysInputContacto2NewCustomer(String text){write(inputContactoDos,text);}
    public void sendKeysInputFaxNewCustomer(String text){write(inputFax,text);}
    public void sendKeysInputFechaEmision(String text){write(inputFechaEmision,text);}
    public void sendKeysInputFechaEntrega(String text){write(inputFechaEntrega,text);}
    public void selectOptionOfDropdownFormaPago(String texto){selectFromDropDownByText(dropDownFormaDePago,texto);}
    public void selectOptionOfDropdownProducto(String texto){selectFromDropDownByText(dropDownProducto,texto);}
    public void sendKeysInputCount(String text){write(inputCount,text);}
    public void clickBtnFinalizar(){clickElement(inputBtnFinalizar);}
    public void clickButtonActualizar(){clickElement(inputButtonActualizar);}
    public void sendKeysInputIva(String text){write(inputIva,text);}

}
