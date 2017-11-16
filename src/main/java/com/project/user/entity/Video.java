package com.project.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Video")
public class Video {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long videoId;
	@NotNull
	@Column(name="VideoName")
	private String videoName;
	@Column(name="VideoPath")
	private String videoPath;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "TopicId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Topic topic;
	
	public Video(){}

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoName=" + videoName + ", videoPath=" + videoPath + ", topic="
				+ topic + "]";
	}

}
