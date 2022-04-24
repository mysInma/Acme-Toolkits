package acme.features.patron.patronages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage>{
	
	@Autowired
	protected PatronPatronageRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean result;
		
		final int id = request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findPatronageById(id);
		final int myId = request.getPrincipal().getActiveRoleId();
		
		result = (patronage.getId() == myId || patronage.getPatron().getId() == myId);
		
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
		
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "creationMoment", "startDate", "finishDate","link");
		
		model.setAttribute("inventorFullName", entity.getInventor().getUserAccount().getIdentity().getFullName());
		model.setAttribute("inventorName", entity.getInventor().getUserAccount().getIdentity().getName());
		model.setAttribute("inventorSurname", entity.getInventor().getUserAccount().getIdentity().getSurname());
		model.setAttribute("inventorEmail", entity.getInventor().getUserAccount().getIdentity().getEmail());
		
		
		
	}

}
