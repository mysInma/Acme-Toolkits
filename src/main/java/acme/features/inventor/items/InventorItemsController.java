package acme.features.inventor.items;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkits.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemsController extends AbstractController<Inventor, Item> {
	
	@Autowired
	protected InventorItemsListService listService;

	@Autowired
	protected InventorItemsShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
}