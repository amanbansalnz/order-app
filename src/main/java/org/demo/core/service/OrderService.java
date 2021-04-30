package org.demo.core.service;

import org.demo.core.model.Item;
import org.demo.core.model.Order;
import org.demo.web.error.ApplicationException;
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

    public Order purchaseItem(String token, List<String> barcodes) {
        authenticationService.validateIsLoggedIn(token);
        List<Item> itemsPurchased = new ArrayList<>();
        Double totalPrice = 0.0;

      for(String barcode : barcodes ) {
          for (Map.Entry<String, Item> entry : itemService.getItems().entrySet()) {
              Item item = entry.getValue();
              if (item.getBarcode().equals(barcode) && item.isAvailable()) {
                  totalPrice += item.getPrice();
                  itemsPurchased.add(item);
              }
          }
      }

        if (!itemsPurchased.isEmpty()) {
            Order order = new Order();
            order.setInvoiceId(UUID.randomUUID().toString());
            order.setTotalPrice(totalPrice);
            order.setPurchasedItems(itemsPurchased);
            return order;
        } else {
            throw new ApplicationException(500, "Purchase Unsuccessful");
        }
    }
}
