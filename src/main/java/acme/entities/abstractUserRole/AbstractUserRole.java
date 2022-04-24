package acme.entities.abstractUserRole;

import javax.persistence.Entity;
import javax.validation.Valid;

import acme.framework.entities.AbstractEntity;
import acme.framework.roles.Administrator;
import acme.framework.roles.Anonymous;
import acme.framework.roles.Authenticated;
import acme.roles.Consumer;
import acme.roles.Provider;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AbstractUserRole extends AbstractEntity {

	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

	// Relationships ----------------------------------------------------------

		@Valid
		protected Anonymous anonymous;
		
		@Valid
		protected Administrator administrator;
		
		@Valid
		protected Authenticated authenticated;
		
		@Valid
		protected Consumer consumer;
		
		@Valid
		protected Provider provider; 
		
		
		
		
}
