package acme.features.inventor.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemsRepository extends AbstractRepository {
	
	@Query("SELECT i FROM Item i WHERE i.id = :id and i.type = 0")
	Item findOneToolById(int id);
	
	@Query("SELECT i FROM Item i WHERE i.id = :id and i.type = 1")
	Item findOneComponentlById(int id);
	
	@Query("SELECT i FROM Item i WHERE i.id = :id")
	Item findOneById(int id);
	
	@Query("SELECT i FROM Item i WHERE i.inventor.id = :inventorId and i.type = 0")
	Collection<Item> findMyOwnsTools(Integer inventorId);

	@Query("SELECT i FROM Item i WHERE i.inventor.id = :inventorId and i.type = 1")
	Collection<Item> findOwnsComponents(Integer inventorId);

}
