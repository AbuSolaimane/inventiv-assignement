package fr.inventivit.assignement.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import fr.inventivit.assignement.entities.listeners.CaseListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EntityListeners(CaseListener.class)
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "case_")
public class Case {

	@Id
	@Column(name = "caseid")
	@GenericGenerator(name = "caseSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = { @Parameter(name = "sequence_name", value = "case_seq"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "caseSequenceGenerator")
	private Long id;
	
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	@Column(insertable = false)
	private LocalDateTime lastUpdateDate;
	
	private String title;
	
	private String description;
}
