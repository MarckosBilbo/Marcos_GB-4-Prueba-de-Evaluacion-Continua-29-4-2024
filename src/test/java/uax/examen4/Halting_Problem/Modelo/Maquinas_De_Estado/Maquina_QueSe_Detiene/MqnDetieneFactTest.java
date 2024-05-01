package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;

import org.junit.jupiter.api.Test;
import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Pruebas unitarias para la clase MaquinaDetieneFact.
 * Esta clase prueba que MaquinaDetieneFact crea correctamente una instancia de MaquinaQueSeDetiene.
 */
public class MqnDetieneFactTest {


    /**
     * Prueba que MaquinaDetieneFact crea correctamente una instancia de MaquinaQueSeDetiene.
     */
    @Test
    void testCrearMaquina() {
        MaquinaDetieneFact factory = new MaquinaDetieneFact();
        MaquinaGenerica maquina = factory.crearMaquina();
        assertTrue(maquina instanceof MaquinaQueSeDetiene);
    }
}