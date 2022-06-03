package acme.features.any.xustemuDashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.form.XustemuDashboard;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class XustemuDashboradController extends AbstractController<Any, XustemuDashboard> {
	
	@Autowired
	protected XustemuDashboradShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}
	
}