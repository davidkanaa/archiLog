package modules.player;

import models.entities.Playlist;
import models.entities.Track;

import java.util.ArrayList;

/**
 * Created by davidkanaa on 16-02-03.
 */
public interface IPlayer {

    void play();
    void next();
    void previous();


    void addToQueue(Track track);
    void addToQueue(Playlist playlist);

    void clearQueue();
}
