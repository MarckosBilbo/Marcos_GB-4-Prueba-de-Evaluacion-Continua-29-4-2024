package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;


/**
 * Clase que implementa la interfaz MaquinaGenerica y proporciona implementaciones concretas de los métodos setNext(MaquinaGenerica maquina) y ejecutarSolicitud(Solicitud solicitud).
 * Esta clase ejecuta una solicitud si es de tipo ORDENAR y delega la solicitud a la siguiente máquina en la cadena si no lo es.
 */
public class MaquinaQueSeDetiene implements MaquinaGenerica {

    private MaquinaGenerica next;


    /**
     * Establece la siguiente máquina en la cadena de responsabilidad.
     * @param maquina la siguiente máquina.
     */
    @Override
    public void setNext(MaquinaGenerica maquina) {
        this.next = maquina;
    }



    /**
     * Ejecuta la solicitud si es de tipo ORDENAR, de lo contrario, delega la solicitud a la siguiente máquina en la cadena.
     * @param solicitud la solicitud a ejecutar.
     */
    @Override
    public void ejecutarSolicitud(Solicitud solicitud) {
        if (solicitud.tipo() == TipoSolicitud.ORDENAR) {
            solicitud.ejecutar();
        } else if (next != null) {
            next.ejecutarSolicitud(solicitud);
        }
    }
}