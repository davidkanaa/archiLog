package com.mustream.app.models.entities;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 * Last modified by Akilah Calliste-Woollard on 16-03-28
 */

/**
 * An entity model for a playlist from a streaming service provider.
 *
 * A playlist is an item which holds a list of tracks.
 */

public class Playlist extends Item {
	protected String title;
	public List<Track> tracks;
	
	public Playlist(String name){
		title = name;
		tracks = new ArrayList<Track>();
	}
    

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
