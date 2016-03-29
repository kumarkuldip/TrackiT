package com.trackit.command;

import java.util.List;

import com.trackit.ec.Ticket;

public class TicketCommand {

	List<Ticket> tickets;

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}