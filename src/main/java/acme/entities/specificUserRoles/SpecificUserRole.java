package acme.entities.specificUserRoles;

import javax.persistence.Entity;
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
	
	protected static final long serialVersionUID = 1L;
	
	
	//Atributes
	
	@NotBlank
	@Length(max=100)
	protected String company;
	
	@NotBlank
	@Length(max=255)
	protected String statement;
	
	@URL
	protected String link;
	
	
	// Relationships ----------------------------------------------------------
	
	protected Patron patron;
	
	protected Inventor inventor;
	

}
