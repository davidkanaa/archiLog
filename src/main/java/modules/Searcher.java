package modules;

import models.entities.Item;
import services.ServiceConsumer;
import services.ServiceRegister;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by davidkanaa on 16-02-02.
 */
public class Searcher {

    ServiceRegister register;
    Iterator<Item> results;

    public void search(String terms) {

        List<Item> results = new ArrayList<Item>();

        while (register.getServiceConsumers().hasNext()){
            ServiceConsumer consumer = register.getServiceConsumers().next();
            for (Item item : consumer.search(terms)){
                results.add(item);
            }
        }
        this.results = results.iterator();
    }


}
