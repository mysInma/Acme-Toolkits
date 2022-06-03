
package acme.features.inventor.xustemu;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Item;
import acme.entities.xustemu.Xustemu;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorXustemuRepository extends AbstractRepository {

	//Quitar la llamada que no sea necesaria: Tool o Component

	@Query("SELECT c FROM Xustemu c WHERE c.code = :code")
	Xustemu findXustemuByCode(String code);

	@Query("select c from Xustemu c where c.id = :id")
	Xustemu findXustemuById(int id);

	@Query("SELECT i FROM Inventor i WHERE i.id = :id")
	Inventor findOneInventorById(int id);
	
	@Query("SELECT c FROM Xustemu c WHERE c.item.inventor.id = :inventorId and c.item.type = 0 and c.item.published = 1")
	Collection<Xustemu> findMyOwnsXustemuByTool(Integer inventorId);

	@Query("SELECT c FROM Xustemu c WHERE c.item.inventor.id = :inventorId and c.item.type = 1  and c.item.published = 1")
	Collection<Xustemu> findMyOwnsXustemuByComponent(Integer inventorId);
	
	@Query("SELECT i FROM Item i WHERE i.inventor.id = :id and i.type = 1 and i.published = 1")
    Collection<Item> getAllComponents(int id);

    @Query("SELECT i FROM Item i WHERE i.inventor.id = :id and i.type = 0  and i.published = 1")
    Collection<Item> getAllTools(int id);

	@Query("SELECT acceptedCurrencies FROM SystemConfiguration")
	String getAcceptedCurrencies();
	
	
	@Query("SELECT i FROM Item i WHERE i.id = :id")
	Optional<Item> findItemById(int id);

	
	@Query("SELECT i FROM Item i WHERE i.inventor.id = :inventorId")
    Collection<Item> findAllItemsByInventorId(int inventorId);
	

	@Query("select c from Xustemu c where c.item.id = :id")
	Xustemu findXustemuByItemId(int id);

}
