package acme.entities.specificUserRoles;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class SpecificUserRole extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------
		
		protected static final long serialVersionUID = 1L;
		
		
	// Attributes -------------------------------------------------------------
		
		@NotBlank
		@Length(min=1, max=100)
		protected String company;
		
		@NotBlank
		@Length(min=1, max=255)
		protected String statement;
		
		@URL
		protected String link;
		
		
	// Relationships ----------------------------------------------------------
		
		@Valid
		protected Patron patron;
		
		@Valid
		protected Inventor inventor;
	

}
