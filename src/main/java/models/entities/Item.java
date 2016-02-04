package models.entities;

import services.ServiceConsumer;

/**
 * Created by davidkanaa on 16-01-29.
 */

/**
 * An entity model representing an item from a streaming service provider.
 *
 * An Item is defined by its provider, represented by the interface that consumes it,
 * by its identifier in the provider database,
 * by the URI,
 * by its title.
 *
 */
public class Item {

    protected ServiceConsumer provider;
    protected String title;
    protected String uri;
    protected String id; // The id of the item in the db of its service provider.

    /**
     *
     * @return The consumer associated with the service that provided this item.
     */
    public ServiceConsumer getProvider() {
        return provider;
    }

    /**
     *
     * @param provider
     */
    public void setProvider(ServiceConsumer provider) {
        this.provider = provider;
    }

    /**
     *
     * @return The title of the current item.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return The uri of the current item.
     */
    public String getUri() {
        return uri;
    }

    /**
     *
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     *
     * @return the identifier of the current item in its provider database.
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
