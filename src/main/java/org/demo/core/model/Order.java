package org.demo.core.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String invoiceId;
    private List<Item> purchasedItems;
    private Double totalPrice;
}
