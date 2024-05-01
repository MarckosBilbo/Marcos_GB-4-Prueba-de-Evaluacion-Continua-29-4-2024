package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;

import org.junit.jupiter.api.Test;
import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Pruebas unitarias para la clase MaquinaBucleFact.
 * Esta clase prueba que MaquinaBucleFact crea correctamente una instancia de MaquinaEnBucle.
 */
public class MaquinaBucleFactTest {


    /**
     * Prueba que MaquinaBucleFact crea correctamente una instancia de MaquinaEnBucle.
     */
    @Test
    void testCrearMaquina() {
        MaquinaBucleFact factory = new MaquinaBucleFact();
        MaquinaGenerica maquina = factory.crearMaquina();
        assertTrue(maquina instanceof MaquinaEnBucle);
    }
}