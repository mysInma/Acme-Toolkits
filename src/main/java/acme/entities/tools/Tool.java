package acme.entities.tools;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;

public class Tool extends AbstractEntity{
	
	protected static final long serialVersionUID	= 1L;
	
	
	@NotBlank
	@Max(100)
	protected String name;
	
	@Pattern(regexp= "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String code;
	
	@NotBlank
	@Max(100)
	protected String technology;
	
	@NotBlank
	@Max(255)
	protected String description;
	
	@Min(0)
	protected Integer price;
	
	@URL
	protected String link;
	

}
