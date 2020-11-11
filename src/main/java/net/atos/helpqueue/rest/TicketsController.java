package net.atos.helpqueue.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.atos.helpqueue.persistence.domain.Tickets;
import net.atos.helpqueue.service.TicketsService;

public class TicketsController {

private TicketsService service;
	
	public TicketsController(TicketsService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Tickets> createTicket(@RequestBody Tickets ticket) {
		return new ResponseEntity<Tickets>(this.service.createTickets(ticket),HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public List<Tickets> readTickets() {
		return this.service.getTickets();
	}
	
	@GetMapping("/read/{id}")
	public Pokemon readTicket(@PathVariable Long id) {
		return this.service.getTicketByID(id);
	}
	
	@PutMapping("/update/{id}")
	public Pokemon updateTicket(@PathVariable Long id, @RequestBody Tickets newData) {
		return this.service.updateTicket(id, newData);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteTicket(@PathVariable Long id) {
		return this.service.deleteTicketByID(id);
	}
	
}
