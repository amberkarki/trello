package com.trello.trello.domai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String position;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String sprinttime;
	private String sprintdsc;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "projectid")
	private Project project;

	public Developer() {
		super();
		
	}

	public Developer(String position, String firstname, String lastname, String phone, String email, String sprinttime,
			String sprintdsc, Project project) {
		super();
		this.position = position;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.sprinttime = sprinttime;
		this.sprintdsc = sprintdsc;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSprinttime() {
		return sprinttime;
	}

	public void setSprinttime(String sprinttime) {
		this.sprinttime = sprinttime;
	}

	public String getSprintdsc() {
		return sprintdsc;
	}

	public void setSprintdsc(String sprintdsc) {
		this.sprintdsc = sprintdsc;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	//@Override
	//public String toString() {
		
		//if(this.project != null) {
		
		//return "Developer [id=" + id + ", position=" + position + ", firstname=" + firstname + ", lastname=" + lastname
				//+ ", phone=" + phone + ", email=" + email + ", sprinttime=" + sprinttime + ", sprintdsc=" + sprintdsc
			//	+ ", project=" + project + "]";
	//}
		//return "Developer [position=" + position + ", firstname=" + firstname + ", lastname=" + lastname
			//	+ ", phone=" + phone + ", email=" + email + ", sprinttime=" + sprinttime + ", sprintdsc=" + sprintdsc
				//+ "]";
	//}
	
	
	

}
