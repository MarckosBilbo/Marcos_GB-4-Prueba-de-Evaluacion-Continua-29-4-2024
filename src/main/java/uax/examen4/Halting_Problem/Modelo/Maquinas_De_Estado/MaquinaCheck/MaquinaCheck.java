package uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck;

import uax.examen4.Halting_Problem.Modelo.MaquinaGenerica;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle.MaquinaEnBucle;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene.MaquinaQueSeDetiene;


/**
 * Clase que implementa la interfaz MaquinaGenerica y proporciona una implementación concreta del método ejecutarSolicitud(Solicitud solicitud).
 * Esta clase recibe una máquina, determina si se detiene o entra en un bucle infinito basándose en el tipo de la máquina, y almacena ese estado.
 */
public class MaquinaCheck implements MaquinaGenerica {

    private MaquinaGenerica maquina;
    private EstadoMaquina estado;


    /**
     * Constructor de la clase MaquinaCheck.
     * @param maquina La máquina que se va a verificar si se detiene o entra en un bucle infinito.
     */
    public MaquinaCheck(MaquinaGenerica maquina) {
        this.maquina = maquina;
    }



    /**
     * Devuelve el estado de la máquina.
     * @return el estado de la máquina.
     */
    public EstadoMaquina getEstado() {
        return estado;
    }



    /**
     * Este método no se utiliza en esta clase ya que MaquinaCheck no delega responsabilidades a otras máquinas.
     * @param maquina La máquina a la que se delegaría la responsabilidad, si se utilizara este método.
     */
    @Override
    public void setNext(MaquinaGenerica maquina) {
        // Esta máquina no delega responsabilidades.
    }



    /**
     * Ejecuta la solicitud en la máquina proporcionada, determina si se detiene o entra en un bucle infinito basándose en el tipo de la máquina, y almacena ese estado.
     * @param solicitud la solicitud a ejecutar.
     */
    @Override
    public void ejecutarSolicitud(Solicitud solicitud) {

        // Ejecuta la solicitud en la máquina proporcionada
        maquina.ejecutarSolicitud(solicitud);

        // Determina estado 'Halting' o 'Looping' basándose en el tipo de la máquina
        if (maquina instanceof MaquinaQueSeDetiene) {
            estado = EstadoMaquina.SE_DETINE;
        } else if (maquina instanceof MaquinaEnBucle) {
            estado = EstadoMaquina.EN_BUCLE;
        }
    }

}