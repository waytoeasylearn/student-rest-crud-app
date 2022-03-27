package com.student.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sub_seq")
	@SequenceGenerator(initialValue = 100, name = "sub_seq", sequenceName = "subject_seq")
	@Column(name = "subject_id")
	private Long id;

	@Column(name = "subject_name")
	private String name;

	@Column(name = "marks")
	private int marks;

	public Subject() {
	}

	public Subject(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public Long getId() {
		return id;
	}

	public void setSubjectId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
}
