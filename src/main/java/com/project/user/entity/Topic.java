package com.project.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Topic")
public class Topic {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long topicId;
	
	@NotNull
	@Column(name="TopicName")
	private String topicName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "PackageId")
	private VideoPackage videoPackage;
	
	@OneToMany(mappedBy = "topic",cascade={CascadeType.MERGE,CascadeType.REMOVE})
	private Set<Video> videos = new HashSet<>();
	
	public Topic(){}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public VideoPackage getVideoPackage() {
		return videoPackage;
	}

	public void setVideoPackage(VideoPackage videoPackage) {
		this.videoPackage = videoPackage;
	}

	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", videoPackage=" + videoPackage + "]";
	}
}
