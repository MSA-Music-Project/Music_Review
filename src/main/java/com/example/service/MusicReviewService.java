package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.MusicReview;
import com.example.repo.MusicReviewRepo;

@Service
public class MusicReviewService {
	
	private MusicReviewRepo mRepo;
	
	@Autowired
	public MusicReviewService(MusicReviewRepo mRepo) {
		this.mRepo = mRepo;
	}
	
	
	public MusicReview createMusicReview(MusicReview m) {
		
		MusicReview newReview = new MusicReview(m.getSongName(), m.getArtist(), m.getSongLength(), m.getGenre(), m.getSongCritique(), m.getSubmitter());
		
		return mRepo.save(newReview);
	}
	
	public MusicReview approveOrDenyReview(Integer critiqueId, Boolean approved, Integer editorId) {
		
		MusicReview m = mRepo.findById(critiqueId).get();
		
		if(!m.getStatus().equals("PENDING")) {
			return m;
		}
		
		if(approved = true) {
			m.setStatus("APPROVED");
		}
		else {
			m.setStatus("DENEID");
		}
		
		m.setApprover(editorId);
		
		m.setReviewDate(new Date(System.currentTimeMillis()));
		
		return mRepo.save(m);
	}
	
	public List<MusicReview> getAllMusicReviews(){
		
		return mRepo.findAll();
	}
	
	public List<MusicReview> getAllMusicReiviewsByEmployee(Integer id ){
		return mRepo.findAllBySubmitter(id);
	}

}
