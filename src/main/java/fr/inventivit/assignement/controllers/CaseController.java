package fr.inventivit.assignement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.inventivit.assignement.dtos.CaseDto;
import fr.inventivit.assignement.service.CaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cases")
@RequiredArgsConstructor
public class CaseController {

	private final CaseService caseService;
	
	@GetMapping("{caseId}")
	public ResponseEntity<CaseDto> getCaseById(@PathVariable Long caseId) {
		
		return caseService.getCaseById(caseId);
	}
	
	@PutMapping("{caseId}")
	public ResponseEntity<CaseDto> updateCase(@PathVariable Long caseId, @RequestBody CaseDto newCase) {
		
		return caseService.updateCase(caseId, newCase);
	}
	
	@PostMapping
	public ResponseEntity<CaseDto> createCase(@RequestBody CaseDto newCase) {
		
		return caseService.createCase(newCase);
	}
	
	@DeleteMapping("{caseId}")
	public ResponseEntity<Void> deleteCaseById(@PathVariable Long caseId) {
		
		caseService.deleteCaseById(caseId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
