package ru.kpfu.Auto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {


    
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Auto");
        alert.setHeaderText("About");
        alert.setContentText("Author: Mars");

        alert.showAndWait();
    }

    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}