@InicioDeSesion
Feature: Inicio de sesion
  Background:
    Given Se ingresa a la url de test qa inlaze

  @InicioDeSesionExitoso
  Scenario Outline: Se valida el inicio de sesion exitoso
    When  Se ingresa usuario y contrasena
    And   Se valida el <nombre> de usuario
    Then  Se valida el <mensaje> al iniciar sesion
    Examples:
      | mensaje          | nombre    |
      | Welcome to Lorem | Luis Diaz |

  @InicioDeSesionFallido
  Scenario Outline: Se valida el inicio de sesion fallido
    When  Se digita <usuario> y <contrasena>
    Then  Se valida el <mensajeSesionFallida> datos erroneos
    Examples:
      | usuario                  | contrasena | mensajeSesionFallida |
      | lmigueldiazf@yopmail.com | 16Ilanze*  | User not found       |

  @CerrarSesion
  Scenario Outline: Se valida el cierre de sesion exitoso
    When  Se ingresa usuario y contrasena
    And   Se valida el <mensaje> al iniciar sesion
    Then  Se cierra sesion
    Examples:
      | mensaje          |
      | Welcome to Lorem |