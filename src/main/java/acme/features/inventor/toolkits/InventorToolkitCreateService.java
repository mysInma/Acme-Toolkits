package acme.features.inventor.toolkits;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamDetector;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit>{
	
	@Autowired
	protected InventorToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity,final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "title", "description", "notes", "link", "published");
	
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "code", "title", "description", "notes", "link", "published");
	
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;

		final Toolkit result;
		final Inventor inventor;

		inventor = this.repository.findInventorById(request.getPrincipal().getActiveRoleId());
		result = new Toolkit();
		result.setCode("");
		result.setDescription("");
		result.setInventor(inventor);
		result.setTitle("");
		result.setLink("");
		result.setNotes("");
		result.setPublished(false);
		

		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("title")) {
			final List<String> legalStuffWords = Arrays.asList(entity.getTitle().split(" "));
			final List<String> strongSpamTerms = Arrays.asList(this.repository.getStrongSpamTerms().split(","));
			final List<String> weakSpamTerms = Arrays.asList(this.repository.getWeakSpamTerms().split(","));
			final Double strongThreshold = this.repository.getStrongThreshold();
			final Double weakThreshold = this.repository.getWeakThreshold();
			
			
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, weakSpamTerms, weakThreshold), "title", "inventor.toolkit.form.error.spam");
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, strongSpamTerms, strongThreshold), "title", "inventor.toolkit.form.error.spam");
		}
		
		if(!errors.hasErrors("description")) {
			final List<String> legalStuffWords = Arrays.asList(entity.getDescription().split(" "));
			final List<String> strongSpamTerms = Arrays.asList(this.repository.getStrongSpamTerms().split(","));
			final List<String> weakSpamTerms = Arrays.asList(this.repository.getWeakSpamTerms().split(","));
			final Double strongThreshold = this.repository.getStrongThreshold();
			final Double weakThreshold = this.repository.getWeakThreshold();
			
			
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, weakSpamTerms, weakThreshold), "description", "inventor.toolkit.form.error.spam");
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, strongSpamTerms, strongThreshold), "description", "inventor.toolkit.form.error.spam");
		}
		
		if(!errors.hasErrors("notes")) {
			final List<String> legalStuffWords = Arrays.asList(entity.getNotes().split(" "));
			final List<String> strongSpamTerms = Arrays.asList(this.repository.getStrongSpamTerms().split(","));
			final List<String> weakSpamTerms = Arrays.asList(this.repository.getWeakSpamTerms().split(","));
			final Double strongThreshold = this.repository.getStrongThreshold();
			final Double weakThreshold = this.repository.getWeakThreshold();
			
			
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, weakSpamTerms, weakThreshold), "notes", "inventor.toolkit.form.error.spam");
			errors.state(request, !SpamDetector.detectSpam(legalStuffWords, strongSpamTerms, strongThreshold), "notes", "inventor.toolkit.form.error.spam");
		}
		
		if (!errors.hasErrors("code")) {
			Toolkit existing;

			existing = this.repository.findToolkitByCode(entity.getCode());
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "inventor.toolkit.form.error.code.duplicated");
		}
		
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}
	
	
	

}
