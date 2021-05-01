package org.order.web.model.response;

import lombok.Data;
import org.order.core.model.Item;

import java.util.List;

@Data
public class ItemsResponse {
    List<Item> items;
}
