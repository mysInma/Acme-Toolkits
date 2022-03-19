package acme.entities.patronages;


import java.util.Date;

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

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long serialVersionUID = 1L;
		protected static long serialNumber = 1L;
		
	// Attributes -------------------------------------------------------------
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date creationMoment;
		
		@NotBlank
		@Length(min=1, max = 255)
		protected String memorandum;
		
		@URL
		protected String link;
		
	// Derived attributes -----------------------------------------------------
		
		@NotBlank
		@Pattern(regexp= "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$:[0-9]{4}")
		public String getSequenceNumber() {
			String result = "";
			final String patron = this.getPatronage().getCode();
			
			if (PatronageReport.serialNumber < 10L) {
				result = patron + ":000" + PatronageReport.serialNumber;
			} else if (PatronageReport.serialNumber >= 10L && PatronageReport.serialNumber < 100L) {
				result = patron + ":00" + PatronageReport.serialNumber;
			} else if (PatronageReport.serialNumber >= 100L && PatronageReport.serialNumber < 1000L) {
				result = patron + ":0" + PatronageReport.serialNumber;
			} else {
				result = patron + ":" + PatronageReport.serialNumber;
			}
			
			PatronageReport.serialNumber++;
			
			return result;
		}
		
		
		
	// Relationships ----------------------------------------------------------
		
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Patronage patronage;
	
	
}
