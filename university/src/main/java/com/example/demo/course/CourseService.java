package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		return courseRepository.findByTopicId(topicId);
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	
	public Optional<Course> getCourse(String id){
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course){
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course){
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id){
		courseRepository.deleteById(id);
	}
	
}
