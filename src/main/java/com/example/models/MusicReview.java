package com.example.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "music_review")
public class MusicReview {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "critique_id")
	private Integer critiqueId;
	
	@Column(name = "song_name")
	private String songName;
	
	private String artist;
	
	@Column(name = "song_length")
	private double songLength;
	
	private String genre;
	
	@Column(name="song_critique")
	private String songCritique;
	
	@Column(name="music_employee_id")
	private Integer submitter;
	
	@Column(name="submitted_date")
	private Date submittedDate;
	
	@Column(name="editor_id")
	private Integer approver;
	
	@Column(name="review_date")
	private Date reviewDate;
	
	private String status;
	
	

	
	
	
	
	
	public MusicReview() {
		super();
	}








	public MusicReview(Integer critiqueId, String songName, String artist, double songLength, String genre,
			String songCritique, Integer submitter, Date submittedDate, Integer approver, Date reviewDate, String status) {
		super();
		this.critiqueId = critiqueId;
		this.songName = songName;
		this.artist = artist;
		this.songLength = songLength;
		this.genre = genre;
		this.songCritique = songCritique;
		this.submitter = submitter;
		this.submittedDate = submittedDate;
		this.approver = approver;
		this.reviewDate = reviewDate;
		this.status = status;
	}








	public MusicReview(String songName, String artist, double songLength, String genre, String songCritique,
			Integer submitter) {
		super();
		this.songName = songName;
		this.artist = artist;
		this.songLength = songLength;
		this.genre = genre;
		this.songCritique = songCritique;
		this.submitter = submitter;
		this.status = "PENDING";
		this.submittedDate = new Date(System.currentTimeMillis());
		this.approver = null;
		this.reviewDate = null;
	}








	public Integer getCritiqueId() {
		return critiqueId;
	}








	public void setCritiqueId(Integer critiqueId) {
		this.critiqueId = critiqueId;
	}








	public String getSongName() {
		return songName;
	}








	public void setSongName(String songName) {
		this.songName = songName;
	}








	public String getArtist() {
		return artist;
	}








	public void setArtist(String artist) {
		this.artist = artist;
	}








	public double getSongLength() {
		return songLength;
	}








	public void setSongLength(double songLength) {
		this.songLength = songLength;
	}








	public String getGenre() {
		return genre;
	}








	public void setGenre(String genre) {
		this.genre = genre;
	}








	public String getSongCritique() {
		return songCritique;
	}








	public void setSongCritique(String songCritique) {
		this.songCritique = songCritique;
	}








	public Integer getSubmitter() {
		return submitter;
	}








	public void setSubmitter(Integer submitter) {
		this.submitter = submitter;
	}








	public Date getSubmittedDate() {
		return submittedDate;
	}








	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}








	public Integer getApprover() {
		return approver;
	}








	public void setApprover(Integer approver) {
		this.approver = approver;
	}








	public Date getReviewDate() {
		return reviewDate;
	}








	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}








	public String getStatus() {
		return status;
	}








	public void setStatus(String status) {
		this.status = status;
	}








	@Override
	public String toString() {
		return "MusicReview [critiqueId=" + critiqueId + ", songName=" + songName + ", artist=" + artist
				+ ", songLength=" + songLength + ", genre=" + genre + ", songCritique=" + songCritique + ", submitter="
				+ submitter + ", submittedDate=" + submittedDate + ", approver=" + approver + ", reviewDate="
				+ reviewDate + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	






	
	
	
	
	
	
		

}
