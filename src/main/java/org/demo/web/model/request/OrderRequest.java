package org.demo.web.model.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<String> barcodes;
}
