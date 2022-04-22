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
	protected InventorToolListService		listToolService;
	
	@Autowired
	protected InventorComponentListService	listComponentService;
	
	@Autowired
	protected InventorItemsShowService showService;
	
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-tool","list", this.listToolService);
		super.addCommand("list-component","list", this.listComponentService);
	}

}
