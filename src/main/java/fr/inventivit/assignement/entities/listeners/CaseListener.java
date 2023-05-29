package fr.inventivit.assignement.entities.listeners;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import fr.inventivit.assignement.entities.Case;

public class CaseListener {

	@PrePersist
    private void beforeCreate(Case caseEntity) {
		
		caseEntity.setCreationDate(LocalDateTime.now());
    }
    
	@PreUpdate
    private void beforeUpdate(Case caseEntity) {
		
		caseEntity.setLastUpdateDate(LocalDateTime.now());
    }
}
