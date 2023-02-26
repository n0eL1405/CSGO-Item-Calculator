package de.leon.csgoitemcalculator.elements;

import de.leon.csgoitemcalculator.controller.ItemController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Class for visualisation of items
 */
public class Item extends HBox {

    private ObjectProperty<String> itemName = new SimpleObjectProperty<>();
    private ObjectProperty<Boolean> itemActive = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemPrice = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemAmount = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemsValue = new SimpleObjectProperty<>();

    ItemController itemController;

    public Item() {

        super();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("item.fxml"));

            itemController = new ItemController();
            loader.setController(itemController);
            Node node = loader.load();

            this.getChildren().add(node);

            itemController.getItemName().textProperty().bind(itemName);
            itemController.getItemActiveCheckBox().selectedProperty().bind(itemActive);
            itemController.getItemAmount().textProperty().bind(itemAmount);
            itemController.getItemPrice().textProperty().bind(itemPrice);
            itemController.getItemsValue().textProperty().bind(itemsValue);

        } catch (Exception ignore) { }

    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public Boolean getItemActive() {
        return itemActive.get();
    }

    public void setItemActive(Boolean itemActive) {
        this.itemActive.set(itemActive);
    }

    public String getItemPrice() {
        return itemPrice.get();
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice.set(itemPrice);
    }

    public String getItemAmount() {
        return itemAmount.get();
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount.set(itemAmount);
    }

    public String getItemsValue() {
        return itemsValue.get();
    }

    public void setItemsValue(String itemsValue) {
        this.itemsValue.set(itemsValue);
    }
}
