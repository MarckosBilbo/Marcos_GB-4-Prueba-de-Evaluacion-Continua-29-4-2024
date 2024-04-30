package uax.examen4.Halting_Problem.Modelo;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;


public class Solicitud {

    private TipoSolicitud tipo;
    private List<Integer> numeros;

    public Solicitud(TipoSolicitud tipo, List<Integer> numeros) {
        this.tipo = tipo;
        this.numeros = numeros;
    }



    public TipoSolicitud tipo() {
        return tipo;
    }



    public void ejecutar() {
        if (tipo == TipoSolicitud.ORDENAR) {
            ordenarNumeros();
        } else if (tipo == TipoSolicitud.IMPRIMIR_HORA) {
            ejecutarComoReloj();
        }
    }



    private void ordenarNumeros() {
        Collections.sort(numeros);
        System.out.println("Lista ordenada: " + numeros);
    }



    private void imprimirHora() {
        System.out.println(LocalTime.now());
    }



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