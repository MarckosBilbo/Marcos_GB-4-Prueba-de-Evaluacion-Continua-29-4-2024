package uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz;

/**
 * Clase NoNumbersIntroducedException que extiende de Exception.
 * Esta excepción se lanza cuando se intenta ordenar sin haber introducido ningún número.
 */
public class NoNumbersIntroducedException extends Exception {

    /**
     * Constructor de la clase NoNumbersIntroducedException.
     * @param message El mensaje de la excepción.
     */
    public NoNumbersIntroducedException(String message) {
        super(message);
    }

}