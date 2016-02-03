package modules.searcher;

import models.entities.Item;
import services.ServiceConsumer;
import services.ServiceRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-02-02.
 */

/**
 *
 * A Searcher is responsible for handling search-related operations.
 * It holds the list of results obtained in the last search query.
 *
 */
public class Searcher {

    private List<Item> results;

    public Searcher() {
        results = new ArrayList<Item>();
    }

    /**
     * Runs a search over available services' databases.
     * @param terms Terms of the search.
     */
    public void search(String terms) {

        List<Item> results = new ArrayList<Item>();

        for (ServiceConsumer consumer:
                ServiceRegister.getInstance_().getServiceConsumers()) {
            results.addAll(consumer.search(terms));
        }
        this.results = results;
    }

    /**
     *
     * @return The list of results for the latest search operation run.
     */
    public List<Item> getResults() {
        return results;
    }
}
