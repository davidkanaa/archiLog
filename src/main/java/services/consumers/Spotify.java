package services.consumers;

import models.entities.Item;
import services.AbstractServiceConsumer;
import services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Spotify extends AbstractServiceConsumer implements ServiceConsumer{


    public Spotify() {
        this.providerName = "Spotify";
<<<<<<< develop
        this.baseURL = "https://api.spotify.com"; 
=======
        this.baseURL = "https://api.spotify.com";


>>>>>>> 5b7cb64 Added Contructor to the Spotify consumer
    }

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
