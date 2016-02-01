package services;

import models.entities.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class ServiceRegister implements ServiceConsumer {

    private List<ServiceConsumer> serviceConsumers;

    public List<Item> search(String terms) {
        List<Item> results = new ArrayList<Item>();
        for (ServiceConsumer consumer : serviceConsumers){
            for (Item item : consumer.search(terms)){
                results.add(item);
            };
        }
        return results;
    }

    public Object addTrackToPlaylist() {
        return null;
    }

    public Object removeTrackFromPlaylist() {
        return null;
    }

    public Object getItem(Item item) {
        return null;
    }

    public Object authenticate() {
        return null;
    }
}
