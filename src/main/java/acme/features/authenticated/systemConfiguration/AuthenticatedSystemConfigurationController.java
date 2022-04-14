package acme.features.authenticated.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.configuration.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedSystemConfigurationController extends AbstractController<Authenticated, SystemConfiguration>{

	@Autowired
	protected AuthenticatedSystemConfigurationShowService showSysConfigService;
	
	@PostConstruct
	protected void initialize() {
		super.addCommand("show", this.showSysConfigService);
	}
}
