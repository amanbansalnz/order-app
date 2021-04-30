package org.demo.web.model.response;

import lombok.Data;
import org.demo.core.model.Order;

@Data
public class OrderResponse {
    private Order order;
}
