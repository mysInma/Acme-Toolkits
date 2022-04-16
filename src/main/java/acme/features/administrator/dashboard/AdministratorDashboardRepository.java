package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("SELECT count(i) FROM Item i WHERE i.type = 'COMPONENT'")
	Integer totalNumberOfComponents();
	
	@Query("SELECT i.price.currency,avg(i.price.amount),i.technology FROM Item i WHERE i.type = 'COMPONENT' GROUP BY i.price.currency, i.technology")
	List<String> averageRetailPriceOfComponentsByTechnologyCurrency();
	
	@Query("SELECT i.price.currency,stddev(i.price.amount),i.technology FROM Item i WHERE i.type = 'COMPONENT' GROUP BY i.price.currency, i.technology")
	List<String> deviationRetailPriceOfComponentsByTechnologyCurrency();
	
	@Query("SELECT i.price.currency,min(i.price.amount),i.technology FROM Item i WHERE i.type = 'COMPONENT' GROUP BY i.price.currency, i.technology")
	List<String> minimumRetailPriceOfComponentsByTechnologyCurrency();
	
	@Query("SELECT i.price.currency,max(i.price.amount),i.technology FROM Item i WHERE i.type = 'COMPONENT' GROUP BY i.price.currency, i.technology")
	List<String> maximumRetailPriceOfComponentsByTechnologyCurrency();
	
	@Query("SELECT count(i) FROM Item i WHERE i.type = 'TOOL'")
	Integer totalNumberOfTools();
	
	@Query("SELECT i.price.currency,avg(i.price.amount) FROM Item i WHERE i.type = 'TOOL' GROUP BY i.price.currency")
	List<String> averageRetailPriceOfToolsByCurrency();
	
	@Query("SELECT i.price.currency,stddev(i.price.amount) FROM Item i WHERE i.type = 'TOOL' GROUP BY i.price.currency")
	List<String> deviationRetailPriceOfToolsByCurrency();
	
	@Query("SELECT i.price.currency,min(i.price.amount) FROM Item i WHERE i.type = 'TOOL' GROUP BY i.price.currency")
	List<String> minimumRetailPriceOfToolsByCurrency();
	
	@Query("SELECT i.price.currency,max(i.price.amount) FROM Item i WHERE i.type = 'TOOL' GROUP BY i.price.currency")
	List<String> maximumRetailPriceOfToolsByCurrency();
	
	@Query("SELECT p.status,count(p) FROM Patronage p GROUP BY p.status")
	List<String> totalNumberOfPatronagesByStatus();
	
	@Query("SELECT p.status,avg(p.budget.amount) FROM Patronage p GROUP BY p.status")
	List<String> averagePatronagesBudgetByStatus();
	
	@Query("SELECT p.status,stddev(p.budget.amount) FROM Patronage p GROUP BY p.status")
	List<String> deviationPatronagesBudgetByStatus();
	
	@Query("SELECT p.status,min(p.budget.amount) FROM Patronage p GROUP BY p.status")
	List<String> minimumPatronagesBudgetByStatus();
	
	@Query("SELECT p.status,max(p.budget.amount) FROM Patronage p GROUP BY p.status")
	List<String> maximumPatronagesBudgetByStatus();

}
