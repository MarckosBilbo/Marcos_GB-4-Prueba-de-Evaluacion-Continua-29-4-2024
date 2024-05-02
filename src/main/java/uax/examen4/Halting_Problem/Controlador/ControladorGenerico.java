package uax.examen4.Halting_Problem.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck.EstadoMaquina;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Modelo.TipoSolicitud;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck.MaquinaCheck;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_En_Bucle.MaquinaEnBucle;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.Maquina_QueSe_Detiene.MaquinaQueSeDetiene;
import java.util.List;


/**
 * Controlador genérico para la aplicación.
 * Este controlador maneja las acciones de los botones y la lógica de la máquina de verificación.
 */
public class ControladorGenerico {

    @FXML
    private Button botonOrdenar;

    @FXML
    private Button botonImprimirHora;

    private MaquinaCheck maquinaCheck;


    /**
     * Constructor del controlador genérico.
     * Inicializa la máquina de verificación con una máquina que se detiene y establece la siguiente máquina en la cadena de responsabilidad como una máquina en bucle.
     */
    public ControladorGenerico() {
        maquinaCheck = new MaquinaCheck(new MaquinaQueSeDetiene());
        maquinaCheck.setNext(new MaquinaEnBucle());
    }



    /**
     * Ordena una lista de números.
     * Crea y ejecuta una solicitud de tipo ORDENAR.
     * @param numeros La lista de números a ordenar.
     */
    @FXML
    public void ordenar(List<Integer> numeros) {
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.ORDENAR, numeros);
        maquinaCheck.ejecutarSolicitud(solicitud);
    }



    /**
     * Imprime la hora actual.
     * Crea y ejecuta una solicitud de tipo IMPRIMIR_HORA.
     */
    @FXML
    public void imprimirHora() {
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.IMPRIMIR_HORA, null);
        maquinaCheck.ejecutarSolicitud(solicitud);
    }



    /**
     * Obtiene el veredicto de la máquina de verificación.
     * @return El estado de la máquina de verificación.
     */
    public EstadoMaquina obtenerVeredicto() {
        return maquinaCheck.getEstado();
    }
}