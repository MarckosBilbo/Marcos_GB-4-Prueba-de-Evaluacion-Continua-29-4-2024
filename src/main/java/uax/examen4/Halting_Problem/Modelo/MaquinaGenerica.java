package uax.examen4.Halting_Problem.Modelo;


public interface MaquinaGenerica {

    void setNext(MaquinaGenerica maquina);
    void ejecutarSolicitud(Solicitud solicitud);
}