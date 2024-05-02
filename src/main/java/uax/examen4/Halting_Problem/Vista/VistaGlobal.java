package uax.examen4.Halting_Problem.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uax.examen4.Halting_Problem.Controlador.ControladorGenerico;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck.EstadoMaquina;

import java.util.ArrayList;
import java.util.List;

public class VistaGlobal extends Application {

    private ControladorGenerico controlador = new ControladorGenerico();
    private List<Integer> numeros = new ArrayList<>();
    private Label display = new Label();

    @Override
    public void start(Stage primaryStage) {
        Button btnImprimirHora = new Button("Imprimir Hora");
        btnImprimirHora.setOnAction(event -> controlador.imprimirHora());

        Button btnOrdenamiento = new Button("Ordenamiento");
        btnOrdenamiento.setOnAction(event -> primaryStage.setScene(crearEscenaTeclado(primaryStage)));

        VBox rootInicial = new VBox(btnImprimirHora, btnOrdenamiento);
        Scene escenaInicial = new Scene(rootInicial, 300, 250);

        primaryStage.setTitle("Halting Problem");
        primaryStage.setScene(escenaInicial);
        primaryStage.show();
    }

    private Scene crearEscenaTeclado(Stage primaryStage) {
        // Crear la escena del teclado
        GridPane teclado = new GridPane();
        for (int i = 0; i < 10; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.setOnAction(event -> display.setText(btn.getText()));
            teclado.add(btn, i % 3, i / 3);
        }

        Button btnIntroducir = new Button("Introducir");
        btnIntroducir.setOnAction(event -> {
            numeros.add(Integer.parseInt(display.getText()));
            display.setText("");
        });

        Button btnOrdenar = new Button("Ordenar");
        btnOrdenar.setOnAction(event -> {
            controlador.ordenar(numeros);
            numeros.clear();
            primaryStage.setScene(crearEscenaVeredicto());
        });

        VBox rootTeclado = new VBox(display, teclado, btnIntroducir, btnOrdenar);
        return new Scene(rootTeclado, 300, 250);
    }

    private Scene crearEscenaVeredicto() {
        EstadoMaquina estado = controlador.obtenerVeredicto();
        Label label;
        if (estado == EstadoMaquina.SE_DETINE) {
            label = new Label("El programa se detiene");
        } else if (estado == EstadoMaquina.EN_BUCLE) {
            label = new Label("El programa entra en un bucle");
        } else {
            label = new Label("Estado desconocido");
        }
        VBox root = new VBox(label);
        return new Scene(root, 300, 250);
    }

    public static void main(String[] args) {
        launch(args);
    }
}