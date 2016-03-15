package com.mustream.app.models.entities;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */

/**
 * An entity model for a track from a streaming service provider.
 *
 * A track is an item that has an album name,
 * a list of contributors (artists),
 * a duration (in milliseconds)
 *
 */
public class Track extends Item {

    protected String albumName;
    protected List<String> artitsNames;
    protected long duration; // in milliseconds.

    /**
     *
     * @return The name of the album of the current track.
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     *
     * @param albumName
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     *
     * @return The list of artists for the current track.
     */
    public List<String> getArtitsNames() {
        return artitsNames;
    }

    /**
     *
     * @param artitsNames
     */
    public void setArtitsNames(List<String> artitsNames) {
        this.artitsNames = artitsNames;
    }

    /**
     *
     * @return The duration of the current track.
     */
    public long getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" + '\n'+
                "id = " + id + '\n'+
                "title = " + title + '\n'+
                "uri = " + uri + '\n'+
                "albumName = '" + albumName + '\'' + "," + '\n'+
                "artitsNames = " + artitsNames + "," +'\n'+
                "duration = " + duration + '\n' +
                "};";
    }
}

