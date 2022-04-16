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

		//@Autowired
		//protected AdministratorItemsShowComponentService 	showComponentService;;	

		// Constructors -----------------------------------------------------------

		
		@PostConstruct
		protected void initialise() {
			//super.addCommand("show", this.showComponentService);
			super.addCommand("list-component", "list", this.listComponentService);
		}
	

}
