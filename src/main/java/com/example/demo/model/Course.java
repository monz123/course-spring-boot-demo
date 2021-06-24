package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_instructor")
	private String courseInstructor;
	
	@Column(name = "type_of_course")
	private String typeOfCourse;
	
	@Column(name = "no_of_students")
	private int noOfStudents;
	
	public Course() {
		
	}
	
	public Course(String course_name, String course_instructor, String type_of_course) {
		super();
		this.courseName = course_name;
		this.courseInstructor = course_instructor;
		this.typeOfCourse = type_of_course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_name() {
		return courseName;
	}
	public void setCourse_name(String course_name) {
		this.courseName = course_name;
	}
	public String getCourse_instructor() {
		return courseInstructor;
	}
	public void setCourse_instructor(String course_instructor) {
		this.courseInstructor = course_instructor;
	}
	public int getNo_of_students() {
		return noOfStudents;
	}
	public void setNo_of_students(int no_of_students) {
		this.noOfStudents = no_of_students;
	}
	public String getType_of_course() {
		return typeOfCourse;
	}
	public void setType_of_course(String type_of_course) {
		this.typeOfCourse = type_of_course;
	}
	
	
	
	
}
