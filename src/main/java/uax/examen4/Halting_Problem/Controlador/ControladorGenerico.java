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


public class ControladorGenerico {

    @FXML
    private Button botonOrdenar;

    @FXML
    private Button botonImprimirHora;

    private MaquinaCheck maquinaCheck;


    public ControladorGenerico() {
        // Inicializa la máquina de verificación con una máquina que se detiene
        maquinaCheck = new MaquinaCheck(new MaquinaQueSeDetiene());
        // Establece la siguiente máquina en la cadena de responsabilidad como una máquina en bucle
        maquinaCheck.setNext(new MaquinaEnBucle());
    }



    @FXML
    public void ordenar(List<Integer> numeros) {
        // Crea y ejecuta una solicitud de tipo ORDENAR
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.ORDENAR, numeros);
        maquinaCheck.ejecutarSolicitud(solicitud);
        // Aquí puedes actualizar la vista en base al estado de la máquina
    }



    @FXML
    public void imprimirHora() {
        // Crea y ejecuta una solicitud de tipo IMPRIMIR_HORA
        Solicitud solicitud = Solicitud.getInstance(TipoSolicitud.IMPRIMIR_HORA, null);
        maquinaCheck.ejecutarSolicitud(solicitud);
        // Aquí puedes actualizar la vista en base al estado de la máquina
    }



    public EstadoMaquina obtenerVeredicto() {
        return maquinaCheck.getEstado();
    }
}