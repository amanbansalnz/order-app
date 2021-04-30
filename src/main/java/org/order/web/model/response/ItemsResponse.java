package org.order.web.model.response;

import lombok.Data;
import org.order.core.model.Item;

import java.util.Map;

@Data
public class ItemsResponse {
    Map<String, Item> items;
}
