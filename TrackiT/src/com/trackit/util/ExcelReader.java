package com.trackit.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.trackit.command.ExcelCommand;
import com.trackit.dao.TicketDAO;
import com.trackit.ec.Ticket;

public class ExcelReader {

	public List<Ticket> importExcel(ExcelCommand excelCommand) {

		List<Ticket> ticketList = new ArrayList<Ticket>();
		ByteArrayInputStream bis = new ByteArrayInputStream(excelCommand
				.getFileData().getBytes());
		Workbook workbook;
		Ticket ticketBean = null;
		TicketDAO ticketDAO = new TicketDAO();
		Map<String,String> groupAreaMap = ticketDAO.getGroupsForArea();
		
		try {
			if (excelCommand.getFileData().getOriginalFilename()
					.endsWith("xls")) {
				workbook = new HSSFWorkbook(bis);
			} else if (excelCommand.getFileData().getOriginalFilename()
					.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(bis);
			} else {
				throw new IllegalArgumentException(
						"Received file does not have a standard excel extension.");
			}
			Sheet sheet = workbook.getSheetAt(0);
			Date createdOn;
			Date updatedOn;
			for (Row tempRow : sheet) {

				if (tempRow.getRowNum() > 0) {
					ticketBean = new Ticket();
					// print out the first three columns
					for (int column = 0; column < 8; column++) {
						Cell tempCell = tempRow.getCell(column);
						switch (column) {
						case 0:
							ticketBean.setTicketId(StringUtils.trim(tempCell.getStringCellValue()));
							break;
						case 1:
							ticketBean
									.setSummary(StringUtils.trim(tempCell.getStringCellValue()));
							break;
						case 2:
							ticketBean.setStatus(StringUtils.trim(tempCell.getStringCellValue()));
							break;
						case 3:
							ticketBean.setPriority(StringUtils.trim(tempCell
									.getStringCellValue()));
							break;
						case 4:
							ticketBean.setAssignmentGroup(StringUtils.trim(tempCell
									.getStringCellValue()));
							break;
						case 5:
							ticketBean.setAssignedTo(StringUtils.trim(tempCell
									.getStringCellValue()));
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
						ticketBean.setProject("RTS");
						ticketBean.setArea(groupAreaMap.get(ticketBean.getAssignmentGroup()));
						ticketBean.setLstUploadDate(new Date());
					}
					ticketList.add(ticketBean);
				}
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
}