package org.order.web.model.request;

import lombok.Data;
import org.order.core.model.NewItem;

import java.util.List;

@Data
public class ItemsRequest {
    List<NewItem> items;
}
