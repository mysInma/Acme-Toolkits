
package acme.entities.xustemu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.toolkits.Item;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Xustemu extends AbstractEntity {

	

	// Serialisation identifier ------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	//@Pattern(regexp = "^([0-9]{2}-[0-9]{2}-[0-9]{2}?$")
	//@Pattern(regexp ="^\\d{2}-ddmmyy$")
	protected String			code;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date				creationMoment;

	@NotBlank
	@Length(min = 1, max = 100)
	protected String			subject;

	@NotBlank
	@Length(min = 1, max = 255)
	protected String			summary;

	//@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startDate;

	//@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				finishDate;

	@NotNull
	protected Money				amount;

	@URL
	protected String			moreInfo;

	// Relations ---------------------------------------------------------

	@Valid
	@NotNull
	@OneToOne(optional = false)
	protected Item				item;
}
