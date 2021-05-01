package org.order.core.service;

import org.order.core.model.Item;
import org.order.core.model.MemberDetails;
import org.order.core.model.Order;
import org.order.web.error.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    ItemService itemService;

    public Order purchaseItem(String token) {
        MemberDetails memberDetails = authenticationService.validateIsLoggedIn(token);
        List<Item> itemsInCart = memberDetails.getItemsInCart();

        Double totalPrice = 0.0;

        for(Item item : itemsInCart){
            totalPrice += item.getPrice();
        }

        if (!itemsInCart.isEmpty()) {
            Order order = new Order();
            order.setInvoiceId(UUID.randomUUID().toString());
            order.setTotalPrice(totalPrice);
            order.setPurchasedItems(itemsInCart);

            memberDetails.getOrderHistory().add(order);
            memberDetails.setItemsInCart(new ArrayList<>());
            return order;
        } else {
            throw new ApplicationException(500, "Purchase Unsuccessful");
        }
    }

    public List<Order> getOrders(String token) {
        MemberDetails memberDetails = authenticationService.validateIsLoggedIn(token);
        return memberDetails.getOrderHistory();
    }
}
