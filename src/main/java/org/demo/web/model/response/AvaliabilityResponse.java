package org.demo.web.model.response;

import lombok.Data;
import org.demo.core.model.Item;

import java.util.Map;

@Data
public class AvaliabilityResponse {
    private boolean itemsAreAvaliable;
}
