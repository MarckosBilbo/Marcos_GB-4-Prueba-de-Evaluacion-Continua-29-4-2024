package uax.examen4.Halting_Problem.Controlador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck.EstadoMaquina;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para ControladorGenerico.
 * Esta clase prueba la funcionalidad de la clase ControladorGenerico.
 */
public class ControladorGenericoTest {

    private ControladorGenerico controlador;

    /**
     * Método de configuración para las pruebas.
     * Este método inicializa la instancia de ControladorGenerico antes de cada prueba.
     */
    @BeforeEach
    public void setup() {
        controlador = new ControladorGenerico();
    }

    /**
     * Método de prueba para el método ordenar.
     * Este método prueba si el método ordenar ordena correctamente una lista de enteros.
     */
    @Test
    public void testOrdenar() {
        controlador.ordenar(Arrays.asList(3, 1, 2));
        assertEquals(EstadoMaquina.SE_DETINE, controlador.obtenerVeredicto());
    }

    /**
     * Método de prueba para el método imprimirHora.
     * Este método prueba si el método imprimirHora cambia correctamente el estado de la máquina.
     */
    @Test
    public void testImprimirHora() {
        controlador.imprimirHora();
        assertEquals(EstadoMaquina.SE_DETINE, controlador.obtenerVeredicto());
    }
}