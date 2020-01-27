
package com.fernbird.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;


import com.fernbird.entity.Employer;

public interface Employerrepo extends JpaRepository<Employer, Integer> {
	List<Employer> findByName(String name,Pageable pageable);
	
	List<Employer> findById(int id);
}
