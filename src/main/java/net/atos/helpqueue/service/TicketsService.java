package net.atos.helpqueue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.atos.helpqueue.persistence.domain.Tickets;
import net.atos.helpqueue.persistence.repo.TicketsRepo;

@Service
public class TicketsService {

	// CRUD - Create Read Update Delete
	private TicketsRepo repo;

	public TicketsService(TicketsRepo repo) {
		super();
		this.repo = repo;
	}

	public Tickets createTickets(Tickets ticket) {
		return this.repo.save(ticket);
	}

	public Tickets getTicketByID(Long id) {
		return this.repo.findById(id).get();
	}

	public List<Tickets> getTickets() {
		return this.repo.findAll();
	}

	public Tickets complete(Long id, boolean complete) {
		Tickets existing = this.repo.findById(id).get();
		existing.setComplete(complete);
		return this.repo.save(existing);
	}

	public Tickets updateVotes(Long id) {
		Tickets existing = this.repo.findById(id).get();
		Integer updatedVote = existing.getUpVotes() + 1;
		existing.setUpVotes(updatedVote);

		return this.repo.save(existing);
	}

	public Tickets updateTicket(Long id, Tickets newData) {
		Tickets existing = this.repo.findById(id).get();

		existing.setProblemTitle(newData.getProblemTitle());
		existing.setProblemDescription(newData.getProblemDescription());
		existing.setEmail(newData.getEmail());
		existing.setTopic(newData.getTopic());
		existing.setDasId(newData.getDasId());
		existing.setSupportStaff(newData.getSupportStaff());
		existing.setUpVotes(newData.getUpVotes());
		existing.setDepartment(newData.getDepartment());
		existing.setSolution(newData.getSolution());

		return this.repo.save(existing);
	}

	public boolean deleteTicketByID(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); // if false still exists, otherwise true
	}

}
