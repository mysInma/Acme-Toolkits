package acme.features.administrator.systemConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorSystemConfigurationShowService implements AbstractShowService<Administrator, SystemConfiguration>{

		// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorSystemConfigurationRepository repository;

		// AbstractShowService<Administrator, SystemConfiguration> interface ----------------


		@Override
		public boolean authorise(final Request<SystemConfiguration> request) {
			assert request != null;

			return true;
		}

		@Override
		public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
			assert request != null;

			return this.repository.findSystemConfiguration();
			
		

		}

		@Override
		public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "systemCurrency", "acceptedCurrencies", "strongSpamTerms", "strongThreshold", "weakSpamTerms", "weakThreshold");
		}
}