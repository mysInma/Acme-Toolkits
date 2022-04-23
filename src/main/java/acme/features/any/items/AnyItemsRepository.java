package acme.features.any.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.toolkits.Item;
import acme.framework.repositories.AbstractRepository;

public interface AnyItemsRepository extends AbstractRepository {
	
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select i from Item i WHERE i.type = 0 and i.published= 1")
	Collection<Item> findToolsPublished();
	
	@Query("select i from Item i WHERE i.type = 1 and i.published= 1 ")
	Collection<Item> findComponentsPublished();

	@Query("select q.item from Quantity q WHERE q.toolkit.id = :id and q.item.type = 0")
	Collection<Item> findToolsByToolkit(int id);
	
	@Query("select q.item from Quantity q WHERE q.toolkit.id = :id and q.item.type = 1")
	Collection<Item> findComponentsByToolkit(int id);

}
