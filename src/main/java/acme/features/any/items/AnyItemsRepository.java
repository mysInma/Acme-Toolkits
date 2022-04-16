package acme.features.any.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.toolkits.Item;
import acme.framework.repositories.AbstractRepository;

public interface AnyItemsRepository extends AbstractRepository {
	

	@Query("select i from Item i WHERE i.type = 0")
	Collection<Item> findAllComponents();
	
	@Query("select i from Item i WHERE i.type = 1")
	Collection<Item> findAllTools();

}
