package acme.entities.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class Component extends AbstractEntity {
	
	protected static final long serialVersionUID	= 1L;
	
	
	//Attributes
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
	
	/*
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Tool tool;
	*/
	
	/*
	@NotNull
    @Valid
    @OneToOne(optional = false, mappedBy = "Patron")

    protected Patron patron;
	*/
	
}
