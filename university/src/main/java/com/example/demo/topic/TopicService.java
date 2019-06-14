package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
/*
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Java", "The most pervasive Object Oriented Language")
	, new Topic("2", "Javascript", "Scripting language frequently used in web application"),
	new Topic("3", "Python", "Used for analytics and natural language processing")));
	*/
	public List<Topic> getAllTopics(){
		return topicRepository.findAll();
	}
	
	public Optional<Topic> getTopic(String id){
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic){
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id){
		topicRepository.deleteById(id);
	}
	
	
}
