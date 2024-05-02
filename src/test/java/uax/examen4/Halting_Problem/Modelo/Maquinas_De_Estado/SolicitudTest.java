package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;
import java.util.Arrays;


/**
 * Pruebas unitarias para la clase Solicitud.
 * Esta clase prueba que Solicitud ejecuta correctamente las solicitudes de tipo ORDENAR e IMPRIMIR_HORA.
 */
class SolicitudTest {


    /**
     * Prueba que Solicitud ejecuta correctamente una solicitud de tipo ORDENAR.
     */
    @Test
    void testEjecutarOrdenar() {
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.ORDENAR, Arrays.asList(3, 1, 2));
        solicitud.ejecutar();
        assertEquals(Arrays.asList(1, 2, 3), solicitud.getDatos());
    }



    /**
     * Prueba que Solicitud ejecuta correctamente una solicitud de tipo IMPRIMIR_HORA.
     */
    @Test
    void testEjecutarImprimirHora()throws InterruptedException {
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.IMPRIMIR_HORA, null);
        solicitud.ejecutar();

        // Espera a que el hilo termine antes de comprobar los datos de la solicitud
        Thread.sleep(50);
        assertNotNull(solicitud.getDatos());
    }
}