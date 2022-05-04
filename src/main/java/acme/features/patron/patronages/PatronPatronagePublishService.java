package acme.features.patron.patronages;

import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronPatronagePublishService implements AbstractUpdateService<Patron, Patronage> {

	@Override
	public boolean authorise(final Request<Patronage> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		// TODO Auto-generated method stub
		
	}

}
