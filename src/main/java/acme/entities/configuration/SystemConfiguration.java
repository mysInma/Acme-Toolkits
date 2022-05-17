package acme.entities.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfiguration extends AbstractEntity {

		// Serialisation identifier -----------------------------------------------
	
	
		private static final long 		serialVersionUID = 1L;
		
		
		// Attributes ------------------------------------------------------------------
		
		@NotBlank
		protected String 				systemCurrency;
		
		@NotBlank
		protected String 				acceptedCurrencies;
		
		@NotBlank
		protected String 				strongSpamTerms;
		
		@Range(min=0,max=1)
		@NotNull
		@Digits(integer = 1, fraction = 2)
		protected Double 				strongThreshold;
		
		@NotBlank
		protected String 				weakSpamTerms;
		
		@Range(min=0,max=1)
		@NotNull
		@Digits(integer = 1, fraction = 2)
		protected Double 				weakThreshold;
		
		
}
