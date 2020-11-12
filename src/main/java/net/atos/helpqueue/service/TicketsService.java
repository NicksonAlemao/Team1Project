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
		
		public Tickets updateTicket(Long id, Tickets newData) {
			Tickets existing = this.repo.findById(id).get();
			existing.setQuestion(newData.getQuestion());
			existing.setSubject(newData.getSubject());
			existing.setTutor(newData.getTutor());
			existing.setUser(newData.getUser());
		
			return this.repo.save(existing);
		}
		
		public boolean deleteTicketByID(Long id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id); // if false still exists, otherwise true
		}
	
}