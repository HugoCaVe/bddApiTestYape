# language: es
Característica: Comprobación de estado de API RESTFUL - BOOKER
  Yo, como usuario
  Necesito verificar el estado actual de la Api https://restful-booker.herokuapp.com
  Con el fin de poder probar la comunicación y recepción de peticiones del servidor.

  Escenario: Vericar el estado actual de la API
    Dado que el usuario cargó la información de la URL
    Y que ingresa el path ping
    Cuando envía el servicio con los párametros para el diagnóstico
    Entonces se muestra la respuesta en el API 201