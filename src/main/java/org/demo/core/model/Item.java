package org.demo.core.model;

import lombok.Data;

@Data
public class Item {
    public String name;
    public Double price;
    public String barcode;
    public boolean available;
}
