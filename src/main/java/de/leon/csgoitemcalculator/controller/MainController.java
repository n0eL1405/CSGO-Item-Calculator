package de.leon.csgoitemcalculator.controller;

import de.leon.csgoitemcalculator.ItemData;
import de.leon.csgoitemcalculator.elements.Item;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private GridPane mainGrid;
    @FXML
    private GridPane leftItemGrid;
    @FXML
    private GridPane rightItemGrid;

    List<Item> itemList = new ArrayList<>();
    List<List<Item>> itemArray = new ArrayList<>();

    public MainController() {

        Item item = new Item();
        item.setItemName("Test");
        item.setItemActive(true);
        item.setItemPrice("0.20€");
        item.setItemAmount("4");
        item.setItemsValue("0.80€");

        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);

        itemList.forEach(itemVar -> {

            if (leftItemGrid.getRowCount() <= rightItemGrid.getRowCount()) {
                // item links hinzufügen
                int index = leftItemGrid.getRowCount() - 1;
                leftItemGrid.addRow(index, itemVar);
                leftItemGrid.getRowConstraints().get(index).setVgrow(Priority.NEVER);
                itemArray.get(0).add(index, itemVar);
            } else {
                // item rechts hinzufügen
                int index = rightItemGrid.getRowCount() - 1;
                rightItemGrid.addRow(index, itemVar);
                rightItemGrid.getRowConstraints().get(index).setVgrow(Priority.NEVER);
                itemArray.get(1).add(index, itemVar);
            }

        });

    }

    private void updateLengthForAllItemLabels() {

        double[] length = {0};

        itemList.forEach(item -> {
            if (item.getLabelLength() > length[0]) {
                length[0] = item.getLabelLength();
            }
        });

        setLengthForAllItemLabels(length[0]);
    }

    private void setLengthForAllItemLabels(double length) {

        itemList.forEach(item -> {
            item.setLabelLength(length);
        });

    }
}