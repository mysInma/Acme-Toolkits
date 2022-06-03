
package acme.features.inventor.xustemu;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.xustemu.Xustemu;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorXustemuUpdateService implements AbstractUpdateService<Inventor, Xustemu> {

	@Autowired
	protected InventorXustemuRepository repository;


	@Override
	public boolean authorise(final Request<Xustemu> request) {
		assert request != null;

		boolean result;
		int masterId;
		Xustemu xustemu;
		Inventor inventor;

		masterId = request.getModel().getInteger("id");
		xustemu = this.repository.findXustemuById(masterId);
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

		if (!errors.hasErrors("creationMoment") && !errors.hasErrors("startDate") && !errors.hasErrors("finishDate")) {
			Calendar calendar;
			final Date minimumStartDate;
			final Date minimumFinishDate;

			calendar = new GregorianCalendar();

			calendar.setTime(entity.getCreationMoment());
			calendar.add(Calendar.MONTH, 1);
			minimumStartDate = calendar.getTime();

			calendar.setTime(entity.getStartDate());
			calendar.add(Calendar.DAY_OF_MONTH, 8);
			minimumFinishDate = calendar.getTime();

			errors.state(request, entity.getStartDate().after(entity.getCreationMoment()), "startDate", "inventor.xustemu.form.error.date-creation");
			errors.state(request, entity.getFinishDate().after(entity.getStartDate()), "finishDate", "inventor.xustemu.form.error.date-start");
			errors.state(request, entity.getStartDate().after(minimumStartDate), "startDate", "inventor.xustemu.form.error.too-close");
			errors.state(request, entity.getFinishDate().after(minimumFinishDate), "finishDate", "inventor.xustemu.form.error.too-close");
		}

		if (!errors.hasErrors("amount")) {
			final Boolean acceptedCurrency = this.repository.getAcceptedCurrencies().matches("(.*)" + entity.getAmount().getCurrency() + "(.*)");

			errors.state(request, entity.getAmount().getAmount() > 0, "budget", "inventor.xustemu.form.error.negative-budget");
			errors.state(request, acceptedCurrency, "budget", "inventor.xustemu.form.error.non-accepted-currency");
		}

		if (!errors.hasErrors("code")) {
			Xustemu existing;

			existing = this.repository.findXustemuByCode(entity.getCode());
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "inventor.xustemu.form.error.duplicated");
		}

	}

	@Override
	public void update(final Request<Xustemu> request, final Xustemu entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
