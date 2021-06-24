package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		
		return courseRepository.findAll();
		
	}
	
	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course c){
		
		return courseRepository.save(c);
		
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
		
		Course c = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Not found of id :"+id));
		
		return ResponseEntity.ok(c);
		
		
	}
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Integer id,@RequestBody Course cdetails){
		
		Course c = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Not found of id :"+id));
		
		c.setCourse_name(cdetails.getCourse_name());
		c.setCourse_instructor(cdetails.getCourse_instructor());
		c.setType_of_course(cdetails.getType_of_course());
		c.setNo_of_students(cdetails.getNo_of_students());
		
		Course updatedCourse = courseRepository.save(c);
		
		return ResponseEntity.ok(c);
		
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable int id){
		Course c = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Not found of id :"+id));
		courseRepository.delete(c);
		Map<String, Boolean> res = new HashMap<String, Boolean>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
		
	}
	

}
