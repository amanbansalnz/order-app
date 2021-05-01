package org.order.core.service;

import org.order.core.model.Item;
import org.order.core.model.MemberDetails;
import org.order.core.model.NewItem;
import org.order.util.HelperUtil;
import org.order.web.error.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    private Map<String, Item> itemMap;

    @Autowired
    private AuthenticationService authenticationService;

    public ItemService(){
        itemMap = new HashMap<>();
        addInitialItems();
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemMap.values());
    }

    public Map<String, Item> getItemsMap() {
        return itemMap;
    }
    public List<Item> addItems(List<NewItem> newItems) {

        for (NewItem newItem : newItems){
            Item item = new Item();
            item.setName(newItem.getName());
            item.setPrice(newItem.getPrice());
            item.setAvailable(newItem.isAvailable());
            String barcode = HelperUtil.generateHash(newItem.getName() + newItem.getPrice()+newItem.isAvailable());
            item.setBarcode(barcode);
            itemMap.put(barcode, item);
        }
        return getItems();
    }

    public void itemsAvailbleForPuchase(String barcode) {
        if(!itemMap.containsKey(barcode)){
            throw new ApplicationException(500, "Item does not exist to purchase");
        }
        Item item = itemMap.get(barcode);
        if(!item.isAvailable()){
            throw new ApplicationException(500, "this item is not aviable for purchas");
        }
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
