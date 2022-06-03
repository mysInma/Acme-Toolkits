package acme.form;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class XustemuDashboard  implements Serializable {

    // Serialisation identifier -----------------------------------------------

    protected static final long    serialVersionUID    = 1L;

    // Attributes -------------------------------------------------------------
    
   
    
	Integer	totalNumberOfToolsWithXustemu;
	Integer	totalNumberOfComponentsWithXustemu;

    Map<String, Double> averageAmountOfToolsByCurrency;
    Map<String, Double> deviationAmountOfToolsByCurrency;
    Map<String, Double>	minimumAmountOfToolsByCurrency;
    Map<String, Double>	maximumAmountOfToolsByCurrency;
    Map<String, Double> averageAmountOfComponentsByCurrency;
    Map<String, Double> deviationAmountOfComponentsByCurrency;
    Map<String, Double>	minimumAmountOfComponentsByCurrency;
    Map<String, Double>	maximumAmountOfComponentsByCurrency;
}
