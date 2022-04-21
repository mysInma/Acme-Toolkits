package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageReportRepository extends AbstractRepository {

	@Query("SELECT p FROM PatronageReport p WHERE p.id = :id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("SELECT p FROM PatronageReport p WHERE p.patronage.patron.id = :patronId")
	Collection<PatronageReport> findPatronageReportsByPatronId(int patronId);
}
