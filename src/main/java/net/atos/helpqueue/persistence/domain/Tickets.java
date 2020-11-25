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
	private String employeeName;
	private String department;
	private String supportStaff;
	private Integer upVotes;
	private String solution;
	private LocalDateTime ticketCreationTime = LocalDateTime.now();

	public Tickets() {
		super();
	}

	public Tickets(Long id, String problemTitle, String problemDescription, String employeeName, String department,
			String supportStaff, Integer upVotes, String solution) {
		super();
		this.id = id;
		this.problemTitle = problemTitle;
		this.problemDescription = problemDescription;
		this.employeeName = employeeName;
		this.department = department;
		this.supportStaff = supportStaff;
		this.upVotes = upVotes;
		this.solution = solution;
	}

	@Override
	public String toString() {
		return "Tickets [id=" + id + ", problemTitle=" + problemTitle + ", problemDescription=" + problemDescription
				+ ", employeeName=" + employeeName + ", department=" + department + ", supportStaff=" + supportStaff
				+ ", upVotes=" + upVotes + ", solution=" + solution + ", ticketCreationTime=" + ticketCreationTime
				+ "]";
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public LocalDateTime getTicketCreationTime() {
		return ticketCreationTime;
	}

	public void setTicketCreationTime(LocalDateTime ticketCreationTime) {
		this.ticketCreationTime = ticketCreationTime;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}
