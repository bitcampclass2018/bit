package com.bitcamp.open0207.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.controller.DownloadController;

@SuppressWarnings("deprecation")
@Component(value="memberXLS")
public class MemberXLSView extends AbstractExcelView{

	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "멤버 xls");
		sheet.setColumnWidth(1, 256*20);
		
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("회원번호");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("아이디");
		cell = firstRow.createCell(2);
		cell.setCellValue("비밀번호");
		cell = firstRow.createCell(3);
		cell.setCellValue("이름");
		cell = firstRow.createCell(4);
		cell.setCellValue("이메일");
		
		List<Member> list = (List<Member>) model.get("memberXLS");
		
		int rowNum =1;
		for(Member member: list) {
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCell c = row.createCell(0);
			c.setCellValue(member.getIdx());
			c = row.createCell(1);
			c.setCellValue(member.getId());
			c = row.createCell(2);
			c.setCellValue(member.getPassword());
			c = row.createCell(3);
			c.setCellValue(member.getName());
			c = row.createCell(4);
			c.setCellValue(member.getEmail());
			
			rowNum++;
		}
	}

	
}
