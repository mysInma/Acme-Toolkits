
package acme.features.inventor.xustemu;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.xustemu.Xustemu;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorXustemuController extends AbstractController<Inventor, Xustemu> {

	@Autowired
	protected InventorXustemuListService	listService;

	@Autowired
	protected InventorXustemuShowService	showService;

	@Autowired
	protected InventorXustemuCreateService	createService;

	@Autowired
	protected InventorXustemuDeleteService	deleteService;

	@Autowired
	protected InventorXustemuUpdateService	updateService;



	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);

		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);

	}

}
