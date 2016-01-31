package services;

import models.entities.Item;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class ServiceRegister implements ServiceConsumer {

    private List<ServiceConsumer> serviceConsumers;

    public Object search(String terms) {
        return null;
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
