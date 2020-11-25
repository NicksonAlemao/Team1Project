package net.atos.helpqueue.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.helpqueue.persistence.domain.Tickets;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TicketIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testTicketCreationWithAssert() throws Exception {

		Tickets newTicket = new Tickets(null, "problemTitle", "problemDescription", "employeeName", "department",
				"supportStaff", 1, "solution");
		String newTicketAsJson = this.mapper.writeValueAsString(newTicket);

		RequestBuilder request = post("/create").content(newTicketAsJson).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher resultStatus = status().is(201);

		Tickets expectedTicket = new Tickets(1L, newTicket.getProblemTitle(), newTicket.getProblemDescription(),
				newTicket.getEmployeeName(), newTicket.getDepartment(), newTicket.getSupportStaff(),
				newTicket.getUpVotes(), newTicket.getSolution());

		// checks the status and then returns the whole result of the request
		MvcResult result = this.mockMvc.perform(request).andExpect(resultStatus).andReturn();

		// Extracts response body as a String (will be a JSON String with this app)
		String responseBody = result.getResponse().getContentAsString();

		// Uses the ObjectMapper to convert the JSON String back to a Ticket
		Tickets actualTicket = this.mapper.readValue(responseBody, Tickets.class);

		// Using the AssertJ library to compare the two Dog objects - test will fail if
		// objects don't match
		// Note:
		// You WILL need an .equals() method in the class you're testing for this.
		// .equals() can be generated using RMB > Source > Generate hashcode() and
		// equals()
		// An example of the .equals() method can be found at the bottom of the Dog
		// class
		// More info on AssertJ available @
		// https://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
		assertThat(actualTicket).isEqualToIgnoringGivenFields(expectedTicket, "ticketCreationTime");

	}

}
