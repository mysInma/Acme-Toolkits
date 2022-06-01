
package acme.features.inventor.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Item;
import acme.entities.toolkits.Quantity;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemsRepository extends AbstractRepository {

	@Query("SELECT i FROM Item i WHERE i.id = :id and i.type = 0")
	Item findOneToolById(int id);

	@Query("SELECT i FROM Item i WHERE i.id = :id and i.type = 1")
	Item findOneComponentlById(int id);

	@Query("SELECT i FROM Item i WHERE i.id = :id")
	Item findOneById(int id);

	@Query("SELECT i FROM Inventor i WHERE i.id = :id")
	Inventor findOneInventorById(int id);

	@Query("SELECT i FROM Item i WHERE i.inventor.id = :inventorId and i.type = 0")
	Collection<Item> findMyOwnsTools(Integer inventorId);

	@Query("SELECT i FROM Item i WHERE i.inventor.id = :inventorId and i.type = 1")
	Collection<Item> findOwnsComponents(Integer inventorId);

	@Query("select q.item from Quantity q WHERE q.toolkit.id = :id and q.item.type = 0")
	Collection<Item> findToolsByToolkit(int id);

	@Query("select q.item from Quantity q WHERE q.toolkit.id = :id and q.item.type = 1")
	Collection<Item> findComponentByToolkit(int id);

	@Query("SELECT i FROM Item i WHERE i.code = :code and i.type = 1")
	Item findOneComponentByCode(String code);
	
	@Query("SELECT i FROM Item i WHERE i.code = :code")
	Item findOneByCode(String code);

	@Query("SELECT acceptedCurrencies FROM SystemConfiguration")
	String getAcceptedCurrencies();
	
	@Query("SELECT strongSpamTerms FROM SystemConfiguration")
	String getStrongSpamTerms();
	
	@Query("SELECT weakSpamTerms FROM SystemConfiguration")
	String getWeakSpamTerms();
	
	@Query("SELECT strongThreshold FROM SystemConfiguration")
	Double getStrongThreshold();
	
	@Query("SELECT weakThreshold FROM SystemConfiguration")
	Double getWeakThreshold();

	@Query("SELECT q FROM Quantity q WHERE q.item.id = :id")
	Collection<Quantity> getQuantityByItem(int id);

}
