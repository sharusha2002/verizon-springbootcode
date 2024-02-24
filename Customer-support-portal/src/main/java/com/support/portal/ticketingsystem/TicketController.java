package com.support.portal.ticketingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	
	
	

	    private final TicketService ticketService;

	    @Autowired
	    public TicketController(TicketService ticketService) {
	        this.ticketService = ticketService;
	    }

	    @GetMapping
	    public ResponseEntity<List<Ticket>> getAllTickets() {
	        List<Ticket> tickets = ticketService.getAllTickets();
	        return new ResponseEntity<>(tickets, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id) {
	        Ticket ticket = ticketService.getTicketById(id);
	        return new ResponseEntity<>(ticket, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
	        Ticket createdTicket = ticketService.createTicket(ticket);
	        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket) {
	        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
	        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTicket(@PathVariable Integer id) {
	        ticketService.deleteTicket(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}


