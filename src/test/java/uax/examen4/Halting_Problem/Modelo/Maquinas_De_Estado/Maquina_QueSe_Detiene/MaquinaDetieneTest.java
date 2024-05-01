package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;
import java.util.Arrays;


/**
 * Pruebas unitarias para la clase MaquinaQueSeDetiene.
 * Esta clase prueba que MaquinaQueSeDetiene ejecuta correctamente las solicitudes de tipo ORDENAR
 * y delega correctamente las solicitudes de otros tipos a la siguiente máquina en la cadena.
 */
public class MaquinaDetieneTest {


    /**
     * Prueba que MaquinaQueSeDetiene ejecuta correctamente una solicitud de tipo ORDENAR.
     */
    @Test
    void testEjecutarSolicitudOrdenar() {
        MaquinaQueSeDetiene maquina = new MaquinaQueSeDetiene();
        Solicitud solicitud = new Solicitud(TipoSolicitud.ORDENAR, Arrays.asList(3, 1, 2));
        maquina.ejecutarSolicitud(solicitud);
        assertEquals(Arrays.asList(1, 2, 3), solicitud.getDatos());
    }



    /**
     * Prueba que MaquinaQueSeDetiene delega correctamente una solicitud de tipo IMPRIMIR_HORA
     * a la siguiente máquina en la cadena.
     */
    @Test
    void testEjecutarSolicitudImprimirHora() {
        MaquinaQueSeDetiene maquina = new MaquinaQueSeDetiene();
        Solicitud solicitud = new Solicitud(TipoSolicitud.IMPRIMIR_HORA, null);
        maquina.ejecutarSolicitud(solicitud);
        assertNotNull(solicitud.getDatos());
    }
}