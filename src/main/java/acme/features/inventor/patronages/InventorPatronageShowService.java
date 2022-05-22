package acme.features.inventor.patronages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{

	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorPatronageRepository repository;

		// AbstractShowService<Employer, Patronage> interface ---------------------------


		@Override
		public boolean authorise(final Request<Patronage> request) {
			assert request != null;
			boolean result;
			
			final int id = request.getModel().getInteger("id");
			final Patronage patronage = this.repository.findPatronageById(id);
			final int myId = request.getPrincipal().getActiveRoleId();
			
			result = (patronage.getId() == myId || patronage.getInventor().getId() == myId);
			
			return result;
		}

		@Override
		public Patronage findOne(final Request<Patronage> request) {
			assert request != null;

			Patronage result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findPatronageById(id);

			return result;
		}

		@Override
		public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "status", "legalStuff", "budget", "creationMoment", "finishDate", "link");
			
			
			model.setAttribute("patronFullName", entity.getPatron().getUserAccount().getIdentity().getFullName());
	        model.setAttribute("patronName", entity.getPatron().getUserAccount().getIdentity().getName());
	        model.setAttribute("patronSurname", entity.getPatron().getUserAccount().getIdentity().getSurname());
	        model.setAttribute("patronEmail", entity.getPatron().getUserAccount().getIdentity().getEmail());
		}
}
