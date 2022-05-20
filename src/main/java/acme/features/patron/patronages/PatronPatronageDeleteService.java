package acme.features.patron.patronages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;

@Service
public class PatronPatronageDeleteService implements AbstractDeleteService<Patron, Patronage> {

	@Autowired
	protected PatronPatronageRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		final boolean result;
		int patronageId;
		Patronage patronage;
		Patron patron;
		
		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(patronageId);
		patron = patronage.getPatron();
		
		result = patronage.isDraftMode() && request.isPrincipal(patron);
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "creationMoment", "startDate", "finishDate", "link");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		request.unbind(entity, model, "status", "draftMode", "code", "legalStuff", "budget", "creationMoment", "startDate", "finishDate", "link");
		
		model.setAttribute("inventorFullName", entity.getInventor().getUserAccount().getIdentity().getFullName());
		model.setAttribute("inventorName", entity.getInventor().getUserAccount().getIdentity().getName());
		model.setAttribute("inventorSurname", entity.getInventor().getUserAccount().getIdentity().getSurname());
		model.setAttribute("inventorEmail", entity.getInventor().getUserAccount().getIdentity().getEmail());
		
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
		
		if (!errors.hasErrors("code")) {
			Patronage existing;

			existing = this.repository.findPatronageByCode(entity.getCode());
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "patron.patronage.form.error.duplicated");
		}
		
	}

	@Override
	public void delete(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		// DELETE CASCADE
		this.repository.deleteAll(this.repository.findPatronageReportsByPatronageId(entity.getId()));
		
		this.repository.delete(entity);
		
	}

}
