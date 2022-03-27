package com.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.app.model.Subject;
/**
 * 
 * @author ashok.mariyala
 *
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	Subject findSubjectByName(String name);
}
