package fr.inventivit.assignement.dtos;

import java.time.LocalDateTime;

import fr.inventivit.assignement.entities.Case;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CaseDto {

	private Long id;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime lastUpdateDate;
	
	private String title;
	
	private String description;
	
	public static CaseDto convertToDto(Case caseEntity) {
		
		CaseDto caseDto = new CaseDto();
		caseDto.setId(caseEntity.getId());
		caseDto.setCreationDate(caseEntity.getCreationDate());
		caseDto.setLastUpdateDate(caseEntity.getLastUpdateDate());
		caseDto.setTitle(caseEntity.getTitle());
		caseDto.setDescription(caseEntity.getDescription());
		
		return caseDto;
	}
	
	public Case convertToEntity() {
		
		Case caseEntity = new Case();
		caseEntity.setId(this.getId());
		caseEntity.setTitle(this.getTitle());
		caseEntity.setDescription(this.getDescription());
		
		return caseEntity;
	}
}
