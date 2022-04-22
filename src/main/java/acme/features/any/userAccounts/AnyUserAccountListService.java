package acme.features.any.userAccounts;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.entities.UserAccountStatus;
import acme.framework.roles.Administrator;
import acme.framework.roles.Anonymous;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListService implements AbstractListService<Any,UserAccount>{
	
	@Autowired
	protected AnyUserAccountRepository userAccountRepository;
	
	@Override
	public boolean authorise(final Request<UserAccount> request){
		assert request != null;
		
		return true;
	}
	
	
	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder result;
		Collection<UserRole> roles;
		result = new StringBuilder();
		
		if (entity.isEnabled()) {
			model.setAttribute("status", UserAccountStatus.ENABLED);
		} else {
			model.setAttribute("status", UserAccountStatus.DISABLED);
		}
		

		request.unbind(entity, model, "username");

		if(!entity.hasRole(Anonymous.class) || !entity.hasRole(Administrator.class) || !entity.isEnabled()) {	
			roles = entity.getRoles();
			for (final UserRole role : roles) {
					result.append(role.getAuthorityName());
					result.append(",   ");
			}
		}

		model.setAttribute("roles", result.toString());
		
	}
	
	
	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request){
		assert request != null;

		Collection<UserAccount> result;

		result = this.userAccountRepository.findAllUserAccounts();
		result.removeIf(x -> x.hasRole(Anonymous.class) || x.hasRole(Administrator.class) || !x.isEnabled());
		for (final UserAccount userAccount : result) {
				userAccount.getRoles().forEach(r -> { ; });
		}

		return result;
	}

}
