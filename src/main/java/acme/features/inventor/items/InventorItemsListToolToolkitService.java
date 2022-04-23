package acme.features.inventor.items;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorItemsListToolToolkitService implements AbstractListService<Inventor, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorItemsRepository repository;

		// AbstractListService<Authenticated, Item> interface --------------


		@Override
		public boolean authorise(final Request<Item> request) {
			assert request != null;

			return true;
		}

		@Override
		public Collection<Item> findMany(final Request<Item> request) {
			assert request != null;

			Collection<Item> result;
			final int id= request.getModel().getInteger("id");
			result = this.repository.findToolsByToolkit( id);

			return result;
		}

		@Override
		public void unbind(final Request<Item> request, final Item entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "name", "code", "technology","price");
		}

}
