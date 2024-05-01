package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaFactory;


/**
 * Clase que implementa la interfaz MaquinaFactory y proporciona una implementación concreta del método crearMaquina().
 * Esta clase crea una nueva MaquinaQueSeDetiene.
 */
public class MaquinaDetieneFact implements MaquinaFactory {


    /**
     * Crea una nueva instancia de MaquinaQueSeDetiene.
     * @return una nueva instancia de MaquinaQueSeDetiene.
     */
    @Override
    public MaquinaGenerica crearMaquina() {
        return new MaquinaQueSeDetiene();
    }

}