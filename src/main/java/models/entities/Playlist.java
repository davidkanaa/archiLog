package models.entities;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Playlist extends Item {

    protected List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
