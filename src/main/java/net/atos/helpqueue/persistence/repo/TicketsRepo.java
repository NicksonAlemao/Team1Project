package net.atos.helpqueue.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.helpqueue.persistence.domain.Tickets;

public interface TicketsRepo extends JpaRepository<Tickets, Long> {

}
