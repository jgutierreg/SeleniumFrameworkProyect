package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GermanicaTestPage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GermanicaTestDefinitions {

    GermanicaTestPage germanicaTestPage = new GermanicaTestPage();
    private String user = "jon.gutierresz@duocuc.cl";
    private String pass = "admin";

    String context = null;


    @Given("me dirijo a la pagina de Germanica")
    public void navigateTo() {
        germanicaTestPage.navigateToGermanica();
    }

    @When("ingreso los datos de usuario: correo {string} clave {string}")
    public void inputCredentials(String user, String pass) {
        germanicaTestPage.sendKeysToInputEmail(user);
        germanicaTestPage.sendKeysToInputPass(pass);
    }

    @Then("hago click el boton recordar y luego iniciar sesion")
    public void clickToLogin() {
        germanicaTestPage.clickCheckBoxRemember();
        germanicaTestPage.clickBtnLogin();
    }

    @When("ingreso los datos de usuario con clave invalida {string}")
    public void inputCredentialsWithPassFail(String failPassword) {
        germanicaTestPage.sendKeysToInputEmail(user);
        germanicaTestPage.sendKeysToInputPass(failPassword);
    }

    @When("ingreso los datos de usuario con correo invalido {string}")
    public void inputCredentialsWithEMailFail(String failUser) {
        germanicaTestPage.sendKeysToInputEmail(failUser);
        germanicaTestPage.sendKeysToInputPass(pass);
    }



    @Given("me dirijo a la pagina de Germanica y inicio Sesion")
    public void navigateToUrlAndLogin() {
        navigateTo();
        germanicaTestPage.sendKeysToInputEmail(user);
        germanicaTestPage.sendKeysToInputPass(pass);
        germanicaTestPage.clickCheckBoxRemember();
        germanicaTestPage.clickBtnLogin();
    }

    @When("me dirijo al modulo {string}")
    public void navigateToModule(String modulo) {
        germanicaTestPage.clickToModule(modulo);
    }

    @Then("hago click sobre boton 'Agregar usuario'")
    public void clickBtnAnadirUsuario() {
        germanicaTestPage.clickBtnAddUser();
    }

    @And("creo un usuario con los siguientes datos:")
    public void crearUsuario(DataTable dataTable) {
        List<Map<String, String>> mapeoUsuario = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fila : mapeoUsuario) {
            String nombre = fila.get("Nombre");
            String correo = fila.get("Correo");
            String contrasena = fila.get("Contrasena");
            String rol = fila.get("Rol");
            String estado = fila.get("Estatus");
            germanicaTestPage.sendKeysToInputUserName(nombre);
            germanicaTestPage.sendKeysToInputEmail(correo);
            germanicaTestPage.sendKeysToInputPass(contrasena);
            germanicaTestPage.selectOptionOfDropdownRole(rol);
            germanicaTestPage.selectOptionOfDropdownStatus(estado);
            germanicaTestPage.clickBtnLogin();
            String correoAvalidar = germanicaTestPage.getTextEmailOfTableUsers();
            System.out.println(correoAvalidar);
            Assert.assertEquals(correo, correoAvalidar);
        }
    }

    @But("valido alerta por credenciales invalidas")
    public void validarAlerta() {
        Assert.assertTrue(germanicaTestPage.alertCredentialsIsVisible());
    }

    @Then("descargo el archivo tipo {string}")
    public void descargarArchivo(String tipoArchivo) {
        germanicaTestPage.clickBtnDownloadFileUsers(tipoArchivo);
    }

    @Then("hago click sobre el boton {string}")
    public void clickBtnTexto(String textoBoton) {
        germanicaTestPage.clickButton(textoBoton);
    }

    @And("ingreso datos: Descripcion {string} Precio {string}")
    public void inputDatosProductoNuevo(String description, String price) {
        germanicaTestPage.sendKeysInputTextAreaProduct(description);
        germanicaTestPage.sendKeysInputPriceProduct(price);
    }

    @Then("busco {string}")
    public String inputSearch(String texto) {
        germanicaTestPage.sendKeysInputSearch(texto);
        return context = texto;
    }

    @And("hago click en el boton de la tabla {string}")
    public void clickBtnTablaProductos(String boton) {
        if (germanicaTestPage.nameProductOfTable(context)) {
            germanicaTestPage.clickBtnTableProduct(boton);
        }
    }

    @And("creo nuevo contacto")
    public void crearContacto(DataTable dataTable) {
        List<Map<String, String>> mapeoContacto = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fila : mapeoContacto) {
            String cliente = fila.get("Cliente");
            String nombre = fila.get("Nombre");
            String correo = fila.get("Correo");
            String telefono = fila.get("Telefono");
            String anexo = fila.get("Anexo");
            germanicaTestPage.selectOptionOfDropdownCustomerContact(cliente);
            germanicaTestPage.sendKeysInputNameUserContact(nombre);
            germanicaTestPage.sendKeysInputEmailCustomerContact(correo);
            germanicaTestPage.sendKeysInputPhoneNumberContact(telefono);
            germanicaTestPage.sendKeysInputAnexContact(anexo);
        }
    }

    @And("hago click en la pestaña {string}")
    public void clickPestana(String text) {
        germanicaTestPage.clickBtnPestana(text);
    }

    @And("modifico el correo a {string}")
    public void cambiarCorreo(String correo){
        germanicaTestPage.sendKeysInputEmailCustomerContact(correo);
    }

    @And("valido que el dato {string} este en 1ra fila")
    public void textNameRowIsDisplayed(String nombre){
        germanicaTestPage.textNameRowIsDisplayed(nombre);
    }

    @And("hago click en el boton para ordenar por {string}")
        public void ordenarPor(String textBtn){
            germanicaTestPage.clickBtnOrder();
    }

    @And("creo nuevo cliente")
    public void crearCliente(DataTable dataTable) {
        List<Map<String, String>> mapeoContacto = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fila : mapeoContacto) {
            String rut = fila.get("Rut");
            String giro = fila.get("Giro");
            String razoSocial = fila.get("Razon social");
            String direccion = fila.get("Direccion");
            String region = fila.get("Region");
            String provincia = fila.get("Provincia");
            String comuna = fila.get("Comuna");
            String contacto1= fila.get("Contacto 1");
            String contacto2= fila.get("Contacto 2");
            String correo = fila.get("Correo");
            String telefono = fila.get("Telefono");
            String fax = fila.get("Fax");
            germanicaTestPage.sendKeysInputRutNewCustomer(rut);
            germanicaTestPage.selectOptionOfDropdownNewCustomerGiro(giro);
            germanicaTestPage.sendKeysInputRazonSocialNewCustomer(razoSocial);
            germanicaTestPage.sendKeysInputDireccionNewCustomer(direccion);
            germanicaTestPage.selectOptionOfDropdownNewCustomerRegion(region);
            germanicaTestPage.selectOptionOfDropdownNewCustomerProvincia(provincia);
            germanicaTestPage.selectOptionOfDropdownNewCustomerComuna(comuna);
            germanicaTestPage.sendKeysInputContactoNewCustomer(contacto1);
            germanicaTestPage.sendKeysInputContacto2NewCustomer(contacto2);
            germanicaTestPage.sendKeysInputEmailCustomerContact(correo);
            germanicaTestPage.sendKeysInputPhoneNumberContact(telefono);
            germanicaTestPage.sendKeysInputFaxNewCustomer(fax);

        }
    }
    @And("creo nueva cotizacion")
    public void crearCotizacion(DataTable dataTable) {
        List<Map<String, String>> mapeoContacto = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fila : mapeoContacto) {
            String fechaEmision = fila.get("Fecha emision");
            String fechaEntrega = fila.get("Fecha Entrega");
            String formaDePago = fila.get("Forma de pago");
            String producto = fila.get("Producto");
            String cantidad = fila.get("Cantidad");
            germanicaTestPage.sendKeysInputFechaEmision(fechaEmision);
            germanicaTestPage.sendKeysInputFechaEntrega(fechaEntrega);
            germanicaTestPage.selectOptionOfDropdownFormaPago(formaDePago);
            germanicaTestPage.clickButton("Agregar Producto");
            germanicaTestPage.selectOptionOfDropdownProducto(producto);
            germanicaTestPage.sendKeysInputCount(cantidad);
            germanicaTestPage.clickButton("Agregar");
            germanicaTestPage.clickBtnFinalizar();
        }
    }

    @And("agrego un producto {string} y la cantidad de {string}")
    public void agregarProducto(String producto, String cant){
        germanicaTestPage.selectOptionOfDropdownProducto(producto);
        germanicaTestPage.sendKeysInputCount(cant);
        germanicaTestPage.clickButton("Agregar");
        germanicaTestPage.clickButtonActualizar();
    }

    @And("ingreso nuevo IVA: {string}")
    public void ingresarNuevoIVa(String text){
        germanicaTestPage.sendKeysInputIva(text);
    }
}
