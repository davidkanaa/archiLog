package modules.searcher;

import models.entities.Item;
import services.ServiceConsumer;
import services.ServiceRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidkanaa on 16-02-02.
 */
public class Searcher {

    List<Item> results;

    public Searcher() {
        results = new ArrayList<Item>();
    }

    public void search(String terms) {

        List<Item> results = new ArrayList<Item>();

        for (ServiceConsumer consumer:
                ServiceRegister.getInstance_().getServiceConsumers()) {
            results.addAll(consumer.search(terms));
        }
        this.results = results;
    }

    public List<Item> getResults() {
        return results;
    }
}
