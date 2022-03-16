package acme.entities.announcements;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Announcement extends AbstractEntity{
	
		// Serialisation identifier -----------------------------------------------

		protected static final long		serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		@NotBlank
		@Size(max = 101, message = "Max 101 characters")
		protected String				title;

		@Temporal(TemporalType.TIMESTAMP)
		@Past
		@NotNull
		protected Date					moment;

		@NotNull
		protected AnnouncementStatus	status;

		@NotBlank
		@Size(max = 256, message = "Max 256 characters")
		protected String				text;

		@URL
		protected String				info;



}
