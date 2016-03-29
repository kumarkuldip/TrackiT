package com.trackit.command;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ExcelCommand {

	private CommonsMultipartFile fileData;

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

}