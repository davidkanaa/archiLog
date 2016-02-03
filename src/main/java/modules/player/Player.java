package modules.player;

import models.entities.Track;

import java.util.List;

/**
 * Created by davidkanaa on 16-02-02.
 */
public class Player {

    List<Track> queue;
    int currentPosition;
    PlayerState state;
}
