package acme.features.inventor.patronageReport;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamDetector;
import acme.entities.patronages.Patronage;
import acme.entities.patronages.PatronageReport;
import acme.features.inventor.patronages.InventorPatronageRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	@Autowired
	private InventorPatronageReportRepository repository;
	
	@Autowired
	private InventorPatronageRepository patronageRepository;
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request!=null;
		return true;
	}
	
	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "memorandum", "link", "patronage");
		model.setAttribute("readonly", false);
		model.setAttribute("confirmation", false);
		model.setAttribute("patronageCollection", this.patronageRepository.findPatronagesByInventorId(request.getPrincipal().getActiveRoleId()));
	}
	
	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		
		final PatronageReport result;
		Date creationMoment;
		
		creationMoment = new Date(System.currentTimeMillis() - 1);
		
		result = new PatronageReport();
		result.setPatronage(null);
		result.setCreationMoment(creationMoment);
		result.setLink("");
		result.setMemorandum("");
		
		return result;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment", "memorandum", "link");
		final int patronageId = Integer.parseInt((String) request.getModel().getAttribute("patronage"));
		final Patronage patronage = this.patronageRepository.findPatronageById(patronageId);
		entity.setPatronage(patronage);
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final String memorandum = entity.getMemorandum();
		
		if(!errors.hasErrors("memorandum")) {
			final boolean maxLong = memorandum.length() < 256;
			errors.state(request, maxLong, "memorandum", "inventor.patronage-report.memorandum.error");
			
			final List<String> memorandumWords = Arrays.asList(entity.getMemorandum().split(" "));
			final List<String> strongSpamTerms = Arrays.asList(this.repository.getStrongSpamTerms().split(","));
			final List<String> weakSpamTerms = Arrays.asList(this.repository.getWeakSpamTerms().split(","));
			final Double strongThreshold = this.repository.getStrongThreshold();
			final Double weakThreshold = this.repository.getWeakThreshold();
			
			
			errors.state(request, !SpamDetector.detectSpam(memorandumWords, weakSpamTerms, weakThreshold), "memorandum", "inventor.patronage.form.error.spam");
			errors.state(request, !SpamDetector.detectSpam(memorandumWords, strongSpamTerms, strongThreshold), "memorandum", "inventor.patronage.form.error.spam");
		}
		
		boolean confirmation;
		
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;

		Date creationMoment;

		creationMoment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
	}
	
}
