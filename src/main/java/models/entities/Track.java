package models.entities;

import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Track extends Item {

    protected String albumName;
    protected List<String> artitsNames;
    protected long duration; // in milliseconds.

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<String> getArtitsNames() {
        return artitsNames;
    }

    public void setArtitsNames(List<String> artitsNames) {
        this.artitsNames = artitsNames;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
