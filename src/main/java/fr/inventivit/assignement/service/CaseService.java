package fr.inventivit.assignement.service;

import org.springframework.http.ResponseEntity;

import fr.inventivit.assignement.dtos.CaseDto;

public interface CaseService {

	ResponseEntity<CaseDto> getCaseById(Long caseId);

	ResponseEntity<CaseDto> updateCase(Long caseId, CaseDto newCase);

	ResponseEntity<CaseDto> createCase(CaseDto newCase);

	void deleteCaseById(Long caseId);

}
