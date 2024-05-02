package uax.examen4.Halting_Problem.Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Clase que representa una solicitud que puede ser de tipo ORDENAR o IMPRIMIR_HORA.
 * Esta clase tiene un método ejecutar() que ejecuta la acción correspondiente al tipo de solicitud.
 */
public class Solicitud {

    private static Solicitud instance = null;

    private TipoSolicitud tipo;
    private List<Integer> numeros;


    /**
     * Constructor privado de la clase Solicitud.
     * Este constructor es privado como parte de la implementación del patrón Singleton.
     * Las instancias de esta clase deben obtenerse a través de los métodos getInstance().
     *
     * @param tipo El tipo de la solicitud.
     * @param numeros La lista de números a ordenar si el tipo de la solicitud es ORDENAR.
     */
    private Solicitud(TipoSolicitud tipo, List<Integer> numeros) {
        this.tipo = tipo;
        this.numeros = numeros;
    }



    /**
     * Devuelve la única instancia de Solicitud, creándola si es necesario.
     * Este método es parte del patrón Singleton y garantiza que solo exista una instancia de Solicitud.
     *
     * @param tipo El tipo de la solicitud.
     * @param numeros La lista de números a ordenar si el tipo de la solicitud es ORDENAR.
     * @return La única instancia de Solicitud.
     */
    public static Solicitud getInstance(TipoSolicitud tipo, List<Integer> numeros) {
        if (instance == null) {
            instance = new Solicitud(tipo, numeros);
        }
        return instance;
    }



    /**
     * Devuelve la única instancia de Solicitud, creándola si es necesario con valores predeterminados.
     * Este método es parte del patrón Singleton y garantiza que solo exista una instancia de Solicitud.
     * Si la instancia aún no ha sido creada, se creará una nueva instancia con TipoSolicitud.IMPRIMIR_HORA como tipo de solicitud y una lista vacía de números.
     *
     * @return La única instancia de Solicitud.
     */
    public static Solicitud getInstance() {
        if (instance == null) {
            instance = new Solicitud(TipoSolicitud.IMPRIMIR_HORA, new ArrayList<>());
        }
        return instance;
    }



    /**
     * Devuelve el tipo de la solicitud.
     * @return El tipo de la solicitud.
     */
    public TipoSolicitud tipo() {
        return tipo;
    }



    /**
     * Devuelve los datos procesados por la solicitud.
     * @return La lista de números ordenada si el tipo de la solicitud es ORDENAR.
     */
    public List<Integer> getDatos() {
        return numeros;
    }



    /**
     * Ejecuta la acción correspondiente al tipo de solicitud.
     */
    public void ejecutar() {
        if (tipo == TipoSolicitud.ORDENAR) {
            ordenarNumeros();
        } else if (tipo == TipoSolicitud.IMPRIMIR_HORA) {
            ejecutarComoReloj();
        }
    }



    /**
     * Ordena la lista de números y la imprime.
     */
    private void ordenarNumeros() {
        Collections.sort(numeros);
        System.out.println("Lista ordenada: " + numeros);
    }



    /**
     * Establece la hora actual como los datos de la solicitud almacenandola además.
     */
    private void imprimirHora() {
        LocalTime horaActual = LocalTime.now();
        this.numeros = Collections.singletonList(horaActual.getSecond());
    }



    /**
     * Inicia un hilo que establece y almacena la hora actual cada segundo.
     */
    public void ejecutarComoReloj() {
        if (tipo == TipoSolicitud.IMPRIMIR_HORA) {
            new Thread(() -> {
                while (true) {
                    imprimirHora();
                    try {
                        Thread.sleep(1000); // espera un segundo antes de la próxima actualización
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // restablece el estado interrumpido
                        break;
                    }
                }
            }).start();
        }
    }

}