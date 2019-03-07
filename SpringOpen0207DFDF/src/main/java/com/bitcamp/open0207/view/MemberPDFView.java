package com.bitcamp.open0207.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bitcamp.open0207.model.Member;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@Component(value="memberPDF")
public class MemberPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Member> list = (List<Member>) model.get("memberPDF");
		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		Paragraph p = new Paragraph("멤버 pdf",font);
		
		Table table = new Table(5, list.size() +1);
		table.setPadding(5);
		Cell cell = new Cell(new Paragraph("회원번호",font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("아이디",font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("비밀번호",font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("이름",font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("이메일",font));
		table.addCell(cell);
		table.endHeaders();
		for(Member member : list) {
			table.addCell(Integer.toString(member.getIdx()));
			table.addCell(member.getId());
			table.addCell(member.getPassword());
			cell = new Cell(new Paragraph(member.getName(),font));
			table.addCell(cell);
			table.addCell(member.getEmail());
		}
		document.add(p);
		document.add(table);
	}
}
