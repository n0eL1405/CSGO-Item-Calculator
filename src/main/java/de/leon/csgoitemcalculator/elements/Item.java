package de.leon.csgoitemcalculator.elements;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import lombok.Getter;

public class Item extends HBox {

    private Label itemName;

    private CheckBox itemActiveCheckBox;

    private TextField itemPrice;

    private TextField itemAmount;

    private TextField itemsValue;

    public Item() {
        intUi();
    }

    public Item(String name, Boolean active, String price, String amount, String value) {
        this();

        setItemName(name);
        setItemActive(active);
        setItemPrice(price);
        setItemAmount(amount);
        setItemsValue(value);
    }

    private void intUi() {

        itemName = new Label();
        itemName.setMinWidth(Region.USE_PREF_SIZE);
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

    public void resetLabelLength() {
        itemName.setMinWidth(Region.USE_PREF_SIZE);
        itemName.setPrefWidth(Region.USE_PREF_SIZE);
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

    public Label getItemNameLabel() {
        return itemName;
    }

    public Item copy() {
        return new Item(
            this.getItemName(),
            this.getItemActive(),
            this.getItemPrice(),
            this.getItemAmount(),
            this.getItemsValue()
        );
    }
}
