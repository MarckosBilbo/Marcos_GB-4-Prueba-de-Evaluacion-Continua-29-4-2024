package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;


/**
 * Interfaz que define un método para crear una nueva máquina.
 */
public interface MaquinaFactory {


    /**
     * Crea una nueva máquina.
     * @return La nueva máquina.
     */
    MaquinaGenerica crearMaquina();

}