package org.order.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MemberDetails {
    private String memberName;
    private String password;
    private String phoneNumber;
    private String email;
    private List<Item> itemsInCart;
    private List<Order> orderHistory;
}
