package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

@RestController

public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public List<Course> createCourse(@PathVariable String topicId, @RequestBody Course course){
		Topic topic = new Topic(topicId, "", "");
		course.setTopic(topic);
		courseService.addCourse(course);
		
		return courseService.getAllCourses();
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public List<Course> updateCourse(@PathVariable String topicId, @RequestBody Course course){
		Topic topic = new Topic(topicId, "", "");
		course.setTopic(topic);
		courseService.updateCourse(course);
		return courseService.getAllCourses();
	}
	
	@DeleteMapping("/topics/courses/{id}")
	public List<Course> deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
		return courseService.getAllCourses();
	}
	
	
}
