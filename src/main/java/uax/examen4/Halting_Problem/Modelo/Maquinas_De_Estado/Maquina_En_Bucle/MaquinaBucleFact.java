package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaFactory;


public class MaquinaBucleFact implements MaquinaFactory {

    @Override
    public MaquinaGenerica crearMaquina() {
        return new MaquinaEnBucle();
    }
}