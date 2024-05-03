package uax.examen4.Halting_Problem.Vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import uax.examen4.Halting_Problem.Controlador.ControladorGenerico;
import uax.examen4.Halting_Problem.Modelo.Maquinas_De_Estado.MaquinaCheck.EstadoMaquina;
import uax.examen4.Halting_Problem.Modelo.Solicitud;
import uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz.NoNumberSelectedException;
import uax.examen4.Halting_Problem.Vista.ExcepcionesInterfaz.NoNumbersIntroducedException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/**
 * Clase VistaGlobal que extiende de Application.
 * Esta clase se encarga de la interfaz gráfica de la aplicación.
 */
public class VistaGlobal extends Application {

    private ControladorGenerico controlador = new ControladorGenerico();
    private List<Integer> numeros = new ArrayList<>();
    private Label display = new Label();
    private Solicitud solicitud = Solicitud.getInstance();



    /**
     * Método start que se ejecuta al iniciar la aplicación.
     * @param primaryStage El escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        Button btnImprimirHora = new Button("Imprimir Hora");
        btnImprimirHora.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 103px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnImprimirHora.setOnMouseEntered(event -> btnImprimirHora.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 103px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnImprimirHora.setOnMouseExited(event -> btnImprimirHora.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 103px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnImprimirHora.setMaxHeight(Double.MAX_VALUE);
        btnImprimirHora.setOnAction(event -> {
            solicitud.ejecutarComoReloj();
            primaryStage.setScene(crearEscenaReloj());
        });

        Button btnOrdenamiento = new Button("Ordenamiento");
        btnOrdenamiento.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnOrdenamiento.setOnMouseEntered(event -> btnOrdenamiento.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnOrdenamiento.setOnMouseExited(event -> btnOrdenamiento.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnOrdenamiento.setMaxHeight(Double.MAX_VALUE);
        btnOrdenamiento.setOnAction(event -> primaryStage.setScene(crearEscenaTeclado(primaryStage)));

        VBox rootInicial = new VBox(btnImprimirHora, btnOrdenamiento);
        rootInicial.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        rootInicial.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaInicial = new Scene(rootInicial, 850, 700);

        primaryStage.setTitle("Halting Problem");
        primaryStage.setScene(escenaInicial);
        primaryStage.show();
    }



    /**
     * Método para crear la escena del teclado.
     * @param primaryStage El escenario principal de la aplicación.
     * @return La escena creada.
     */
    private Scene crearEscenaTeclado(Stage primaryStage) {
        GridPane teclado = new GridPane();
        for (int i = 0; i < 10; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 35px; -fx-border-color: black;");
            btn.setOnAction(event -> {
                display.setText(btn.getText());
                display.setStyle("-fx-font-size: 50px; -fx-text-fill: #333;");
            });
            teclado.add(btn, i % 10, i /10);
            teclado.setAlignment(Pos.CENTER);
        }

        Button btnIntroducir = new Button("Introducir");
        btnIntroducir.setStyle("-fx-background-color: Black; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnIntroducir.setOnMouseEntered(event -> btnIntroducir.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnIntroducir.setOnMouseExited(event -> btnIntroducir.setStyle("-fx-background-color: Black; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnIntroducir.setOnAction(event -> {
            try {
                if (display.getText().isEmpty()) {
                    throw new NoNumberSelectedException("*Debe elegir un número antes de introducir*");
                }
                numeros.add(Integer.parseInt(display.getText()));
                display.setText("");
            } catch (NoNumberSelectedException e) {
                // Mostrar el mensaje de la excepción en la interfaz
                display.setText(e.getMessage());
                display.setStyle("-fx-font-size: 40px; -fx-text-fill: red;");
            }
        });

        Button btnOrdenar = new Button("Ordenar");
        btnOrdenar.setStyle("-fx-background-color: Black; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnOrdenar.setOnMouseEntered(event -> btnOrdenar.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnOrdenar.setOnMouseExited(event -> btnOrdenar.setStyle("-fx-background-color: Black; -fx-text-fill: white; -fx-font-size: 60px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnOrdenar.setOnAction(event -> {
            try {
                if (numeros.isEmpty()) {
                    throw new NoNumbersIntroducedException("*No ha metido números aún*");
                }
                controlador.ordenar(numeros);
                primaryStage.setScene(crearEscenaListaOrdenada(primaryStage));
            } catch (NoNumbersIntroducedException e) {
                // Mostrar el mensaje de la excepción en la interfaz
                display.setText(e.getMessage());
                display.setStyle("-fx-font-size: 40px; -fx-text-fill: red;");
            }
        });

        HBox botones = new HBox(btnIntroducir, btnOrdenar);
        botones.setAlignment(Pos.CENTER); // Centrar los elementos en el HBox
        botones.setSpacing(12);

        VBox rootTeclado = new VBox(display, teclado, botones);
        rootTeclado.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        rootTeclado.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaTeclado = new Scene(rootTeclado, 850, 700);
        return escenaTeclado;
    }



    /**
     * Método para crear la escena de la lista ordenada.
     * @param primaryStage El escenario principal de la aplicación.
     * @return La escena creada.
     */
    private Scene crearEscenaListaOrdenada(Stage primaryStage) {
        List<String> numerosOrdenados = numeros.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        // Crear una cadena de texto con el formato deseado
        String numerosOrdenadosStr = numerosOrdenados.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);

        // Agregar la cadena de texto a la interfaz gráfica
        Label labelNumeros = new Label(numerosOrdenadosStr);
        labelNumeros.setStyle("-fx-font-size: 100px; -fx-text-fill: #333; -fx-font-family: 'Calisto MT';");
        root.getChildren().add(labelNumeros);

        Button btnVeredicto = new Button("Veredicto");
        btnVeredicto.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnVeredicto.setOnMouseEntered(event -> btnVeredicto.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnVeredicto.setOnMouseExited(event -> btnVeredicto.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnVeredicto.setMaxHeight(Double.MAX_VALUE);
        btnVeredicto.setOnAction(event -> {
            primaryStage.setScene(crearEscenaVeredicto());
            numeros.clear();
        });

        VBox vbox = new VBox(root, btnVeredicto);
        vbox.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        vbox.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaListaOrdenada = new Scene(vbox, 850, 700);
        return escenaListaOrdenada;
    }



    /**
     * Método para crear la escena del veredicto.
     * @return La escena creada.
     */
    private Scene crearEscenaVeredicto() {
        EstadoMaquina estado = controlador.obtenerVeredicto();
        Label label;
        if (estado == EstadoMaquina.SE_DETINE) {
            label = new Label("-El programa se detiene 'Halting'");
        } else if (estado == EstadoMaquina.EN_BUCLE) {
            label = new Label("-El programa entra en un bucle 'Looping'");
        } else {
            label = new Label("Estado desconocido");
        }
        label.setStyle("-fx-font-size: 40px; -fx-text-fill: #333; -fx-font-family: 'Consolas';");

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnCerrar.setOnMouseEntered(event -> btnCerrar.setStyle("-fx-background-color: lightcoral; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnCerrar.setOnMouseExited(event -> btnCerrar.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnCerrar.setMaxHeight(Double.MAX_VALUE);
        btnCerrar.setOnAction(event -> System.exit(0));

        Button btnInicio = new Button("Inicio");
        btnInicio.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnInicio.setOnMouseEntered(event -> btnInicio.setStyle("-fx-background-color: lightblue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnInicio.setOnMouseExited(event -> btnInicio.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnInicio.setMaxHeight(Double.MAX_VALUE);
        btnInicio.setOnAction(event -> start(new Stage()));

        VBox root = new VBox(label, btnCerrar, btnInicio);
        root.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        root.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaVeredicto = new Scene(root, 850, 700);
        return escenaVeredicto;
    }



    /**
     * Método para crear la escena del reloj.
     * @return La escena creada.
     */
    private Scene crearEscenaReloj() {
        Label labelHora = new Label();
        labelHora.setStyle("-fx-font-size: 75px; -fx-text-fill: #333;");

        // Crear un Timeline que se ejecuta cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            // Obtener la hora actual y mostrarla en el label
            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/-/ HH:mm:ss /-/");
            labelHora.setText(horaActual.format(formatter));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Button btnVeredicto = new Button("Veredicto");
        btnVeredicto.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnVeredicto.setOnMouseEntered(event -> btnVeredicto.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnVeredicto.setOnMouseExited(event -> btnVeredicto.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 120px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnVeredicto.setOnAction(event -> {
            // Cambiar a la escena del veredicto
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(crearEscenaVeredictoReloj());
        });

        VBox root = new VBox(labelHora, btnVeredicto);
        root.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        root.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaReloj = new Scene(root, 850, 700);
        return escenaReloj;
    }



    /**
     * Método para crear la escena del veredicto del reloj.
     * Esta escena muestra un mensaje indicando que el programa nunca se detiene, y proporciona botones para cerrar la aplicación o volver al inicio.
     *
     * @return La escena creada, que contiene un mensaje, un botón para cerrar la aplicación y un botón para volver al inicio.
     */
    private Scene crearEscenaVeredictoReloj() {
        Label label = new Label("-El programa nunca se detiene 'Looping'");
        label.setStyle("-fx-font-size: 37px; -fx-text-fill: #333; -fx-font-family: 'Consolas';");

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnCerrar.setOnMouseEntered(event -> btnCerrar.setStyle("-fx-background-color: lightcoral; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnCerrar.setOnMouseExited(event -> btnCerrar.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 100px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnCerrar.setMaxHeight(Double.MAX_VALUE);
        btnCerrar.setOnAction(event -> System.exit(0));

        Button btnInicio = new Button("Inicio");
        btnInicio.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;");
        btnInicio.setOnMouseEntered(event -> btnInicio.setStyle("-fx-background-color: lightblue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnInicio.setOnMouseExited(event -> btnInicio.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 108px; -fx-border-color: black; -fx-border-width: 10px; -fx-border-radius: 60px; -fx-background-radius:63px;"));
        btnInicio.setMaxHeight(Double.MAX_VALUE);
        btnInicio.setOnAction(event -> start(new Stage()));

        VBox root = new VBox(label, btnCerrar, btnInicio);
        root.setAlignment(Pos.CENTER); // Centrar los elementos en el VBox
        root.setStyle("-fx-padding: 24px; -fx-spacing: 12px;");
        Scene escenaVeredictoReloj = new Scene(root, 850, 700);
        return escenaVeredictoReloj;
    }
}