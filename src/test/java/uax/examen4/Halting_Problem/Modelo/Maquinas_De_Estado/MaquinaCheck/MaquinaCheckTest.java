package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle.MaquinaEnBucle;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene.MaquinaQueSeDetiene;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;

import java.util.Arrays;


/**
 * Clase de prueba para MaquinaCheck.
 * Se prueban los métodos ejecutarSolicitud con diferentes tipos de máquinas.
 */
public class MaquinaCheckTest {

    private MaquinaCheck maquinaCheck;
    private MaquinaGenerica maquinaQueSeDetiene;
    private MaquinaGenerica maquinaEnBucle;


    /**
     * Configuración inicial de las pruebas.
     * Se instancian las máquinas que se detienen y las que entran en bucle.
     */
    @BeforeEach
    public void setUp() {
        maquinaQueSeDetiene = new MaquinaQueSeDetiene();
        maquinaEnBucle = new MaquinaEnBucle();
    }



    /**
     * Prueba el método ejecutarSolicitud con una máquina que se detiene.
     * Se espera que el estado de la máquina sea SE_DETINE.
     */
    @Test
    public void testEjecutarSolicitud_MaquinaQueSeDetiene() {
        maquinaCheck = new MaquinaCheck(maquinaQueSeDetiene);
        maquinaCheck.ejecutarSolicitud(Solicitud.getInstance(TipoSolicitud.ORDENAR, Arrays.asList(3, 1, 2)));
        assertEquals(EstadoMaquina.SE_DETINE, maquinaCheck.getEstado());
    }



    /**
     * Prueba el método ejecutarSolicitud con una máquina que entra en bucle.
     * Se espera que el estado de la máquina sea EN_BUCLE.
     */
    @Test
    public void testEjecutarSolicitud_MaquinaEnBucle() {
        maquinaCheck = new MaquinaCheck(maquinaEnBucle);
        maquinaCheck.ejecutarSolicitud(Solicitud.getInstance(TipoSolicitud.IMPRIMIR_HORA, null));
        assertEquals(EstadoMaquina.EN_BUCLE, maquinaCheck.getEstado());
    }
}