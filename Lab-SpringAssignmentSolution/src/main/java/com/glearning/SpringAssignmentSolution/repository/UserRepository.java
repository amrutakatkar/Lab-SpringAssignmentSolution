package com.glearning.SpringAssignmentSolution.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.glearning.SpringAssignmentSolution.model.User, Long> {
	
	Optional<com.glearning.SpringAssignmentSolution.model.User> findByUserName(String userName);
}
