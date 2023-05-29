package fr.inventivit.assignement.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.inventivit.assignement.dtos.CaseDto;
import fr.inventivit.assignement.entities.Case;
import fr.inventivit.assignement.exceptions.EntityNotFoundException;
import fr.inventivit.assignement.repositories.CaseRepository;
import fr.inventivit.assignement.service.CaseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

	private final CaseRepository caseRepository;

	@Override
	public ResponseEntity<CaseDto> getCaseById(Long caseId) {
		
		Case caseEntity = caseRepository.findById(caseId).orElseThrow(() -> new EntityNotFoundException("the case with ID: " + caseId + " doesn't exist"));

		return  new ResponseEntity<CaseDto>(CaseDto.convertToDto(caseEntity), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CaseDto> updateCase(Long caseId, CaseDto newCase) {
		
		Case caseEntity = caseRepository.findById(caseId).orElseThrow(() -> new EntityNotFoundException("the case with ID: " + caseId + " doesn't exist"));
		caseEntity.setTitle(newCase.getTitle());
		caseEntity.setDescription(newCase.getDescription());
		
		caseEntity = caseRepository.saveAndFlush(caseEntity);
		return new ResponseEntity<CaseDto>(CaseDto.convertToDto(caseEntity), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CaseDto> createCase(CaseDto newCase) {
		
		Case caseEntity = newCase.convertToEntity();
		
		caseEntity = caseRepository.saveAndFlush(caseEntity);
		
		return new ResponseEntity<CaseDto>(CaseDto.convertToDto(caseEntity), HttpStatus.CREATED);
	}

	@Override
	public void deleteCaseById(Long caseId) {
		
		Case caseEntity = caseRepository.findById(caseId).orElseThrow(() -> new EntityNotFoundException("the case with ID: " + caseId + " doesn't exist"));
		
		caseRepository.delete(caseEntity);
	}
}
