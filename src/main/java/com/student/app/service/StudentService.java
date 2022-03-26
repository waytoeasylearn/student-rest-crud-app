package com.student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.app.model.Student;

@Service
public interface StudentService {
	Student findStudentById(Long studentId);
	List<Student> getAllStudents();
	List<Student> findStudentByName(String studentName);
	List<Student> findStudentsByMarks(int marks);
	Student addStudent(Student student);
	Student updateStudent(Student student, Long studentId);
	void deleteStudent(Student student);
}
