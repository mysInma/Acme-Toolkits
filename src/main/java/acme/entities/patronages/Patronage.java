package acme.entities.patronages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

public class Patronage extends AbstractEntity{
	
	protected static final long serialVersionUID = 1L;
	
	//Atributes
	
	protected PatronageStatus	status;
	
	@Pattern(regexp= "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String code;
	
	@NotBlank
	@Length(max = 255)
	protected String legalStuff;
	
	@Min(0)
	protected Integer budget;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date periodOfTime;
	
	@URL
	protected String link;
	
	//Relaciones
	
	@NotNull
	@Valid
	@OneToOne(optional = false, mappedBy = "Patron")
	
	protected Patron patron;
	
	@NotNull
	@Valid
	@OneToOne(optional = false, mappedBy = "Inventor")
	
	protected Inventor inventor;
	
	
	

}
