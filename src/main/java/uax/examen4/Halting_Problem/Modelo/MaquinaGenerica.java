package uax.examen4.Halting_Problem.Modelo;


/**
 * Interfaz que define los métodos que deben implementar las máquinas en la aplicación.
 */
public interface MaquinaGenerica {


    /**
     * Establece la siguiente máquina en la cadena de responsabilidad.
     * @param maquina La siguiente máquina.
     */
    void setNext(MaquinaGenerica maquina);



    /**
     * Ejecuta una solicitud.
     * @param solicitud La solicitud a ejecutar.
     */
    void ejecutarSolicitud(Solicitud solicitud);

}