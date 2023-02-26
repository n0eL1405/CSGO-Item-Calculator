package de.leon.csgoitemcalculator;

import de.leon.csgoitemcalculator.controller.ItemController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private static final String VERSION = "pre-release 1"; // NumVer or CalcVer? why not both: 2023.xx.xx v0.0.1 Kappa
    private static final String TITLE = "CSGO Item Calculator - " + VERSION;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}