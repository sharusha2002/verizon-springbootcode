package com.support.portal.ticketingsystem;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket getTicketById(Integer id) {
		return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
	}

	public Ticket updateTicket(Integer id, Ticket updatedTicket) {
		Ticket existingTicket = getTicketById(id);
		existingTicket.setTitle(updatedTicket.getTitle());
		existingTicket.setDescription(updatedTicket.getDescription());
		existingTicket.setCategory(updatedTicket.getCategory());
		existingTicket.setStatus(updatedTicket.getStatus());
		existingTicket.setPriority(updatedTicket.getPriority());
		existingTicket.setUpdatedAt(new Date()); // Assuming you want to update the updatedAt timestamp
		return ticketRepository.save(existingTicket);
	}

	public void deleteTicket(Integer id) {
		ticketRepository.deleteById(id);
	}

	// Other business logic method

}
