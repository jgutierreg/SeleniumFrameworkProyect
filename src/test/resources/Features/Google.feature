
Feature: Probar busqueda en Google

Scenario: Busco algo en google
  Given Voy a google
  When busco "Chile"
  Then Obtengo resultados
