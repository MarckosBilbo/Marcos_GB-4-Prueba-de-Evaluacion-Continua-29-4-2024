package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle;


import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;


public class MaquinaEnBucle implements MaquinaGenerica {

    private MaquinaGenerica next;


    @Override
    public void setNext(MaquinaGenerica maquina) {
        this.next = maquina;
    }



    @Override
    public void ejecutarSolicitud(Solicitud solicitud) {
        if (solicitud.tipo() == TipoSolicitud.IMPRIMIR_HORA) {
            solicitud.ejecutar();
        } else if (next != null) {
            next.ejecutarSolicitud(solicitud);
        }
    }
}