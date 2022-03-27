package com.student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.app.model.Student;
/**
 * 
 * @author ashok.mariyala
 *
 */
@Service
public interface StudentService {
	public abstract Student findStudentById(Long studentId);
	public abstract List<Student> getAllStudents();
	public abstract List<Student> findStudentByName(String studentName);
	public abstract List<Student> findStudentsByClass(String clazz);
	public abstract List<Student> findStudentsByMarksGreaterThanGiven(int marks);
	public abstract Student addStudent(Student student);
	public abstract Student updateStudent(Student student, Long studentId);
	public abstract void deleteStudent(Student student);
}
