package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;


/**
 * Pruebas unitarias para la clase MaquinaEnBucle.
 * Esta clase prueba que MaquinaEnBucle ejecuta correctamente las solicitudes de tipo ORDENAR e IMPRIMIR_HORA.
 */
class MaquinaEnBucleTest {


    /**
     * Prueba que MaquinaEnBucle ejecuta correctamente una solicitud de tipo IMPRIMIR_HORA.
     */
    @Test
    void testEjecutarSolicitudImprimirHora() throws InterruptedException {
        MaquinaEnBucle maquina = new MaquinaEnBucle();
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.IMPRIMIR_HORA, null);
        maquina.ejecutarSolicitud(solicitud);

        // Espera a que el hilo termine antes de comprobar los datos de la solicitud
        Thread.sleep(50);
        assertNotNull(solicitud.getDatos());
    }
}