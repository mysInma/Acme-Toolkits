package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Item;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorQuantityRepository extends AbstractRepository{

	@Query("SELECT i FROM Item i WHERE i.published = true")
	List<Item> findPublishedItems();
	
	@Query("SELECT i FROM Item i WHERE i.published = false AND i.inventor = :id")
	List<Item> findNonPublishedItemsByInventorId(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findToolkitById(int id);

	@Query("SELECT q FROM Quantity q WHERE q.id = :id")
	Quantity findQuantityById(int id);

	@Query("SELECT q FROM Quantity q WHERE q.toolkit.id = :id")
	Collection<Quantity> findQuantitiesByToolkitId(int id);

	@Query("SELECT q.item FROM Quantity q WHERE q.id = :id")
	Item findItemByQuantityId(int id);

	@Query("SELECT i FROM Item i WHERE i.id = :itemId")
	Item findItemById(Integer itemId);

	@Query("SELECT q.toolkit FROM Quantity q WHERE q.id = :id")
	Toolkit findToolkitByQuantityId(int id);
}
