# language: es
Característica: Asignación de Token API RESTFUL - BOOKER
  Yo, como usuario
  Necesito ingresar mis credenciales, nombre de usuario y password
  Con el fin de obtener un token para realizar una reserva.

  Esquema del escenario: Asignación de token
    Dado que el usuario cargó la información de la URL
    Y que ingresa la información de las credenciales: Usuario <username>, contraseña <password> y el path <path>
    Cuando ejecuta el servicio con los párametros ingresados
    Entonces se visualiza el token

    Ejemplos:
      |  username  |  password   |  path  |
      |   admin    | password123 |  auth  |