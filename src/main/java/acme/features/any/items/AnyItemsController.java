package acme.features.any.items;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkits.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemsController extends AbstractController<Any, Item>{
	
		// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyItemsListComponentService	listComponentService;
		
		@Autowired
		protected AnyItemsListToolService	listToolService;
		
		@Autowired
		protected AnyItemsShowService 	showService;
		
		@Autowired
		protected AnyItemsListToolToolkitService listToolToolkitService ;
		
		@Autowired
		protected AnyItemsListComponentToolkitService	listComponentToolkitService;

		// Constructors -----------------------------------------------------------

		@PostConstruct
		protected void initialise() {
			super.addCommand("show", this.showService);
			super.addCommand("list-component", "list", this.listComponentService);
			super.addCommand("list-tool", "list", this.listToolService);
			super.addCommand("list-tool-toolkit","list", this.listToolToolkitService);
			super.addCommand("list-component-toolkit","list", this.listComponentToolkitService);
		}
	

}
