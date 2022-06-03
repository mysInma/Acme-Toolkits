package acme.features.any.xustemuDashboard;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface XustemuDashboradRepository extends AbstractRepository {

	@Query("select count(c.item) from Xustemu c where c.item != null and c.item.type = 1")
	Integer totalNumberOfToolsWithXustemu();
	
	
	
	@Query("SELECT c.amount.currency ,avg(c.amount.amount),stddev(c.amount.amount),min(c.amount.amount),max(c.amount.amount) FROM Xustemu c WHERE c.item.type = 1 GROUP BY c.amount.currency")
	List<Object[]> findMetricsOfToolsByCurrency();
	
	@Query("select count(c.item) from Xustemu c where c.item != null and c.item.type = 0")
	Integer totalNumberOfComponentsWithXustemu();
	
	
	
	@Query("SELECT c.amount.currency ,avg(c.amount.amount),stddev(c.amount.amount),min(c.amount.amount),max(c.amount.amount) FROM Xustemu c WHERE c.item.type = 0 GROUP BY c.amount.currency")
	List<Object[]> findMetricsOfComponentsByCurrency();

}
