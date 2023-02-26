package de.leon.csgoitemcalculator.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ItemController implements Initializable {

    @FXML
    private Label itemName;

    @FXML
    private CheckBox itemActiveCheckBox;

    @FXML
    private TextField itemPrice;

    @FXML
    private TextField itemAmount;

    @FXML
    private TextField itemsValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Label getItemName() {
        return itemName;
    }

    public CheckBox getItemActiveCheckBox() {
        return itemActiveCheckBox;
    }

    public TextField getItemPrice() {
        return itemPrice;
    }

    public TextField getItemAmount() {
        return itemAmount;
    }

    public TextField getItemsValue() {
        return itemsValue;
    }
}
