package net.atos.helpqueue.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.helpqueue.persistence.domain.Tickets;

@Repository
public interface TicketsRepo extends JpaRepository<Tickets, Long> {

}
