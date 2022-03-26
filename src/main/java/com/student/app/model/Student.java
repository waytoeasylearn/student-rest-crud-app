package com.student.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "stu_seq")
	@SequenceGenerator(initialValue = 1, name = "stu_seq", sequenceName = "student_seq")
	@Column(name = "student_id")
	private Long id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_class")
	@JsonProperty("class")
	private String clazz;

	@Column(name = "total_marks")
	private int totalMarks;

	@OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "stu_sub_fk", referencedColumnName = "student_id")
	private Set<Subject> subjects;

	public Student() {
	}

	public Student(String name, String clazz, int totalMarks) {
		this.name = name;
		this.clazz = clazz;
		this.totalMarks = totalMarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazz=" + clazz + ", totalMarks=" + totalMarks
				+ ", subjects=" + subjects + "]";
	}
}
