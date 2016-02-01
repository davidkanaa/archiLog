package services.consumers;

import models.entities.Item;
import models.entities.Track;
import services.AbstractServiceConsumer;
import services.ServiceConsumer;

import javax.json.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Spotify extends AbstractServiceConsumer implements ServiceConsumer{


    public Spotify() {
        this.providerName = "Spotify";
        this.baseURL = "https://api.spotify.com";
    }

    public Object search(String terms) {
        String query = terms.replaceAll("\\s", "%20");
        List<Item> results = new ArrayList<Item>();

        try {
            URL url = new URL(baseURL+"/v1/search?q="+query+"&type="+"track");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonObject jsonResults = reader.readObject();

            // retrieves the tracks within the results.
            JsonArray tracks = (JsonArray) jsonResults.getJsonObject("tracks").get("items");
            for (JsonObject jsonTrack : tracks.getValuesAs(JsonObject.class)){

                Track track = new Track();

                // Sets the album name.
                String albumName = ((JsonObject) jsonTrack.get("album")).get("name").toString();
                track.setAlbumName(albumName);

                // Sets the list of artists.
                JsonArray jsonArtists = (JsonArray)jsonTrack.get("artists");
                List<String> artists = new ArrayList<String>();
                for (JsonObject jsonArtist : jsonArtists.getValuesAs(JsonObject.class)){
                    artists.add(jsonArtist.get("name").toString());
                }
                track.setArtitsNames(artists);

                // Sets duration.
                long duration = jsonTrack.getJsonNumber("duration_ms").longValue();
                track.setDuration(duration);

                // Sets title.
                String title = jsonTrack.get("name").toString();
                track.setTitle(title);

                // Sets uri.
                String uri = jsonTrack.get("preview_url").toString();
                track.setUri(uri);

                // Sets id.
                String id = jsonTrack.get("id").toString();
                track.setId(id);

                // Sets provider name.
                track.setProviderName(this.providerName);

                // Adding to the results.
                results.add(track);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return results;
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
