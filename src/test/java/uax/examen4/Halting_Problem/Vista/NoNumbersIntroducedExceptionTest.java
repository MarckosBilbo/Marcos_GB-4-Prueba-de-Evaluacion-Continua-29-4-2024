package uax.examen4.Halting_Problem.Vista;

import org.junit.jupiter.api.Test;
import uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz.NoNumbersIntroducedException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para NoNumbersIntroducedException.
 */
public class NoNumbersIntroducedExceptionTest {

    /**
     * Prueba que la excepción se lanza con el mensaje correcto.
     */
    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(NoNumbersIntroducedException.class, () -> {
            throw new NoNumbersIntroducedException("*No ha metido números aún*");
        });

        assertEquals("*No ha metido números aún*", exception.getMessage());
    }

}