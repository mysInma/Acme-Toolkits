package acme.features.any.userAccounts;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.entities.UserAccountStatus;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractShowService;

@Service
public class AnyUserAccountShowService  implements AbstractShowService<Any, UserAccount>{
	
		// Internal state ---------------------------------------------------------
	
		@Autowired
		protected AnyUserAccountRepository repository;
		
		// AbstractShowService<Any, UserAccount> interface --------------
		
		@Override
		public boolean authorise(final Request<UserAccount> request) {
			return true;
		}

	
		@Override
		public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
	
			StringBuilder result;
			Collection<UserRole> roles;
	
			request.unbind(entity, model, "identity.name", "identity.surname", "identity.email");
	
			roles = entity.getRoles();
			result = new StringBuilder();
			for (final UserRole role : roles) {
				result.append(role.getAuthorityName());
				result.append(" ");
			}
	
			model.setAttribute("roles", result.toString());
			
			if (entity.isEnabled()) {
				model.setAttribute("status", UserAccountStatus.ENABLED);
			} else {
				model.setAttribute("status", UserAccountStatus.DISABLED);
			}

			
		}
		
		
		@Override
		public UserAccount findOne(final Request<UserAccount> request) {
			assert request != null;
			UserAccount result;
			int id;
			
			id = request.getModel().getInteger("id");
			result = this.repository.findOneUserAccountById(id);
			result.getRoles().forEach(r -> {;});
			return result;
		}

}
