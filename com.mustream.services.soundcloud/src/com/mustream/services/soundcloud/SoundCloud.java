package com.mustream.services.soundcloud;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.mustream.app.models.entities.Item;
import com.mustream.app.models.entities.Track;
import com.mustream.app.services.AbstractServiceConsumer;
import com.mustream.app.services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-02-02.
 */

/**
 *
 * The consumer associated with SoundCloud. It consumes the SoundCloud RestFul API.
 *
 */
public class SoundCloud extends AbstractServiceConsumer implements ServiceConsumer {


    public SoundCloud() {
        this.clientID = "39c4a333359cc62c40b9795ad9bb5203";
        this.baseURL = "http://api.soundcloud.com";
    }

    /**
     * Runs a search over SoundCloud's database.
     * @param terms Terms of the search.
     * @return The results of the search as a list of Items.
     */
    public List<Item> search(String terms) {

        String query;
        URL url;
        List<Item> results = new ArrayList<Item>();

        try {
            query = URLEncoder.encode(terms, "UTF-8");
            url = new URL(baseURL+"/tracks?client_id="+clientID+"&q="+query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonArray jsonResults = reader.readArray();

            // retrieves the tracks within the results.
            for (JsonObject result:
                 jsonResults.getValuesAs(JsonObject.class)) {

                Track track = new Track();

                // Sets the album name.
                String albumName = "n/a";
                track.setAlbumName(albumName);

                // Sets the user as the sole artist of the track.
                String user = result.getJsonObject("user").getString("username");
                List<String> artists = new ArrayList<String>();
                artists.add(user);
                track.setArtitsNames(artists);

                // Sets the duration.
                long duration = result.getJsonNumber("duration").longValue();
                track.setDuration(duration);

                // Sets title.
                String title = result.getString("title");
                track.setTitle(title);

                // Sets uri.
                String uri = result.getString("stream_url");
                track.setUri(uri);

                // Sets id.
                String id = result.getJsonNumber("id").toString();
                track.setId(id);

                // Sets provider.
                //track.setProvider(this);

                // Adding to the results.
                results.add(track);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}

