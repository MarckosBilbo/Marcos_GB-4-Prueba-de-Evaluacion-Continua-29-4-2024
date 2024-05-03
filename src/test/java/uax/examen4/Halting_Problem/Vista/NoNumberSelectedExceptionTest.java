package uax.examen4.Halting_Problem.Vista;

import org.junit.jupiter.api.Test;
import uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz.NoNumberSelectedException;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Clase de prueba para NoNumberSelectedException.
 */
public class NoNumberSelectedExceptionTest {

    /**
     * Prueba que la excepción se lanza con el mensaje correcto.
     */
    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(NoNumberSelectedException.class, () -> {
            throw new NoNumberSelectedException("*Debe elegir un número antes de introducir*");
        });

        assertEquals("*Debe elegir un número antes de introducir*", exception.getMessage());
    }

}