package acme.entities.toolkits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Item extends AbstractEntity {

	// Serialisation identifier ------------------------------------------------------------------
	
		private static final long 				serialVersionUID = 1L;
		
		
	// Attributes ------------------------------------------------------------------
		
		@NotBlank
		@Length(min=1,max=100)
		protected String 						name;
		
		@Pattern(regexp= "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
		@Column(unique = true)
		@NotBlank
		protected String 						code;
		
		@NotBlank
		@Length(min=1,max=100)
		protected String 						technology;
		
		@NotBlank
		@Length(min=1,max=255)
		protected String 						description;
		
		@NotNull
		protected Money 						price;
		
		@URL
		protected String 						link;
		
		protected boolean						published;
		
		protected ItemType 						type;
		
		
		
	// Relations ---------------------------------------------------------
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Inventor inventor;
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Patron patron;
		
}
