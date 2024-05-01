package uax.examen4.Halting_Problem.Modelo;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;


/**
 * Clase que representa una solicitud que puede ser de tipo ORDENAR o IMPRIMIR_HORA.
 * Esta clase tiene un método ejecutar() que ejecuta la acción correspondiente al tipo de solicitud.
 */
public class Solicitud {

    private TipoSolicitud tipo;
    private List<Integer> numeros;


    /**
     * Constructor de la clase Solicitud.
     * @param tipo El tipo de la solicitud.
     * @param numeros La lista de números a ordenar si el tipo de la solicitud es ORDENAR.
     */
    public Solicitud(TipoSolicitud tipo, List<Integer> numeros) {
        this.tipo = tipo;
        this.numeros = numeros;
    }



    /**
     * Devuelve el tipo de la solicitud.
     * @return El tipo de la solicitud.
     */
    public TipoSolicitud tipo() {
        return tipo;
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
     * Imprime la hora actual.
     */
    private void imprimirHora() {
        System.out.println(LocalTime.now());
    }



    /**
     * Inicia un hilo que imprime la hora actual cada segundo.
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