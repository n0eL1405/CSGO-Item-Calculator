module de.leon.csgoitemcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;

    opens de.leon.csgoitemcalculator to javafx.fxml;
    exports de.leon.csgoitemcalculator;
    exports de.leon.csgoitemcalculator.controller;
    exports de.leon.csgoitemcalculator.elements;
    opens de.leon.csgoitemcalculator.controller to javafx.fxml;
    opens de.leon.csgoitemcalculator.elements to javafx.fxml;
}