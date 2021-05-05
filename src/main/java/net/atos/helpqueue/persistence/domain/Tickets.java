package net.atos.helpqueue.persistence.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String problemTitle;
	private String problemDescription;
	private String email;
	private String topic;
	private String dasId;
	private String department;
	private String supportStaff;
	private Integer upVotes = 1;
	private String solution;
	private boolean complete;
	private LocalDateTime ticketCreationTime = LocalDateTime.now();

	public Tickets() {
		super();
	}

	public Tickets(Long id, String problemTitle, String problemDescription, String email, String topic, String dasId,
			String department, String supportStaff, Integer upVotes, String solution, boolean complete) {
		super();
		this.id = id;
		this.problemTitle = problemTitle;
		this.problemDescription = problemDescription;
		this.email = email;
		this.topic = topic;
		this.dasId = dasId;
		this.department = department;
		this.supportStaff = supportStaff;
		this.upVotes = upVotes;
		this.solution = solution;
		this.complete = complete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDasId() {
		return dasId;
	}

	public void setDasId(String dasId) {
		this.dasId = dasId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSupportStaff() {
		return supportStaff;
	}

	public void setSupportStaff(String supportStaff) {
		this.supportStaff = supportStaff;
	}

	public Integer getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(Integer upVotes) {
		this.upVotes = upVotes;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public LocalDateTime getTicketCreationTime() {
		return ticketCreationTime;
	}

	public void setTicketCreationTime(LocalDateTime ticketCreationTime) {
		this.ticketCreationTime = ticketCreationTime;
	}

}
