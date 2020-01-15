package com.trello.trello.domai;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
	private List <Developer> developers;
	
	public Project() {
		super();
	}
	
	public Project(String name) {
		super();
		this.name = name;
	}
	public long getProjectid() {
		return projectid;
	}
	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectid + ", name=" + name + ", developers=" + developers + "]";
	}
		
	
	
	}
