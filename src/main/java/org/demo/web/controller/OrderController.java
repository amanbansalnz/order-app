package org.demo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.demo.core.model.Item;
import org.demo.core.model.Order;
import org.demo.core.service.OrderService;
import org.demo.web.model.request.ItemsRequest;
import org.demo.web.model.request.OrderRequest;
import org.demo.web.model.response.ItemsResponse;
import org.demo.web.model.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse addItem(@RequestHeader(name = "token") String token,
                                 @RequestBody OrderRequest orderRequest) {

        log.info("OrderController purchase");

        Order order = orderService.purchaseItem(token, orderRequest.getBarcodes());

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrder(order);

        log.info("OrderController order response <<<< with OrderResponse={}", orderResponse);

        return orderResponse;
    }
}
