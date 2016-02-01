package services;

import models.entities.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class ServiceRegister implements ServiceConsumer {

    private List<ServiceConsumer> serviceConsumers;

    public Object search(String terms) {
        List<Object> results = new ArrayList<Object>();
        for (ServiceConsumer consumer : serviceConsumers){
            results.add(consumer.search(terms));
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
