package models.entities;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class Item {

    protected String providerName; // The id of the service provider in the service register.
    protected String title;
    protected String uri;
    protected String id; // The id of the item in the db of its service provider.

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
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
