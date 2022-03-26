package com.student.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.app.model.Student;
import com.student.app.model.Subject;
import com.student.app.repository.StudentRepository;
import com.student.app.repository.SubjectRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(Long studentId) {
		Optional<Student> studentDetails = studentRepository.findById(studentId);
		if (studentDetails.isPresent()) {
			return studentDetails.get();
		}
		return null;
	}

	@Override
	public List<Student> findStudentByName(String studentName) {
		return studentRepository.findStudentByName(studentName);
	}

	@Override
	public List<Student> findStudentsByMarks(int marks) {
		return studentRepository.findAll().stream().filter(student -> student.getTotalMarks() >= marks)
				.collect(Collectors.toList());
	}

	@Override
	public Student addStudent(Student student) {
		List<Integer> marksList = student.getSubjects().stream().map(subject -> subject.getMarks())
				.collect(Collectors.toList());
		int totalMarks = marksList.stream().mapToInt(Integer::intValue).sum();
		student.setTotalMarks(totalMarks);

		student.getSubjects().stream().forEach(subject -> subjectRepository.save(subject));
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, Long studentId) {
		Optional<Student> studentDetails = studentRepository.findById(studentId);
		if (studentDetails.isPresent()) {
			System.out.println("User found in database");
			Student studentObj = studentDetails.get();

			List<Integer> marksList = student.getSubjects().stream().map(subject -> subject.getMarks())
					.collect(Collectors.toList());
			int totalMarks = marksList.stream().mapToInt(Integer::intValue).sum();

			studentObj.setClazz(student.getClazz());
			studentObj.setName(student.getName());
			studentObj.setTotalMarks(totalMarks);

			for (Subject subject : student.getSubjects()) {
				Optional<Subject> dbSubjectDetails = subjectRepository.findById(subject.getSubjectId());
				Subject savingObject;
				if (dbSubjectDetails.isPresent()) {
					savingObject = dbSubjectDetails.get();
					savingObject.setMarks(subject.getMarks());
					savingObject.setName(subject.getName());
				} else {
					savingObject = new Subject(subject.getName(), subject.getMarks());
					savingObject.setSubjectId(subject.getSubjectId());
				}
				subjectRepository.save(subject);
			}
			System.out.println("Updated student details is : " + studentObj);

			return studentRepository.save(studentObj);
		} else {
			return null;
		}
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

}
