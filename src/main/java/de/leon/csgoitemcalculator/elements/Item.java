package de.leon.csgoitemcalculator.elements;

import de.leon.csgoitemcalculator.controller.ItemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Class for visualisation of items
 */
public class Item extends Pane implements Initializable {

    private ObjectProperty<String> itemName = new SimpleObjectProperty<>();
    private ObjectProperty<Boolean> itemActive = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemPrice = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemAmount = new SimpleObjectProperty<>();
    private ObjectProperty<String> itemsValue = new SimpleObjectProperty<>();

    ItemController itemController;

    public Item() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("item-layout.fxml"));

            itemController = new ItemController();
            loader.setController(itemController);
            Node node = loader.load();

            this.getChildren().add(node);

            itemController.getItemName().textProperty().bind(itemName);
            itemController.getItemActiveCheckBox().selectedProperty().bind(itemActive);
            itemController.getItemAmount().textProperty().bind(itemAmount);
            itemController.getItemPrice().textProperty().bind(itemPrice);
            itemController.getItemsValue().textProperty().bind(itemsValue);

        } catch (Exception ignore) {
        }
    }

    public void setLabelLength(double length) {
        itemController.setLabelLength(length);
    }

    public double getLabelLength() {
        return itemController.getLabelLength();
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
