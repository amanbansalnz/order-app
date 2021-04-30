package org.order.web.model.response;

import lombok.Data;
import org.order.core.model.Order;

@Data
public class OrderResponse {
    private Order order;
}
