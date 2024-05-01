package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaFactory;


/**
 * Clase que implementa la interfaz MaquinaFactory y proporciona una implementación concreta del método crearMaquina().
 * Esta clase crea una nueva MaquinaEnBucle.
 */
public class MaquinaBucleFact implements MaquinaFactory {


    /**
     * Crea una nueva instancia de MaquinaEnBucle.
     * @return una nueva instancia de MaquinaEnBucle.
     */
    @Override
    public MaquinaGenerica crearMaquina() {
        return new MaquinaEnBucle();
    }

}