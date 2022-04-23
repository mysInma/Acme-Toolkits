package acme.features.any.toolkits;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Toolkit;
import acme.framework.datatypes.Money;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository  extends AbstractRepository{
	
	@Query("SELECT t FROM Toolkit t WHERE t.published=1")
	Collection<Toolkit> findToolkitsPublished();
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findToolkitById(int id);
	
	@Query("SELECT q.item.price FROM Quantity q WHERE q.toolkit.id = :id")
	Collection<Money> collectPrices(int id);
	
	
	@Query("select c.systemCurrency from SystemConfiguration c")
	String systemCurrency();

}
