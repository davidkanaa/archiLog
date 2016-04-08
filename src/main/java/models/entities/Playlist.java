package models.entities;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */

/**
 * An entity model for a playlist from a streaming service provider.
 *
 * A playlist is an item which holds a list of tracks.
 */

public class Playlist extends Item {

    protected List<Track> tracks;

    /**
     *
     * @return The list of tracks in this playlist.
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     *
     * @param tracks
     */
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
