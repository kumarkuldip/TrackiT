package com.trackit.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.trackit.command.ExcelCommand;
import com.trackit.command.TicketCommand;
import com.trackit.dao.TicketDAO;
import com.trackit.ec.Ticket;
import com.trackit.util.ExcelReader;



@Controller
@SessionAttributes
public class TrackitController{

	@RequestMapping("/")
	public ModelAndView showIndex(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
 
		return new ModelAndView("index");
 
	}
	
	@RequestMapping("/test.html")
	public ModelAndView showDashboard(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
 
		return new ModelAndView("display","Kuldeep","Check it");
 
	}
	
	@RequestMapping(value="/uploadExcel.html", method = RequestMethod.POST)
	public ModelAndView uploadTicketReportExcel(@ModelAttribute("excelCommand") ExcelCommand excelCommand, BindingResult result) throws Exception {

		ExcelReader excelReader = new ExcelReader();
		excelReader.importExcel(excelCommand);
		TicketCommand tickets =new TicketCommand();
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.saveTicketDetails(excelReader.importExcel(excelCommand));
		tickets.setTickets(ticketDAO.showTickets());
		return new ModelAndView("ticketDetails","tickets",tickets);
		
	}
	
	
	@RequestMapping("/tickets.html")
	public ModelAndView showTickets(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		
		TicketCommand tickets =new TicketCommand();
		TicketDAO ticketDAO = new TicketDAO();
		tickets.setTickets(ticketDAO.showTickets());
		return new ModelAndView("ticketDetails","tickets",tickets);
	}
	
	@RequestMapping(value="/myTickets.html", method = RequestMethod.POST)
	public ModelAndView showMyTickets(@ModelAttribute("ticket") Ticket ticket, BindingResult result) throws SQLException {
		
		TicketCommand tickets =new TicketCommand();
		TicketDAO ticketDAO = new TicketDAO();
		tickets.setTickets(ticketDAO.showMyTickets(ticket.getAssignedTo()));
		return new ModelAndView("ticketDetails","tickets",tickets);
	}
	
	
	@RequestMapping(value="/saveTickets.html", method = RequestMethod.POST)
	public ModelAndView saveTickets(@ModelAttribute("ticketCommand") TicketCommand ticketCommand, BindingResult result) throws SQLException {
		
		List<Ticket> ticketList = ticketCommand.getTickets();
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.saveTicketData(ticketList);
		ticketCommand.setTickets(ticketDAO.showTickets());
		return new ModelAndView("ticketDetails","tickets",ticketCommand);

	}
	
}