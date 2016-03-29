package com.trackit.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.trackit.dao.TicketDAO;
import com.trackit.ec.Ticket;

/**
 * @author IBM
 *
 */
public class ReadTicketReport {
	
	

	public void readExcel(File uploadedExcel) throws Exception  {
		TicketDAO ticketDAO = new TicketDAO();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(uploadedExcel));
		int sheetIndex = 0;
		HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		List<Ticket> ticketList = new ArrayList<Ticket>();
		Ticket ticketBean = null;
		Date createdOn;
		Date updatedOn;
		for (Row tempRow : sheet) {
			if(tempRow.getRowNum()>0){
			ticketBean = new Ticket();
			// print out the first three columns
			for (int column = 0; column < 8; column++) {
				Cell tempCell = tempRow.getCell(column);
				switch (column) {
				case 0:
					ticketBean.setTicketId(tempCell.getStringCellValue());
					break;
				case 1:
					ticketBean.setSummary(tempCell.getStringCellValue());
					break;
				case 2:
					ticketBean.setStatus(tempCell.getStringCellValue());
					break;
				case 3:
					ticketBean.setPriority(tempCell.getStringCellValue());
					break;
				case 4:
					ticketBean
							.setAssignmentGroup(tempCell.getStringCellValue());
					break;
				case 5:
					ticketBean.setAssignedTo(tempCell.getStringCellValue());
					break;
				case 6:
					createdOn = tempCell.getDateCellValue();
					ticketBean.setCreatedOn(createdOn);
					break;
				case 7:
					updatedOn = tempCell.getDateCellValue();
					ticketBean.setUpdateOn(updatedOn);
					break;
				}
			}
			ticketList.add(ticketBean);
		}
			workbook.close();
		}// End outer for
		ticketDAO.saveTicketDetails(ticketList);
	}//end main
}