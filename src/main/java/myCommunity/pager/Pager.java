package myCommunity.pager;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pager extends SimpleTagSupport {
	
	private int pageSize = 10;
	private int numbers = 10;
	private int totalRows;
	private int curPage;
	private String urlFormat;
	private int totalPages;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		if(curPage<1)
			this.curPage = 1;
		else
			this.curPage = curPage;
	}
	public String getUrlFormat() {
		return urlFormat;
	}
	public void setUrlFormat(String urlFormat) {
		this.urlFormat = urlFormat;
	}
	public int getTotalPages() {
		return totalPages;
	}

	@Override
	public void doTag() throws JspException, IOException {
		totalPages = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		int leftPageNum = 1;
		int rightPageNum = totalPages;
		int offset = numbers/2;
		
		if(totalPages>numbers) {
			if(curPage<=offset) {
				leftPageNum = 1;
				rightPageNum = numbers;
			}else {
				if(curPage + offset >= totalPages+1) {
					leftPageNum = totalPages-numbers+1;
				}else {
					leftPageNum = curPage - offset;
					rightPageNum = numbers%2==1?curPage+offset:curPage+offset-1;
				}
			}
		}
		
		JspWriter out = this.getJspContext().getOut();
		out.println("<div class=\"pager\">");
		if(curPage>1) {
			out.println("<a class=\"nextPage\" href=\""+String.format(urlFormat, 1)+"\">&lt;&lt;</a>");
			out.println("<a class=\"nextPage\" href=\""+String.format(urlFormat, curPage-1)+"\">&lt;</a>");
		}
		for(int i=leftPageNum; i<=rightPageNum;i++) {
			if(i==curPage)
				out.println("<span class=\"current\"\">"+i+"</span>");
			else
				out.println("<a href=\""+String.format(urlFormat, i)+"\">"+i+"</a>");
		}
		if(curPage<totalPages) {
			out.println("<a class=\"prevPage\" href=\""+String.format(urlFormat, curPage+1)+"\">&gt;</a>");
			out.println("<a class=\"prevPage\" href=\""+String.format(urlFormat, totalPages)+"\">&gt;&gt;</a>");
		}
		out.println("<span class=\"pageInfo\">第"+curPage+"页，共"+totalPages+"页</span>");
		out.println("</div>");
	}
	
}
