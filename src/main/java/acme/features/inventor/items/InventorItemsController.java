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
	
	@Autowired
	protected InventorItemsListToolToolkitService listToolToolkitService ;
	
	@Autowired
	protected InventorItemsListComponentToolkitService	listComponentToolkitService;
	
	@Autowired
	protected InventorItemsCreateService	createService;
	
	@Autowired
	protected InventorItemsUpdateService	updateService;
	
	@Autowired
	protected InventorItemsDeleteService	deleteService;
	
	@Autowired
	protected InventorItemsPublishedService	publishService;
	
	
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("publish", "update", this.publishService);
		
		
		super.addCommand("list-tool","list", this.listToolService);
		super.addCommand("list-component","list", this.listComponentService);
		
		super.addCommand("list-tool-toolkit","list", this.listToolToolkitService);
		super.addCommand("list-component-toolkit","list", this.listComponentToolkitService);
	}

}
