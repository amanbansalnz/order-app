package org.demo.web.model.response;

import lombok.Data;
import org.demo.core.model.Item;

import java.util.List;
import java.util.Map;

@Data
public class ItemsResponse {
    Map<String, Item> items;
}
