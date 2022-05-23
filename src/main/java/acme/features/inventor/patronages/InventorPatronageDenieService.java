package acme.features.inventor.patronages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.entities.patronages.PatronageStatus;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageDenieService  implements AbstractUpdateService<Inventor, Patronage>{
	
	@Autowired
	protected InventorPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request!=null;
		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "legalStuff", "budget", "creationMoment", "finishDate", "link");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "legalStuff", "budget", "creationMoment", "finishDate", "link");
		
		
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
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		entity.setStatus(PatronageStatus.DENIED);
		this.repository.save(entity);
		
	}

}
