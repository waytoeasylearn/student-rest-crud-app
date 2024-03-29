package com.student.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.student.app.model.Student;
import com.student.app.service.StudentServiceImpl;

/**
 * 
 * @author ashok.mariyala
 *
 */
@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService; 

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentData = studentService.getAllStudents();
		if (null != studentData) {
			return new ResponseEntity<>(studentData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/students/{name}")
	public ResponseEntity<List<Student>> getStudentByName(@PathVariable("name") String name) {
		List<Student> studentData = studentService.findStudentByName(name);
		if (null != studentData) {
			return new ResponseEntity<>(studentData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/students/totalmarks")
	public ResponseEntity<List<Student>> getStudentsByMarks(@RequestParam(required = true) int gt) {
		List<Student> studentList = studentService.findStudentsByMarksGreaterThanGiven(gt);
		if (null != studentList) {
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/students/class")
	public ResponseEntity<List<Student>> getStudentsByMarks(@RequestParam(required = true, name = "class") String clazz) {
		List<Student> studentList = studentService.findStudentsByClass(clazz);
		if (null != studentList) {
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/students")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		try {
			Student studentData = studentService.addStudent(student);
			if (null == studentData) {
				return ResponseEntity.noContent().build();
			}
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
					.buildAndExpand(studentData.getName()).toUri();

			return new ResponseEntity<>(location, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable(value = "id") Long studentId, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(student, studentId);
		if (null != updatedStudent) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/students/{name}")
					.buildAndExpand(updatedStudent.getName()).toUri();

			return new ResponseEntity<>(location, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {

		Student student = studentService.findStudentById(studentId);
		if (null != student) {
			studentService.deleteStudent(student);

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
