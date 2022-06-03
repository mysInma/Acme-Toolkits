
package acme.features.inventor.xustemu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.xustemu.Xustemu;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorXustemuDeleteService implements AbstractDeleteService<Inventor, Xustemu> {

	@Autowired
	protected InventorXustemuRepository repository;


	@Override
	public boolean authorise(final Request<Xustemu> request) {
		assert request != null;

		boolean result;
		int id;
		Xustemu xustemu;
		Inventor inventor;

		id = request.getModel().getInteger("id");
		xustemu = this.repository.findXustemuById(id);
		inventor = xustemu.getItem().getInventor();
		result = request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Xustemu> request, final Xustemu entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "creationMoment", "subject", "summary", "startDate", "finishDate", "amount", "moreInfo");

	}

	@Override
	public void unbind(final Request<Xustemu> request, final Xustemu entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "code", "creationMoment", "subject", "summary", "startDate", "finishDate", "amount", "moreInfo");

	}

	@Override
	public Xustemu findOne(final Request<Xustemu> request) {
		assert request != null;

		Xustemu result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findXustemuById(id);

		return result;
	}

	@Override
	public void validate(final Request<Xustemu> request, final Xustemu entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Xustemu> request, final Xustemu entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
