package fr.inventivit.assignement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.inventivit.assignement.entities.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {

}
