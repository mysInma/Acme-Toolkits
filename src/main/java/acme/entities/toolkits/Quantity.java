package acme.entities.toolkits;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity {

	// Serialisation identifier -----------------------------------------
		
		private static final long 			serialVersionUID = 1L;
		
	// Attributes ------------------------------------------------------------------
		
		@Min(1)
		protected Integer 					value;
		
	// Relations --------------------------------------------------------
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Item 						item;
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Toolkit 					toolkit;

}
