package acme.features.inventor.patronageReport;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.patronages.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

public class InventorPatronageReportController extends AbstractController<Inventor, PatronageReport> {
	
	// Internal state ---------------------------------------------------------

			@Autowired
			protected InventorPatronageReportListService		listService;

			@Autowired
			protected InventorPatronageReportShowService		showService;

			// Constructors -----------------------------------------------------------

			@PostConstruct
			protected void initialise() {
				super.addCommand("list", this.listService);
				super.addCommand("show", this.showService);
			}

}
