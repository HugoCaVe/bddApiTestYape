# bddApiTestYape
Reto de automatización de API para Yape

## Introducción 🚀

Pruebas automatizadas a los servicios web en la aplicación de reservas RESTFUL - BOOKER.

## Plan de Pruebas
1- Se diseñaron varios escenarios para cada uno de las funcionalidades, mediante "Examples" se agregó más cobertura y repeticiones del mismo escenario con Data variada, de está forma se logra  cubrir una gran cantidad de escenarios Happy Paths y UnHappy Paths.

2- Se logró una gran cobertura de pruebas, ya que los escenarios permiten modificar la gran mayoría de la información de entrada, con la que se obtiene un resultado esperado a nivel de respuesta “CODE” y como de Data.

3- Las herramientas y técnicas utilizadas para realizar la automatización de la funcionalidad se describen a continuación:

## Prerequisitos para la ejecución 📋

Java version 1.8, update 361 or higher and JDK (set of environment variables).
IntelliJ IDEA (version 2023 or higher).
Gradle version 8.0 or higher (set of environment variables).
Cucumber for Java Plugin (updated version).
Gherkin plugin (updated version).

## Instalación 🔧

Para clonar este repositorio localmente, se debe ejecutar el siguiente comando: git clone https://github.com/HugoCaVe/bddApiTestYape
IntelliJ IDE bajo la estructura de un proyecto Gradle existente.
Configurar la librería del sistema JRE con JavaSE-1.8.

## Compilar el proyecto 🔨

Para construir el proyecto se debe ejecutar el comando: gradle clean build -x test

## Comando para la ejecución 💻

El proyecto se puede ejecutar desde la consola con el siguiente comando: gradle clean test aggregate

## Construido con 🛠

BDD - Development strategy
Screenplay
Gradle - Dependency manager
Cucumber - Framework to automate BDD tests
Serenity BDD - Open source library for report generation
Gherkin - Business Readable DSL Language (Business-readable domain specific language)

## Versionamiento 📌

Se utilizó Git para el control de versiones 🔀

## Autor 👨

Hugo Cardenas - hugolp8@gmail.com
