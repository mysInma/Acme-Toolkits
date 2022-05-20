package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("SELECT p FROM PatronageReport p WHERE p.id = :id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("SELECT p FROM PatronageReport p WHERE p.patronage.inventor.id = :inventorId")
	Collection<PatronageReport> findPatronageReportsByInventorId(int inventorId);
	
	@Query("SELECT strongSpamTerms FROM SystemConfiguration")
	String getStrongSpamTerms();
	
	@Query("SELECT weakSpamTerms FROM SystemConfiguration")
	String getWeakSpamTerms();
	
	@Query("SELECT strongThreshold FROM SystemConfiguration")
	Double getStrongThreshold();
	
	@Query("SELECT weakThreshold FROM SystemConfiguration")
	Double getWeakThreshold();
}
