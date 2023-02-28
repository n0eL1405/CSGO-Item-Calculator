package de.leon.csgoitemcalculator.controller;

import de.leon.csgoitemcalculator.elements.Item;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

public class MainController implements Initializable {

    @FXML
    private GridPane mainGrid;
    @FXML
    private GridPane leftItemGrid;
    @FXML
    private GridPane rightItemGrid;

    List<Item> itemList = new ArrayList<>();
    List<List<Item>> itemArray = new ArrayList<>();

    public MainController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    public void init() {

        // test data
        Item item = new Item();
        item.setItemName("Test");
        item.setItemActive(true);
        item.setItemPrice("0.20€");
        item.setItemAmount("4");
        item.setItemsValue("0.80€");

        itemList.add(item.copy());
        itemList.add(item.copy());
        itemList.add(item.copy());
        itemList.add(item.copy());
        itemList.add(item.copy());
        itemList.add(new Item("Test 12345", true, "ad", "ad", "ads"));

        // adding List<Item> for each column in mainGrid
        for (int i = 0; i < mainGrid.getColumnCount(); i++) {
            itemArray.add(new ArrayList<>());
        }

        itemList.forEach(itemVar -> {

            if (leftItemGrid.getRowCount() <= rightItemGrid.getRowCount()) {
                // add items left
                int index = leftItemGrid.getRowCount();
                leftItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
                leftItemGrid.addRow(index, itemVar);
                itemArray.get(0).add(index, itemVar);
            } else {
                // add items right
                int index = rightItemGrid.getRowCount();
                rightItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
                rightItemGrid.addRow(index, itemVar);
                itemArray.get(1).add(index, itemVar);
            }
        });

        updateLengthForAllItemLabels();
    }

    private void updateLengthForAllItemLabels() {

        Double[] length = {0.0};

        itemArray.get(0).forEach(child -> {
            double labelLength = child.prefWidth(-1);

            if (labelLength > length[0]) {
                length[0] = labelLength;
            }
        });

        itemArray.get(1).forEach(child -> {
            double labelLength = child.prefWidth(-1);

            if (labelLength > length[0]) {
                length[0] = labelLength;
            }
        });

        setLengthForAllItemLabels(length[0]);
    }

    private void setLengthForAllItemLabels(double length) {

        itemArray.get(0).forEach(child -> {
            child.getItemNameLabel().setPrefWidth(length);
        });

        itemArray.get(1).forEach(child -> {
            child.getItemNameLabel().setPrefWidth(length);
        });

    }

    private RowConstraints getRowConstraint(double minHeight, double prefHeight, double maxHeight, Priority vGrow, VPos vAlignment, boolean fillHeight) {
        return new RowConstraints(minHeight, prefHeight, maxHeight, vGrow, vAlignment, fillHeight);
    }

    private RowConstraints getRowConstraint(double prefHeight, Priority vGrow, VPos vAlignment, boolean fillHeight) {
        return getRowConstraint(Double.NEGATIVE_INFINITY, prefHeight, Double.NEGATIVE_INFINITY, vGrow, vAlignment, fillHeight);
    }
}