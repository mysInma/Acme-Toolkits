
package acme.features.inventor.xustemu;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.xustemu.Xustemu;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorXustemuListService implements AbstractListService<Inventor, Xustemu> {

	
	@Autowired
	protected InventorXustemuRepository repository;


	@Override
	public boolean authorise(final Request<Xustemu> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Xustemu> findMany(final Request<Xustemu> request) {
		assert request != null;

		Collection<Xustemu> result;
		int id;

		id = request.getPrincipal().getActiveRoleId();
		result = this.repository.findMyOwnsXustemuByComponent(id);

		return result;
	}

	
	@Override
	public void unbind(final Request<Xustemu> request, final Xustemu entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "creationMoment", "subject", "item");
		model.setAttribute("codeItem", entity.getItem().getCode());

	}

}
