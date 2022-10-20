package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.MusicReview;

@Repository
public interface MusicReviewRepo extends JpaRepository<MusicReview, Integer> {
	
	List<MusicReview> findAllBySubmitter(Integer id);
	
	

}
