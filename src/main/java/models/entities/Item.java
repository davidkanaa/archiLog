package models.entities;

import services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Item {

    protected ServiceConsumer provider;
    protected String title;
    protected String uri;
    protected String id; // The id of the item in the db of its service provider.

    public ServiceConsumer getProvider() {
        return provider;
    }

    public void setProvider(ServiceConsumer provider) {
        this.provider = provider;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
