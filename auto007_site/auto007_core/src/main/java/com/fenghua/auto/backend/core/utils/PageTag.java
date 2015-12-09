package com.fenghua.auto.backend.core.utils;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 分页标签
 * 
 */
public class PageTag extends TagSupport {
    
	private static final long serialVersionUID = 1L;
	private String url; //链接地址
    private int curpage;// 当前页
    private int totalPages; //总页数

    public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = this.pageContext.getOut();
        
        //{0}:url, {1}:curpage, {2}:pagesize, {3}:第一页 上一页 下一页 最后一页
        curpage = curpage + 1;
        String link = "<a href=''{0}?pageNumber={1}''>{2}</a>";
        if(curpage == 0) {
        	curpage = 1;
        } 

        int totalPages = this.getTotalPages();
        if(curpage > totalPages) curpage = totalPages;
        if(curpage < 1) {
        	curpage = 1;
        } 
        String first = MessageFormat.format(link, url, "1", "第一页");
        String previous = null;
        if(curpage <= 1){
            previous = "上一页";
        }else{
            previous = MessageFormat.format(link, url, String.valueOf(curpage - 1), "上一页");
        }
        
        String next = null;
        if(curpage >= totalPages){
            next = "下一页";
        }else{
            next = MessageFormat.format(link, url, String.valueOf(curpage + 1), "下一页");
        }
        
        String last = MessageFormat.format(link, url, String.valueOf(totalPages), "最后一页");
        
        try {
            String html = "{0} {1} {2} {3} 当前第{4}页 共{5}页 ";
            html = MessageFormat.format(html, 
                    first,
                    previous,
                    next,
                    last,
                    String.valueOf(curpage) ,
                    String.valueOf(getTotalPages()));
            
            out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
}