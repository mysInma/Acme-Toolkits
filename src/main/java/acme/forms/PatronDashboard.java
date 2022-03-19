package acme.forms;

import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronages.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard {

	// Attributes -------------------------------------------------------------

	protected Map<PatronageStatus, Integer> 				totalNumberOfPatronagesByStatus;
	
	protected Map<Pair<String, PatronageStatus>, Double> 	averageBudgetOfPatronagesStatusByCurrency;
	
	protected Map<Pair<String, PatronageStatus>, Double> 	deviationBudgetOfPatronagesStatusByCurrency;
	
	protected Map<Pair<String, PatronageStatus>, Double> 	minimumBudgetOfPatronagesStatusByCurrency;
	
	protected Map<Pair<String, PatronageStatus>, Double> 	maximumBudgetOfPatronagesStatusByCurrency;
	
}
