package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;
import java.util.Arrays;


/**
 * Pruebas unitarias para la clase MaquinaEnBucle.
 * Esta clase prueba que MaquinaEnBucle ejecuta correctamente las solicitudes de tipo ORDENAR e IMPRIMIR_HORA.
 */
class MaquinaEnBucleTest {


    /**
     * Prueba que MaquinaEnBucle ejecuta correctamente una solicitud de tipo IMPRIMIR_HORA.
     */
    @Test
    void testEjecutarSolicitudImprimirHora() {
        MaquinaEnBucle maquina = new MaquinaEnBucle();
        Solicitud solicitud = new Solicitud(TipoSolicitud.IMPRIMIR_HORA, null);
        maquina.ejecutarSolicitud(solicitud);
        assertNotNull(solicitud.getDatos());
    }



    /**
     * Prueba que MaquinaEnBucle ejecuta correctamente una solicitud de tipo ORDENAR.
     */
    @Test
    void testEjecutarSolicitudOrdenar() {
        MaquinaEnBucle maquina = new MaquinaEnBucle();
        Solicitud solicitud = new Solicitud(TipoSolicitud.ORDENAR, Arrays.asList(3, 1, 2));
        maquina.ejecutarSolicitud(solicitud);
        assertEquals(Arrays.asList(1, 2, 3), solicitud.getDatos());
    }
}