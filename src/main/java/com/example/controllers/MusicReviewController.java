package com.example.controllers;

import java.net.URI;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.models.MusicReview;
import com.example.repo.MusicReviewRepo;
import com.example.service.MusicReviewService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@CrossOrigin
//@RequestMapping("/review")
public class MusicReviewController {
	
	
	private MusicReviewService mService;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//@Autowired
	//private RestTemplate rest;
	
	@Autowired
	public MusicReviewController(MusicReviewService mService) {
		this.mService = mService;
	}
	
	
	
	
	
	@GetMapping("/all")
	public List<MusicReview> getAllMusicReiviews(){
		return mService.getAllMusicReviews(); 
		
	}
	
	
	@PostMapping("/create")
	public MusicReview createMusicReview(@RequestBody MusicReview m){
		return mService.createMusicReview(m);	
	}

	
	@Retry(name="updateBackend", fallbackMethod="updateBackup")
	@PutMapping("/update")
	public ResponseEntity<Object> updateMusicReview(@RequestBody LinkedHashMap<String, String> body) {
		
		//String url = "http://localhost:7049/api/editor";
		
		URI uri = URI.create("http://localhost:9000/employee/editor");
		
		RestTemplate rest = new RestTemplate();
		
		
		EditorCheck ec = new EditorCheck();
		ec.id = body.get("editorId");
		
		
		HttpEntity<EditorCheck> request = new HttpEntity<EditorCheck>(ec);
		
		Boolean editor = rest.postForObject(uri, request, Boolean.class);
		
		if(editor == false) {
			return new ResponseEntity("Must be an editor to approve Music Review", HttpStatus.UNAUTHORIZED);
		}
		
		MusicReview m = mService.approveOrDenyReview(Integer.parseInt(body.get("critiqueId")),Boolean.parseBoolean(body.get("APPROVED")), Integer.parseInt(body.get("editorId")));
		
		return new ResponseEntity(m,HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<Object> updateBackup(@RequestBody LinkedHashMap<String, String> body, Exception e){
		
		return new ResponseEntity("Cannot verify editor status", HttpStatus.BAD_GATEWAY);
		
	}
	

	
	
	
	

}


class EditorCheck {
	public String id;
}
