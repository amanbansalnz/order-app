package org.order.core.service;

import org.order.core.model.Item;
import org.order.core.model.NewItem;
import org.order.util.HelperUtil;
import org.order.web.error.ApplicationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    private Map<String, Item> itemMap;

    public ItemService(){
        itemMap = new HashMap<>();
        addInitialItems();
    }

    public Map<String, Item> getItems() {
        return itemMap;
    }

    public Map<String, Item> addItems(List<NewItem> newItems) {

        for (NewItem newItem : newItems){
            Item item = new Item();
            item.setName(newItem.getName());
            item.setPrice(newItem.getPrice());
            item.setAvailable(newItem.isAvailable());
            String barcode = HelperUtil.generateHash(newItem.getName() + newItem.getPrice()+newItem.isAvailable());
            item.setBarcode(barcode);
            itemMap.put(barcode, item);
        }
        return itemMap;
    }

    public boolean itemsAvailbleForPuchase(List<String> barcodes) {

        for (String barcode : barcodes){
           if(!itemMap.containsKey(barcode)){
               throw new ApplicationException(500, "One or more items are not aviable for purchas");
           }
        }
        return true;
    }


    private void addInitialItems() {
        for(int i = 0; i < 20 ;i++ ){
            Item item = new Item();
            item.setName("testItem" + i);
            item.setPrice((1.56 + i) * 0.7888);
            if(i <15) {
                item.setAvailable(true);
            }
            String barcode = UUID.randomUUID().toString();
            item.setBarcode(barcode);
            itemMap.put(barcode, item);
        }
    }

}
