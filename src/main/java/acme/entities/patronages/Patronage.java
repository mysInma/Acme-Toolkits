package acme.entities.patronages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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

public class Patronage extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------
	
		protected static final long	serialVersionUID	= 1L;
			
		
	// Attributes -------------------------------------------------------------
		
	
		protected PatronageStatus	status;
		
		protected boolean			draftMode;
		
		@Pattern(regexp= "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
		@Column(unique = true)
		@NotBlank
		protected String code;
		
		@NotBlank
		@Length(min=1, max = 255)
		protected String legalStuff;
		
		@NotNull
		protected Money budget;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date creationMoment;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		protected Date startDate;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		protected Date finishDate;
		
		@URL
		protected String link;
		
	// Relationships ----------------------------------------------------------
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Patron patron;
		
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Inventor inventor;
	
	
	

}
