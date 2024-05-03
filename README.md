# Marcos_GB-4-Prueba-de-Evaluacion-Continua-29-4-2024

Repositorio --> https://github.com/MarckosBilbo/Marcos_GB-4-Prueba-de-Evaluacion-Continua-29-4-2024

### Patrones[Chain of Resposability/Factoy Method/Singelton]


# 1ºModelo:

El modelo de este proyecto está diseñado para simular el problema de la parada (Halting Problem) de Turing. El modelo consta de varias clases y paquetes que interactúan entre sí para simular este problema.

**[Modelo-->(])**

## -Paquete `uax.examen4.Halting_Problem.Modelo`

Este paquete contiene las clases principales que definen el comportamiento de las solicitudes y las máquinas.

### -Clase `TipoSolicitud`

Esta es una enumeración que representa los tipos de solicitudes que puede manejar la aplicación. Los tipos de solicitudes son:

- `ORDENAR`: Solicitud para ordenar una lista (MaquinaQueSeDetiene)
- `IMPRIMIR_HORA`: Solicitud para imprimir la hora actual (MaquinaEnBucle)

### -Clase `Solicitud`

Esta clase representa una solicitud que puede ser de tipo `ORDENAR` o `IMPRIMIR_HORA`. Tiene un método `ejecutar()` que ejecuta la acción correspondiente al tipo de solicitud. Esta clase implementa el patrón Singleton, lo que significa que solo puede existir una instancia de `Solicitud` en cualquier momento.

### -Interfaz `MaquinaGenerica`

Esta interfaz define los métodos que deben implementar las máquinas en la aplicación. Los métodos son:

- `setNext(MaquinaGenerica maquina)`: Establece la siguiente máquina en la cadena de responsabilidad.
- `ejecutarSolicitud(Solicitud solicitud)`: Ejecuta una solicitud.

## -Paquete `uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado`

Este paquete contiene las clases que definen el comportamiento de las máquinas de estado.

### -Interfaz `MaquinaFactory`

Esta interfaz define un método para crear una nueva máquina. El método es:

- `crearMaquina()`: Crea una nueva máquina.

### -Clases `MaquinaBucleFact` y `MaquinaDetieneFact`

Estas clases implementan la interfaz `MaquinaFactory` y proporcionan una implementación concreta del método `crearMaquina()`. `MaquinaBucleFact` crea una nueva `MaquinaEnBucle` y `MaquinaDetieneFact` crea una nueva `MaquinaQueSeDetiene`.

### -Clases `MaquinaEnBucle` y `MaquinaQueSeDetiene`

Estas clases implementan la interfaz `MaquinaGenerica` y proporcionan implementaciones concretas de los métodos `setNext(MaquinaGenerica maquina)` y `ejecutarSolicitud(Solicitud solicitud)`. `MaquinaEnBucle` ejecuta una solicitud si es de tipo `IMPRIMIR_HORA` y delega la solicitud a la siguiente máquina en la cadena si no lo es. `MaquinaQueSeDetiene` ejecuta una solicitud si es de tipo `ORDENAR` y delega la solicitud a la siguiente máquina en la cadena si no lo es.

### -Clase `MaquinaCheck`

Esta clase implementa la interfaz `MaquinaGenerica` y proporciona una implementación concreta del método `ejecutarSolicitud(Solicitud solicitud)`. Recibe una máquina, determina si se detiene o entra en un bucle infinito basándose en el tipo de la máquina, y almacena ese estado.

### -Enumeración `EstadoMaquina`

Esta enumeración representa los posibles estados de una máquina. Los estados son:

- `SE_DETINE`: Determina si la máquina se detiene
- `EN_BUCLE`: Determina si la máquina entra en un bucle infinito

Estas son las clases y paquetes principales que componen el modelo de este proyecto. Juntos, simulan el problema de la parada de Turing.




# 2ºControlador:

El controlador de este proyecto está diseñado para manejar las acciones de los botones y la lógica de la máquina de verificación. El controlador consta de una clase principal que define el comportamiento del controlador.

**[Controlador -->(])**

## -Clase `ControladorGenerico`

Esta clase maneja las acciones de los botones y la lógica de la máquina de verificación. Inicializa la máquina de verificación con una máquina que se detiene y establece la siguiente máquina en la cadena de responsabilidad como una máquina en bucle.

### -Método `ControladorGenerico()`

Este es el constructor de la clase `ControladorGenerico`. Inicializa la máquina de verificación con una máquina que se detiene y establece la siguiente máquina en la cadena de responsabilidad como una máquina en bucle.

### -Método `ordenar(List<Integer> numeros)`

Este método ordena una lista de números. Crea y ejecuta una solicitud de tipo `ORDENAR`.

### -Método `imprimirHora()`

Este método imprime la hora actual. Crea y ejecuta una solicitud de tipo `IMPRIMIR_HORA`.

### -Método `obtenerVeredicto()`

Este método obtiene el veredicto de la máquina de verificación.

Estos son los métodos principales que componen la clase `ControladorGenerico`. Juntos, manejan las acciones de los botones y la lógica de la máquina de verificación.




# 3ºVista:

La vista de este proyecto está diseñada para proporcionar una interfaz gráfica de usuario (GUI) para interactuar con el modelo. La vista consta de una clase principal que define la interfaz gráfica de usuario.

**[Vista -->(])**

## Clase `VistaGlobal`

Esta clase extiende la clase `Application` de JavaFX y proporciona la interfaz gráfica de usuario para el proyecto. La interfaz gráfica de usuario incluye botones para imprimir la hora, ordenar una lista de números y obtener el veredicto del problema de la parada.

### -Método `start(Stage primaryStage)`

Este método es el punto de entrada de la aplicación JavaFX. Configura la escena inicial de la aplicación, que incluye botones para imprimir la hora y ordenar una lista de números.

### -Método `crearEscenaTeclado(Stage primaryStage)`

Este método crea una escena que contiene un teclado numérico y botones para introducir números y ordenar la lista de números.

### -Método `crearEscenaListaOrdenada(Stage primaryStage)`

Este método crea una escena que muestra la lista de números ordenada y un botón para obtener el veredicto del problema de la parada.

### Método `crearEscenaVeredicto()`

Este método crea una escena que muestra el veredicto del problema de la parada y botones para cerrar la aplicación o volver al inicio.

### -Método `crearEscenaReloj()`

Este método crea una escena que muestra la hora actual y un botón para obtener el veredicto del problema de la parada.

### -Método `crearEscenaVeredictoReloj()`

Este método crea una escena que muestra un mensaje indicando que el programa nunca se detiene y proporciona botones para cerrar la aplicación o volver al inicio.

Estos son los métodos principales que componen la clase `VistaGlobal`. Juntos, proporcionan una interfaz gráfica de usuario para interactuar con el modelo y simular el problema de la parada de Turing.
