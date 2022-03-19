package acme.roles;

import javax.persistence.Entity;

import acme.framework.roles.UserRole;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Inventor extends UserRole {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	// Relationships ----------------------------------------------------------
	
	

}
