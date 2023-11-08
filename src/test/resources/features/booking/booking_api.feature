# language: es
Característica: Gestión de reservas API RESTFUL - BOOKER
  Yo, como usuario
  Necesito ingresar la información para mi estadia,
  Con el fin crear la reserva.

  Antecedentes:
    Dado que el usuario cargó la información de la URL

  Esquema del escenario: Creacion de reserva
    Dado que ingresa la información para la reserva: Nombre <firstname> y el Apellido <lastName>
    Y que ingresa la información de los costos: Precio Total <price>, Depósito abonado <depositPaid>
    Y que ingresa la información de las fechas de reserva: Fecha de llegada <checkin>, Fecha de Salida <checkout>
    Y que ingresa solicitudes adicionales: <additional>
    Y que ingresa el path: <path>
    Cuando ejecuta el servicio con la información necesaria para la reserva
    Entonces se genera una reserva

    Ejemplos:
      | firstname |  lastName |  price  |  depositPaid  |  checkin   |  checkout   | additional |  path    |
      |   Tom     |    Hans   |  654    |   true        | 2024-01-01 | 2024-01-05  |  Dinner    |  booking |
      |   Peter   |    Conor  |  300    |   true        | 2024-02-02 | 2024-02-03  |  Breakfast |  booking |
      |   Laura   |    Zapata |  844    |   true        | 2024-03-03 | 2024-03-04  |  laundry   |  booking |
      |   Andres  |    Arango |  105    |   true        | 2024-10-09 | 2024-11-11  |  lunch     |  booking |
      |   Paola   |    Chia   |  500    |   true        | 2024-10-10 | 2024-11-11  |  Other     |  booking |

  Esquema del escenario: Mostrar los ids de las reservas disponibles filtradas por parámetros
    Dado que filtra la búsqueda por Nombre <firstname> y Apellido <lastName>
    Y por fecha de ingreso <checkin> y fecha de salida <checkout>
    Y que ingresa el path: <path>
    Cuando ejecuta el servicio con los parámetros de reserva enviados
    Entonces se muestra los Ids de las reservas disponibles

    Ejemplos:
      |  firstname |  lastName |   checkin   |  checkout   |  path    |
      |   N/A      |    N/A    |    N/A      |    N/A      | booking  |
      |   Tom      |    Hans   |    N/A      |    N/A      | booking  |
      |   N/A      |    N/A    |  2024-01-01 | 2024-01-05  | booking  |
      |   Paola    |    Chia   |  2024-10-10 | 2024-11-11  | booking  |

  Esquema del escenario: Buscar una reserva por id
    Dado que realiza la búsqueda por el identificador de la reserva <ids>
    Cuando ejecuta el servicio con los parámetros de reserva enviados
    Entonces se muestra la información de la reserva

    Ejemplos:
      |   ids   |
      |   39    |
      |   41    |
      |   111   |
      |   567   |
      |   852   |
      |   1358  |
      |   2739  |

  Esquema del escenario: Actualizar completamente la información de una reserva por id
    Dado que realiza la búsqueda por el identificador de la reserva <ids>
    Y que ingresa la información para la reserva: Nombre <firstname> y el Apellido <lastName>
    Y que ingresa la información de los costos: Precio Total <price>, Depósito abonado <depositPaid>
    Y que ingresa la información de las fechas de reserva: Fecha de llegada <checkin>, Fecha de Salida <checkout>
    Y que ingresa solicitudes adicionales: <additional>
    Cuando ejecuta el servicio para modificar las reservas con los parámetros ingresados
    Entonces se actualiza la información de la reserva

    Ejemplos:
      |  ids  |  firstname |  lastName |  price  |  depositPaid  |  checkin   |  checkout   | additional |
      |   7   |    Jorge   |    Cano   |  200    |   true        | 2024-06-01 | 2024-07-07  |  Other     |
      |   41  |    Peter   |    Conor  |  450    |   true        | 2024-02-02 | 2024-02-08  |  Breakfast |
      |  1266 |    Luca    |    Lopez  |  800    |   true        | 2024-03-01 | 2024-03-05  |  Dinner    |
      |  2077 |    Stive   |    Ruiz   |  90     |   true        | 2024-10-02 | 2024-11-03  |  laundry   |

  Esquema del escenario: Actualizar parcialmente la información de una reserva por id
    Dado que realiza la búsqueda por el identificador de la reserva <ids>
    Y que ingresa la información para la reserva: Nombre <firstname> y el Apellido <lastName>
    Y que ingresa solicitudes adicionales: <additional>
    Cuando ejecuta el servicio para modificar parcialmente la reserva
    Entonces se actualiza la información de la reserva

    Ejemplos:
      |   ids  |  firstname |  lastName | additional |
      |   1107 |    Adrian  |   Arias   |  Lunch     |
      |   1053 |    Sofia   |   Vega    |  Other     |
      |   725  |    Pedro   |   Bull    |  Breakfast |
      |   15   |    Andres  |   Cadavid |  Dinner    |

  Esquema del escenario: Borrar una reserva por id
    Dado que se ingresa el identificador de la reserva <ids>
    Cuando ejecuta el servicio para borrar el registro
    Entonces se elimina el registro y la información de la reserva

    Ejemplos:
      |   ids   |
      |   224   |
      |   2011  |
      |   468   |
      |   3057  |
      |   1259  |