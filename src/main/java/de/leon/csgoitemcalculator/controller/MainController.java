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
import javafx.scene.layout.RowConstraints;

public class MainController implements Initializable {

    @FXML
    private GridPane mainGrid;
    @FXML
    private GridPane leftItemGrid;
    @FXML
    private GridPane rightItemGrid;

    private Item item;

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

        // replace with method that adds 'ArrayList<Item>'s depending on columns
        itemArray.add(new ArrayList<>());
        itemArray.add(new ArrayList<>());

        /*
        leftItemGrid.addRow(0, new Button("Test1"));
        leftItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
        leftItemGrid.addRow(1, new Button("Test2"));
        leftItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
        leftItemGrid.addRow(2, new Button("Test3"));
        leftItemGrid.addRow(3, new Item());
         */

        itemList.forEach(itemVar -> {
            if (leftItemGrid.getRowCount() <= rightItemGrid.getRowCount()) {
                // item links hinzufügen
                int index = leftItemGrid.getRowCount();
                leftItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
                leftItemGrid.addRow(index, itemVar);
                itemArray.get(0).add(index, itemVar);
            } else {
                // item rechts hinzufügen
                int index = rightItemGrid.getRowCount();
                rightItemGrid.getRowConstraints().add(getRowConstraint(30.0, Priority.NEVER, VPos.CENTER, true));
                rightItemGrid.addRow(index, itemVar);
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

    private RowConstraints getRowConstraint(double minHeight, double prefHeight, double maxHeight, Priority vGrow, VPos vAlignment, boolean fillHeight) {
        return new RowConstraints(minHeight, prefHeight, maxHeight, vGrow, vAlignment, fillHeight);
    }

    private RowConstraints getRowConstraint(double prefHeight, Priority vGrow, VPos vAlignment, boolean fillHeight) {
        return getRowConstraint(Double.NEGATIVE_INFINITY, prefHeight, Double.NEGATIVE_INFINITY, vGrow, vAlignment, fillHeight);
    }
}