package com.zyj.ssm.util;

public class PageUtils {
	public PageUtils(){
	}
	private int pageTotal;//��ҳ��
	private int pageSize;//ÿҳ��ʾ�ļ�¼����
	private int currentPage;//��ǰҳ
	private int total;//��������
	
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
