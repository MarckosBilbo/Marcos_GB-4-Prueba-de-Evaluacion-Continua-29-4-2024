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
        Solicitud solicitud = new Solicitud(TipoSolicitud.ORDENAR, Arrays.asList(3, 1, 2));
        solicitud.ejecutar();
        assertEquals(Arrays.asList(1, 2, 3), solicitud.getDatos());
    }



    /**
     * Prueba que Solicitud ejecuta correctamente una solicitud de tipo IMPRIMIR_HORA.
     */
    @Test
    void testEjecutarImprimirHora() {
        Solicitud solicitud = new Solicitud(TipoSolicitud.IMPRIMIR_HORA, null);
        solicitud.ejecutar();
        assertNotNull(solicitud.getDatos());
    }
}