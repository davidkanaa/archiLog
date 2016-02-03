package modules.player;

import models.entities.Playlist;
import models.entities.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-02-02.
 */
public class Player implements IPlayer{

    private List<Track> queue;
    private int currentPosition;
    private PlayerState state;




    private Player() {
        this.queue = new ArrayList<Track>();
        this.currentPosition = 0;
        this.state = new Paused();
    }


    public void play(){
        state.play();
    }
    public void next(){
        // Plays the next track in the queue if state is Playing.
    }
    public void previous(){
        // Plays the previous track in the queue if state is Paused.
    }


    public void addToQueue(Track track){
        this.queue.add(track);
    }
    public void addToQueue(Playlist playlist){
        this.queue.addAll(playlist.getTracks());
    }

    public void clearQueue(){
        this.queue = new ArrayList<Track>(); // resets the queue to an empty array.
    }

    public List<Track> getQueue() {
        return queue;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public PlayerState getState() {
        return state;
    }
}
