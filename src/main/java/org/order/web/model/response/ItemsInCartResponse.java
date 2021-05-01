package org.order.web.model.response;

import lombok.Data;
import org.order.core.model.Item;

import java.util.List;
import java.util.Map;

@Data
public class ItemsInCartResponse {
  List<Item> itemsInCart;
}
