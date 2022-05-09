package acme.features.administrator.announcement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.announcements.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement>{

		// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorAnnouncementRepository repository;

		// AbstractCreateService<Administrator, Announcement> interface --------------


		@Override
		public boolean authorise(final Request<Announcement> request) {
			assert request != null;

			return true;
		}

		@Override
		public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "title", "description", "critical", "link");
		}

		@Override
		public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "title", "description", "critical", "link");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", false);
		}

		@Override
		public Announcement instantiate(final Request<Announcement> request) {
			assert request != null;

			Announcement result;
			Date creationMoment;

			creationMoment = new Date(System.currentTimeMillis() - 1);

			result = new Announcement();
			result.setTitle("");
			result.setCreationMoment(creationMoment);
			result.setDescription("");
			result.setLink("");
			result.setCritical(false);

			return result;
		}

		@Override
		public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			final String description = entity.getDescription();
			
			if(!errors.hasErrors("description")) {
				final boolean maxLong = description.length() < 256;
				errors.state(request, maxLong, "description","administrator.announcement.description.error");
				
			}
			
			boolean confirmation;

			confirmation = request.getModel().getBoolean("confirmation");
			errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
		}

		@Override
		public void create(final Request<Announcement> request, final Announcement entity) {
			assert request != null;
			assert entity != null;

			Date creationMoment;

			creationMoment = new Date(System.currentTimeMillis() - 1);
			entity.setCreationMoment(creationMoment);
			this.repository.save(entity);
		}

}
