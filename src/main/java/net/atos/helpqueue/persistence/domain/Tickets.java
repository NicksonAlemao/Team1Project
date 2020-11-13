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
	private String question;
	private String user;
	private String subject;
	private String tutor;
	private LocalDateTime ticketCreationTime = LocalDateTime.now();

	public Tickets() {
		super();
	}

	public Tickets(Long id, String question, String user, String subject, String tutor) {
		super();
		this.id = id;
		this.question = question;
		this.user = user;
		this.subject = subject;
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Tickets [id=" + id + ", question=" + question + ", user=" + user + ", subject=" + subject + ", tutor="
				+ tutor + ", ticketCreationTime=" + ticketCreationTime + "]";
	}

	public LocalDateTime getTicketCreationTime() {
		return ticketCreationTime;
	}

	public void setTicketCreationTime(LocalDateTime ticketCreationTime) {
		this.ticketCreationTime = ticketCreationTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

}
