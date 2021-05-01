package org.order.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.order.core.model.Item;
import org.order.core.service.CartService;
import org.order.core.service.ItemService;
import org.order.web.model.request.ItemsRequest;
import org.order.web.model.response.ItemsInCartResponse;
import org.order.web.model.response.ItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ItemsInCartResponse getItemsInCart( @RequestHeader(name = "token") String token) {

        log.info("CartController get items in cart");

        List<Item> items = cartService.getItemToCart(token);
        ItemsInCartResponse itemsInCartResponse = new ItemsInCartResponse();
        itemsInCartResponse.setItemsInCart(items);

        log.info("ItemController get items response <<<< with itemsInCartResponse={}", itemsInCartResponse);

        return itemsInCartResponse;
    }


    @PostMapping("/{barcode}")
    @ResponseStatus(HttpStatus.OK)
    public ItemsInCartResponse addItemToCart(@PathVariable("barcode") String barcode,
                                             @RequestHeader(name = "token") String token) {

        log.info("CartController addItemToCart");

        List<Item> items = cartService.addItemToCart(barcode, token);

        ItemsInCartResponse itemsInCartResponse = new ItemsInCartResponse();
        itemsInCartResponse.setItemsInCart(items);

        log.info("CartController addItemToCart response <<<< with itemsInCartResponse={}", itemsInCartResponse);

        return itemsInCartResponse;
    }

}
