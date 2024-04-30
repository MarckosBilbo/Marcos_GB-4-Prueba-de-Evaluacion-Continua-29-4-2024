package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaFactory;


public class MaquinaDetieneFact implements MaquinaFactory {

    @Override
    public MaquinaGenerica crearMaquina() {
        return new MaquinaQueSeDetiene();
    }
}