package org.demo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.demo.core.model.Item;
import org.demo.core.service.ItemService;
import org.demo.web.error.InvalidRequestException;
import org.demo.web.model.request.ItemsRequest;
import org.demo.web.model.response.AvaliabilityResponse;
import org.demo.web.model.response.ItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ItemsResponse getItems() {

        log.info("ItemController get items");

        Map<String, Item> items = itemService.getItems();
        ItemsResponse itemsResponse = new ItemsResponse();
        itemsResponse.setItems(items);

        log.info("ItemController get items response <<<< with ItemsResponse={}", itemsResponse);

        return itemsResponse;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ItemsResponse addItem(@RequestBody ItemsRequest itemRequest) {

        log.info("ItemController add Item");

        Map<String, Item> items = itemService.addItems(itemRequest.getItems());

        ItemsResponse itemsResponse = new ItemsResponse();
        itemsResponse.setItems(items);

        log.info("ItemController add Item response <<<< with ItemsResponse={}", itemsResponse);

        return itemsResponse;
    }
}
