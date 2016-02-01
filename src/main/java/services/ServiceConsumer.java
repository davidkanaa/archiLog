package services;

import models.entities.Item;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public interface ServiceConsumer {

    List<Item> search(String terms);
    Object addTrackToPlaylist();
    Object removeTrackFromPlaylist();
    Object getItem(Item item);
    Object authenticate();

    // TODO rest of necessary methods ...

}
