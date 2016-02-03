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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Spotify extends AbstractServiceConsumer implements ServiceConsumer{

    public Spotify() {
        this.baseURL = "https://api.spotify.com";
        this.clientID = "ea319403675f4db29fcce916fff2679f";
    }

    public List<Item> search(String terms) {

        String query;
        URL url;
        List<Item> results = new ArrayList<Item>();

        try {

            query = URLEncoder.encode(terms, "UTF-8");
            url = new URL(baseURL+"/v1/search?q="+query+"&type="+"track");
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
                String albumName = ((JsonObject) jsonTrack.get("album")).getString("name");
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
                String title = jsonTrack.getString("name");
                track.setTitle(title);

                // Sets uri.
                String uri = jsonTrack.getString("preview_url");
                track.setUri(uri);

                // Sets id.
                String id = jsonTrack.getString("id");
                track.setId(id);

                // Sets provider.
                track.setProvider(this);

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
