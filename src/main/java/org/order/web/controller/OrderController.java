package org.order.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.order.core.model.Order;
import org.order.core.service.OrderService;
import org.order.web.model.request.OrderRequest;
import org.order.web.model.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
