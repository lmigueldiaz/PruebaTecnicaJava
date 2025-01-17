@RegistrarUsuarios
Feature: Registrar usuario

  Background:
    Given Se ingresa a la url de test qa inlaze

  @RegistrarUsuarioExitoso
  Scenario Outline: Se valida el registro usuario
    When  Se ingresa al registro
    And   Se digitan los datos del registro name <name> email <email> pass <pass> rememberPass <rememberPass>
    And   Clic boton registrar
    Then  Se valida <mensajeRegistroExitoso> registro exitoso
    Examples:
      | name      | email                  | pass      | rememberPass | mensajeRegistroExitoso   |
      | Luis Diaz | lmigueldiazf@gmail.com | 16Ilanze* | 16Ilanze*    | Successful registration! |

  @RegistrarUsuarioFallido
  Scenario Outline: Se valida el registro usuario fallido
    When  Se ingresa al registro
    And   Se digitan los datos del registro name <name> email <email> pass <pass> rememberPass <rememberPass>
    Then  Se valida <mensajeRegistroFallido> registro fallido
    Examples:
      | name      | email                  | pass      | rememberPass | mensajeRegistroFallido |
      | Luis Diaz | lmigueldiazf@gmail.com | 16Ilanze* | 16Ilanze*1   | Passwords do not match |