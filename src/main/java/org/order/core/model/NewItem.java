package org.order.core.model;

import lombok.Data;

@Data
public class NewItem {
    public String name;
    public Double price;
    public boolean available;
}
