package net.atos.helpqueue.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.helpqueue.persistence.domain.Tickets;
import net.atos.helpqueue.service.TicketsService;

@RestController
public class TicketsController {

	private TicketsService service;

	public TicketsController(TicketsService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Tickets> createTicket(@RequestBody Tickets ticket) {
		return new ResponseEntity<Tickets>(this.service.createTickets(ticket), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public List<Tickets> readTickets() {
		return this.service.getTickets();
	}

	@GetMapping("/read/{id}")
	public Tickets readTicket(@PathVariable Long id) {
		return this.service.getTicketByID(id);
	}

	@PatchMapping("/complete/{id}/{complete}")
	public Tickets checkComplete(@PathVariable Long id, @PathVariable boolean complete) {
		return this.service.complete(id, complete);
	}

	@PatchMapping("/upVote/{id}")
	public Tickets updateVotes(@PathVariable Long id) {
		return this.service.updateVotes(id);
	}

	@PutMapping("/update/{id}")
	public Tickets updateTicket(@PathVariable Long id, @RequestBody Tickets newData) {
		return this.service.updateTicket(id, newData);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteTicket(@PathVariable Long id) {
		return this.service.deleteTicketByID(id);
	}

}
