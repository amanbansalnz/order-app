package org.demo.web.model.request;

import lombok.Data;
import org.demo.core.model.NewItem;

import java.util.List;

@Data
public class ItemsRequest {
    List<NewItem> items;
}
