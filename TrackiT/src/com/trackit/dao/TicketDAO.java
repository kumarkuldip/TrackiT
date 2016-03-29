package com.trackit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.trackit.ec.Groups;
import com.trackit.ec.Ticket;

/**
 * @author IBM
 *
 */
public class TicketDAO {
	
	
	public Map<String,String> getGroupsForArea(){
		Map<String,String> groupsAreaMap = new HashMap<String, String>();
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
		 //creating transaction object  
	    Transaction transaction = session.beginTransaction();
	    Query query = session.createQuery("from Groups");
	    @SuppressWarnings("unchecked")
		List<Groups> groupList = (List<Groups>)query.list();
	    
	    for(Groups group : groupList){ 
	    	groupsAreaMap.put(group.getAssignmentGroup(),group.getArea());
	    }
	    transaction.commit();//transaction is committed  
	    session.close();  
	   return groupsAreaMap;
		
	}
	
	public void saveTicketDetails(List<Ticket> ticketList) throws SQLException{
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
	    
	    List<Ticket> existingTicketList = existingTicketList(ticketList);
		 //creating transaction object  
	    Transaction transaction = session.beginTransaction(); 
	    List<Ticket> clonedTicketList = new ArrayList<Ticket>();
	    clonedTicketList.addAll(ticketList);
	    
	    for(Ticket ticketBean : ticketList){
	    	for(Ticket dbTicket : existingTicketList){
	    		if(ticketBean.getTicketId().equalsIgnoreCase(dbTicket.getTicketId())){
	    			dbTicket.setSummary(ticketBean.getSummary());
	    			dbTicket.setPriority(ticketBean.getPriority());
	    			dbTicket.setAssignmentGroup(ticketBean.getAssignmentGroup());
	    			dbTicket.setAssignedTo(ticketBean.getAssignedTo());
	    			dbTicket.setStatus(ticketBean.getStatus());
	    			dbTicket.setUpdateOn(ticketBean.getUpdateOn());
	    			dbTicket.setLstUploadDate(new Date());
	    			dbTicket.setDone(ticketBean.isDone());
	    			clonedTicketList.remove(ticketBean);
	    			session.saveOrUpdate(dbTicket);
	    		}
	    	}
	    }
	    
	    for(Ticket ticket : clonedTicketList){
	    	ticket.setFrstUploadDate(new Date());
	    	ticket.setLstUploadDate(new Date());
	    	session.saveOrUpdate(ticket);//persisting the object
	    }
	    transaction.commit();//transaction is committed  
	    session.close();  
	    System.out.println("Tickets Uploaded and Saved");
	}
	
	
	@SuppressWarnings("unchecked")
	public void saveTicketData(List<Ticket> updatedTicketList) {
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
		 //creating transaction object  
	    Transaction transaction = session.beginTransaction(); 
	    List<Ticket> ticketList = new ArrayList<Ticket>();
	    List<String> ticketIdList = new ArrayList<String>();
	    
	    for(Ticket ticketObj : updatedTicketList){
	    	ticketIdList.add(ticketObj.getTicketId());
	    }
	    
	    Query query = session.createQuery("from Ticket where ticketId in :ticketIdList order by priority,lstUploadDate desc");
	    query.setParameterList("ticketIdList", ticketIdList);
    	ticketList = (List<Ticket>)query.list();
	    
	    
	    for(Ticket ticketBean : updatedTicketList){
	    	for(Ticket dbTicket : ticketList){
	    		if(ticketBean.getTicketId().equalsIgnoreCase(dbTicket.getTicketId())){
	    			dbTicket.setRemark(ticketBean.getRemark());
	    			dbTicket.setDone(ticketBean.isDone());
	    			session.saveOrUpdate(dbTicket);
	    		}
	    	}
	    }

	    transaction.commit();//transaction is committed  
	    session.close();  
	    System.out.println("Comments saved!!!");
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> existingTicketList(List<Ticket> uploadedTicketList){
		
	    List<String> ticketIdList = new ArrayList<String>();
	    
	    for(Ticket ticketObj : uploadedTicketList){
	    	ticketIdList.add(ticketObj.getTicketId());
	    }
	    
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
	    
	    Query query = session.createQuery("from Ticket where ticketId in :ticketIdList order by priority,lstUploadDate desc");
	    query.setParameterList("ticketIdList", ticketIdList);
    	return (List<Ticket>)query.list();
    	
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> showTickets() throws SQLException{
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
		 //creating transaction object  
	    List<Ticket> ticketList = null;
	    try{
	    	Query query = session.createQuery("from Ticket where status not in ('Closed','Resolved') order by priority,createdOn desc");
	    	ticketList = (List<Ticket>)query.list();
	    }catch(Exception exception){
	    	System.out.println(exception.getMessage());
	    }
	    session.close();  
		return ticketList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> showMyTickets(String assignedTO) throws SQLException{
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
	    Session session=factory.openSession(); 
		 //creating transaction object  
	    List<Ticket> ticketList = null;
	    assignedTO = StringUtils.lowerCase(assignedTO);
	    try{
	    	Query query = session.createQuery("from Ticket where LOWER(assignedTo) like '%"+assignedTO+"%' order by priority,createdOn desc");
	    	System.out.println(query.toString());
	    	ticketList = (List<Ticket>)query.list();
	    }catch(Exception exception){
	    	System.out.println(exception.getMessage());
	    }
	    session.close();  
		return ticketList;
	}
	
	
}