package acme.features.any.userAccounts;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyUserAccountRepository extends AbstractRepository {

	@Query("SELECT user FROM UserAccount user WHERE user.id = :id")
	UserAccount findOneUserAccountById(int id);
	
	@Query("SELECT ua FROM UserAccount ua ")
	Collection<UserAccount> findAllUserAccounts();
	
}
