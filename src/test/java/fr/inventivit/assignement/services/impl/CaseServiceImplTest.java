package fr.inventivit.assignement.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.inventivit.assignement.dtos.CaseDto;
import fr.inventivit.assignement.entities.Case;
import fr.inventivit.assignement.exceptions.EntityNotFoundException;
import fr.inventivit.assignement.repositories.CaseRepository;
import fr.inventivit.assignement.service.impl.CaseServiceImpl;

@ExtendWith(SpringExtension.class)
public class CaseServiceImplTest {

	@Mock
	private CaseRepository caseRepository;

	@InjectMocks
	private CaseServiceImpl caseService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetCaseById_ValidId_ReturnsCaseDto() {
		// Arrange
		Long caseId = 1L;
		Case caseEntity = new Case(caseId, null, null, "Title", "Description");
		when(caseRepository.findById(caseId)).thenReturn(java.util.Optional.of(caseEntity));

		// Act
		ResponseEntity<CaseDto> response = caseService.getCaseById(caseId);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(caseEntity.getId(), response.getBody().getId());
		assertEquals(caseEntity.getTitle(), response.getBody().getTitle());
		assertEquals(caseEntity.getDescription(), response.getBody().getDescription());
		verify(caseRepository, times(1)).findById(caseId);
	}

	@Test
	void testGetCaseById_InvalidId_ThrowsEntityNotFoundException() {
		// Arrange
		Long caseId = 1L;
		when(caseRepository.findById(caseId)).thenReturn(java.util.Optional.empty());

		// Act & Assert
		assertThrows(EntityNotFoundException.class, () -> caseService.getCaseById(caseId));
	}

}