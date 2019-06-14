package com.example.demo.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class TopicController {
	
	@Autowired
	private TopicService topicService;	

	@RequestMapping("/topics")
	
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
		
//		return topicRepository.findAll();
	}
	
	@RequestMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public List<Topic> addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topic/{id}")
	public List<Topic> updateTopic(@RequestBody Topic topic){
		topicService.updateTopic(topic);
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
	public List<Topic> deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
		return topicService.getAllTopics();
	}
	
}
