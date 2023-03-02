package de.leon.csgoitemcalculator.elements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import lombok.Getter;

public class Item extends HBox {

    private final static String ID_PREFIX = "item-layout";

    private final static double margin = 2.5;

    private HBox rightHBox;

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

        setId(ID_PREFIX + "-mainHBox");

        itemName = new Label();
        itemName.setMaxWidth(Region.USE_PREF_SIZE);
        itemName.setMinWidth(60);

        Region labelSpacingRegion = new Region();
        setHgrow(labelSpacingRegion, Priority.ALWAYS);
        labelSpacingRegion.setMinWidth(margin);

        itemActiveCheckBox = new CheckBox();

        itemPrice = new TextField();
        setHgrow(itemPrice, Priority.ALWAYS);
        itemPrice.setAlignment(Pos.CENTER_RIGHT);
        itemPrice.setMaxWidth(75);
        itemPrice.setMinWidth(50);
        itemPrice.setEditable(false);

        itemAmount = new TextField();
        setHgrow(itemAmount, Priority.ALWAYS);
        itemAmount.setAlignment(Pos.CENTER);
        itemAmount.setMaxWidth(50);
        itemAmount.setMinWidth(40);

        itemsValue = new TextField();
        setHgrow(itemsValue, Priority.ALWAYS);
        itemsValue.setAlignment(Pos.CENTER_RIGHT);
        itemsValue.setMaxWidth(100);
        itemsValue.setMinWidth(50);
        itemsValue.setEditable(false);

        rightHBox = new HBox();
        setHgrow(rightHBox, Priority.ALWAYS);
        rightHBox.setAlignment(Pos.CENTER_RIGHT);
        rightHBox.setMinWidth(
            itemActiveCheckBox.getMinWidth()
                + itemPrice.getMinWidth()
                + itemAmount.getMinWidth()
                + itemsValue.getMinWidth()
                + (margin * 4)
        );
        rightHBox.getChildren().addAll(
            itemActiveCheckBox,
            getMargin(),
            itemPrice,
            getMargin(),
            itemAmount,
            getMargin(),
            itemsValue,
            getMargin()
        );

        setFillHeight(true);
        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(
            getMargin(),
            itemName,
            labelSpacingRegion,
            rightHBox
        );
    }

    private Region getMargin() {
        Region marginRegion = new Region();
        marginRegion.setPrefWidth(margin);
        marginRegion.setMinWidth(margin);
        setHgrow(marginRegion, Priority.NEVER);

        return marginRegion;
    }

    @Deprecated
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

    @Deprecated
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
