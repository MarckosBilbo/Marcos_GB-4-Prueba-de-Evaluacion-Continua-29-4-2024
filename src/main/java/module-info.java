module uax.examen4.Halting_Problem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens uax.examen4.Halting_Problem to javafx.fxml, javafx.graphics;
    opens uax.examen4.Halting_Problem.Vista to javafx.fxml, javafx.graphics;
    exports uax.examen4.Halting_Problem;
}