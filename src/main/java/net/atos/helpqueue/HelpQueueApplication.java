package net.atos.helpqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import net.atos.helpqueue.persistence.domain.Tickets;
import net.atos.helpqueue.service.TicketsService;

@SpringBootApplication
public class HelpQueueApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(HelpQueueApplication.class, args);
		TicketsService newTicket = ac.getBean(TicketsService.class);
		System.out.println(newTicket.createTickets(new Tickets(null, "wassup", "nick", "noclue", "QA")));

	}

}
