package acme.features.patron.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository {
	
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 'PROPOSED'")
	Integer numberOfProposedPatronages();
	
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 'ACCEPTED'")
	Integer numberOfAcceptedPatronages();
	
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 'DENIED'")
	Integer numberOfDeniedPatronages();
	
	@Query("SELECT p.budget.currency, avg(p.budget.amount), p.status FROM Patronage p GROUP BY p.budget.currency, p.status")
	List<String> averageBudgetOfPatronagesStatusByCurrency();
	
	@Query("SELECT p.budget.currency, stddev(p.budget.amount), p.status FROM Patronage p GROUP BY p.budget.currency, p.status")
	List<String> deviationBudgetOfPatronagesStatusByCurrency();
	
	@Query("SELECT p.budget.currency, min(p.budget.amount), p.status FROM Patronage p GROUP BY p.budget.currency, p.status")
	List<String> minimumBudgetOfPatronagesStatusByCurrency();
	
	@Query("SELECT p.budget.currency, max(p.budget.amount), p.status FROM Patronage p GROUP BY p.budget.currency, p.status")
	List<String> maximumBudgetOfPatronagesStatusByCurrency();
	
}
