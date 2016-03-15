package com.mustream.app.services;

import java.util.List;

import com.mustream.app.models.entities.Item;

/**
 * Created by davidkanaa on 16-01-29.
 */

public interface ServiceConsumer {
	
	List<Item> search(String terms);
	
	// TODO rest of necessary methods ...

}
