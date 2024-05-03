package uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz;

/**
 * Clase NoNumberSelectedException que extiende de Exception.
 * Esta excepción se lanza cuando se intenta introducir un número sin haber seleccionado uno.
 */
public class NoNumberSelectedException extends Exception {

    /**
     * Constructor de la clase NoNumberSelectedException.
     * @param message El mensaje de la excepción.
     */
    public NoNumberSelectedException(String message) {
        super(message);
    }

}