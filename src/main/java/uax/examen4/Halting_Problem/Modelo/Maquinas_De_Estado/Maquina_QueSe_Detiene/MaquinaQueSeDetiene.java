package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;


import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;


public class MaquinaQueSeDetiene implements MaquinaGenerica {

    private MaquinaGenerica next;


    @Override
    public void setNext(MaquinaGenerica maquina) {
        this.next = maquina;
    }



    @Override
    public void ejecutarSolicitud(Solicitud solicitud) {
        if (solicitud.tipo() == TipoSolicitud.ORDENAR) {
            solicitud.ejecutar();
        } else if (next != null) {
            next.ejecutarSolicitud(solicitud);
        }
    }
}