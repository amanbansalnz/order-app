package org.order.web.model.response;

import lombok.Data;
import org.order.core.model.Order;

import java.util.List;

@Data
public class OrdersResponse {
    private List<Order> orders;
}
