package org.order.core.service;

import org.order.core.model.Item;
import org.order.core.model.MemberDetails;
import org.order.core.model.NewItem;
import org.order.util.HelperUtil;
import org.order.web.error.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ItemService itemService;

    public List<Item> addItemToCart(String barcode , String token) {
        itemService.itemsAvailbleForPuchase(barcode);
        MemberDetails memberDetails = authenticationService.validateIsLoggedIn(token);
        List<Item> itemsInCart = memberDetails.getItemsInCart();

        itemsInCart.add(itemService.getItemsMap().get(barcode));

        return itemsInCart;
    }

    public List<Item> getItemToCart(String token) {
        MemberDetails memberDetails = authenticationService.validateIsLoggedIn(token);
        List<Item> itemsInCart = memberDetails.getItemsInCart();
        return itemsInCart;
    }
}
