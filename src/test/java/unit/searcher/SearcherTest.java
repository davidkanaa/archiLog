package unit.searcher;

import models.entities.Item;
import models.entities.Track;
import modules.searcher.Searcher;
import org.junit.Test;
import org.mockito.Mockito;
import services.ServiceConsumer;
import services.ServiceRegister;
import services.consumers.SoundCloud;
import services.consumers.Spotify;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by davidkanaa on 16-02-18.
 */
public class SearcherTest {

    private final String SEARCH_TERMS = "TEST_TERMS";

    @Test
    public void testSearch() throws Exception {

        //  test items
        Item spotifyTrack = new Track();
        Item soundcloudTrack = new Track();

        // setting up items

        // test track 1
        spotifyTrack.setId("1");
        spotifyTrack.setUri("test/tracks/1");
        spotifyTrack.setTitle("track 1");

        // test track 2
        spotifyTrack.setId("2");
        spotifyTrack.setUri("test/tracks/2");
        spotifyTrack.setTitle("track 2");

        // creating mock service consumers for the sake of this test
        ServiceConsumer spotify = Mockito.mock(Spotify.class);
        ServiceConsumer soundcloud = Mockito.mock(SoundCloud.class);

        // creating a list of results for the spotify service mock
        List<Item> spotifyResult = new ArrayList<Item>();
        spotifyResult.add(spotifyTrack);

        /* setting the mock to return the specified list of items whenever asked for a search with the
                given search terms
                 */
        Mockito.when(spotify.search(SEARCH_TERMS)).thenReturn(spotifyResult);


        // creating a list of results for the soundcloud service mock
        List<Item> soundcloudResult = new ArrayList<Item>();
        soundcloudResult.add(soundcloudTrack);

        /* setting the mock to return the specified list of items whenever asked for a search with the
                given search terms
                 */
        Mockito.when(soundcloud.search(SEARCH_TERMS)).thenReturn(soundcloudResult);

        // creates a searcher.
        Searcher searcher = new Searcher();

        // loads the mock services into the register
        ServiceRegister register = ServiceRegister.getInstance_();
        register.loadService(soundcloud);
        register.loadService(spotify);

        searcher.search(SEARCH_TERMS);

        /* verifies the behaviour of the searcher ... checks whether it calls the search method of each
        * given consumer with the same search terms */
        Mockito.verify(spotify).search(SEARCH_TERMS);
        Mockito.verify(soundcloud).search(SEARCH_TERMS);

        // checks whether the test items are returned to the searcher, as expected.
        assertTrue(searcher.getResults().contains(spotifyTrack));
        assertTrue(searcher.getResults().contains(soundcloudTrack));

    }
}