


  Feature: Pruebas automatizadas de Sistema Germanica Test


    @testactual
    Scenario: CPA-003 Validar inicio de sesión exitosa
      Given me dirijo a la pagina de Germanica
      When ingreso los datos de usuario: correo "jon.gutierresz@duocuc.cl" clave "admin"
      Then hago click el boton recordar y luego iniciar sesion


    Scenario:  CPA-001 Validar agregar usuario con perfil vendedor
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "usuarios"
      Then hago click sobre boton 'Agregar usuario'
      And creo un usuario con los siguientes datos:
        | Nombre      | Correo                   | Contrasena | Rol       | Estatus  |
        | Elias Jaque | elias.jaque@gmail.com    | 123        | Vendedor  | Inactivo |

    Scenario:  CPA-002 Validar agregar usuario con perfil administrador
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "usuarios"
      Then hago click sobre boton 'Agregar usuario'
      And creo un usuario con los siguientes datos:
        | Nombre       | Correo                 | Contrasena | Rol            | Estatus  |
        | Elias Jaque  | elias.jaque@gmail.com  | 123        | Administrador  | Inactivo |

    Scenario: CPA-004 Validar inicio de sesión con contraseña invalida
      Given me dirijo a la pagina de Germanica
      When ingreso los datos de usuario: correo "jon.gutierresz@duocuc.cl" clave "admin123"
      Then hago click el boton recordar y luego iniciar sesion
      But valido alerta por credenciales invalidas

    Scenario: CPA-005 Validar inicio de sesión con correo invalido
      Given me dirijo a la pagina de Germanica
      When ingreso los datos de usuario: correo "eliecer.reyes@duocuc.cl" clave "admin"
      Then hago click el boton recordar y luego iniciar sesion
      But valido alerta por credenciales invalidas
    
    Scenario:  CPA-006 Descargar archivo excel con usuarios del sistema
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "usuarios"
      Then descargo el archivo tipo "Excel"

    Scenario:  CPA-007 Descargar archivo PDF con usuarios del sistema
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "usuarios"
      Then descargo el archivo tipo "PDF"

    Scenario:  CPA-008 Descargar archivo CSV con usuarios del sistema
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "usuarios"
      Then descargo el archivo tipo "CSV"

    Scenario:  CPA-009 Validar que se permita añadir un producto
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "productos"
      Then hago click sobre el boton "Agregar producto"
      And ingreso datos: Descripcion "Caja de destornilladores dewalt" Precio "25000"
      And hago click sobre el boton "Crear"

    Scenario:  CPA-010 Validar que se permita editar un producto
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "productos"
      Then busco "Prueba de edicion auto"
      And hago click en el boton de la tabla "Editar"
      And ingreso datos: Descripcion "Prueba de edicion" Precio "350000"
      And hago click sobre el boton "Actualizar"

    Scenario: CPA-011 Validar que se permita descargar archivo pdf con productos en sistema
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "productos"
      Then descargo el archivo tipo "PDF"

    Scenario: CPA-017 Agregar contacto
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "contactos"
      Then hago click sobre el boton "Agregar contacto"
      And creo nuevo contacto
        | Cliente                  | Nombre               | Correo                 | Telefono          | Anexo    |
        | SABEL MOMBERG ASTUDILLO  | ContactoAutomatizado | correo@email.cl        | +5691234567       | 10000    |
      And hago click sobre el boton "Grabar"


    Scenario: CPA-013 Eliminar un contacto de un cliente
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "clientes"
      Then busco "SABEL MOMBERG ASTUDILLO"
      And hago click en el boton de la tabla "Ver"
      And hago click en la pestaña "CONTACTOS"
      And busco "ContactoAutomatizado"
      And hago click en el boton de la tabla "Eliminar"

      Scenario: CPA-014 Editar un contacto de un cliente
        Given me dirijo a la pagina de Germanica y inicio Sesion
        When me dirijo al modulo "clientes"
        Then busco "SABEL MOMBERG ASTUDILLO"
        And hago click en el boton de la tabla "Editar"
        And modifico el correo a "maquinasima@hotmail.com"
        And hago click sobre el boton "Grabar"

    Scenario: CPA-015 Visualizar clientes solo por nombre
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "clientes"
      Then valido que el dato "XTREME MINING LTDA." este en 1ra fila
      And hago click en el boton para ordenar por "NOMBRE"
      And valido que el dato "12" este en 1ra fila
      And hago click en el boton para ordenar por "NOMBRE"

    Scenario: CPA-016 Visualizar clientes solo por Rut
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "clientes"
      Then valido que el dato "00.000.000-0" este en 1ra fila
      And hago click en el boton para ordenar por "RUT"
      And valido que el dato "qw" este en 1ra fila
      And hago click en el boton para ordenar por "RUT"

    Scenario: CPA-012 Agregar cliente
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "clientes"
      Then hago click sobre el boton "Agregar cliente"
      And creo nuevo cliente
      |Rut          |Giro |Razon social  |Direccion  |Region|Provincia|Comuna|Contacto 1|Contacto 2|Correo       |Telefono |Fax |
      |42141244-5   |Hotel|Automatizacion|Pasaje Auto|Maule |Talca    |Talca |91234567  |91234567  |auto@gmail.cl|123456788|5023|
      And hago click sobre el boton "Grabar"

    Scenario: CPA-018 Editar contacto
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "contactos"
      Then busco "CARLOS HERRERA"
      And hago click en el boton de la tabla "Editar"
      And modifico el correo a "Contrerasbeatriz3@gmail.com"
      And hago click sobre el boton "Grabar"

    Scenario: CPA-019 Crear nueva cotización
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "cotizaciones"
      Then hago click sobre el boton "Crear cotización"
      And busco "AUTOMATIZACION Y TECNOLOGIA INDUSTRIAL SPA"
      And hago click en el boton de la tabla "Crear"
      And creo nueva cotizacion
      |Fecha emision|Fecha Entrega|Forma de pago|Producto                 |Cantidad|
      |10-02-2023   | 10-10-2023  |CONTADO      |EJE CENTRAL BETONMAC 10".| 1      |

    Scenario: CPA-020 Editar cotización
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "cotizaciones"
      #Se realizara la busqueda por orden de Cotizacion
      Then busco "3905"
      And hago click en el boton de la tabla "Editar"
      And hago click sobre el boton "Agregar Producto"
      And agrego un producto "VALVULA MARIPOSA MODELO WAFER 10 CON CAJA DE ENGRANAJE Y VOLANTE." y la cantidad de "2"

    Scenario: CPA-021 Descargar cotización en Excel
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "cotizaciones"
      Then descargo el archivo tipo "Excel"

    Scenario: CPA-023 Descargar cotización en PDF
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "cotizaciones"
      Then descargo el archivo tipo "PDF"

    Scenario: CPA-022 Actualizar IVA
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "iva"
      Then hago click sobre el boton "Actualizar"
      And ingreso nuevo IVA: "20"
      And hago click sobre el boton "Actualizar"

    Scenario: CPA-024 Descargar contactos en Excel
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "contactos"
      Then descargo el archivo tipo "Excel"

    Scenario: CPA-025 Descargar contactos en PDF
      Given me dirijo a la pagina de Germanica y inicio Sesion
      When me dirijo al modulo "contactos"
      Then descargo el archivo tipo "PDF"














      






