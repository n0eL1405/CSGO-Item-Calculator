package de.leon.csgoitemcalculator;

import lombok.Data;

/**
 * Class for the data of an item
 */
@Data
public class ItemData {

    private String name;
    private boolean active;
    private Double price;
    private Integer amount;
    private Double value;
    private int sortKey;
    private String picUrl;
    private String marketUrl;
    private String apiUrl;

}
