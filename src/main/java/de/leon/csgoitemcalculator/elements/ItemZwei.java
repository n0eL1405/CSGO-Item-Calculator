package de.leon.csgoitemcalculator.elements;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ItemZwei extends HBox {

    private Label itemName;

    private CheckBox itemActiveCheckBox;

    private TextField itemPrice;

    private TextField itemAmount;

    private TextField itemsValue;

    public ItemZwei() {
        //getStylesheets().add(ItemZwei.class.getResource("itemStyle.css").toExternalForm());

        intUi();
    }

    private void intUi() {

        itemName = new Label();
        itemName.setText("TestItem");
        itemActiveCheckBox = new CheckBox();
        itemPrice = new TextField();
        itemPrice.setEditable(false);
        itemAmount = new TextField();
        itemsValue = new TextField();
        itemsValue.setEditable(false);

        setFillHeight(true);
        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(itemName, itemActiveCheckBox, itemPrice, itemAmount, itemsValue);
    }

    public void setLabelLength(double length) {
        itemName.setMinWidth(length);
    }

    public double getLabelLength() {
        return itemName.getWidth();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void setItemName(String name) {
        this.itemName.setText(name);
    }

    public Boolean getItemActive() {
        return itemActiveCheckBox.isSelected();
    }

    public void setItemActive(Boolean active) {
        this.itemActiveCheckBox.setSelected(active);
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void setItemPrice(String price) {
        this.itemPrice.setText(price);
    }

    public String getItemAmount() {
        return itemAmount.getText();
    }

    public void setItemAmount(String amount) {
        this.itemAmount.setText(amount);
    }

    public String getItemsValue() {
        return itemsValue.getText();
    }

    public void setItemsValue(String value) {
        this.itemsValue.setText(value);
    }
}