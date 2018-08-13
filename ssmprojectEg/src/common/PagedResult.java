package common;

import java.util.List;
/*
 * �Լ���װ�ķ�ҳ��
 * Ҳ����ʹ���ֳɵĲ��pageinfo
 * �̳�����ʱ����Ҫ
 */
public class PagedResult <T> {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
 
	private List<T> dataList;//����
	
	private long pageNo;//��ǰҳ
	
	private long pageSize;//����
	
	private long total;//������
	
	private long pages;//��ҳ����Ŀ
	
	//��ӵ�ԭpageinfo���еĲ����������ҳʱ����
	
	private int firstPage;
	
	private int lastPage;
	
	private int nextPage;
	
	//���е���ҳ��,��Ȼ����pageinfo�ڲ�ʵ�֣���beanutil��ֻ�ǵ��ö���
    private int[] navigatepageNums;
	
	private int prePage;
	
	 //�Ƿ�Ϊ��һҳ
    private boolean isfirstPage = false;
    //�Ƿ�Ϊ���һҳ
    private boolean islastPage = false;
	
 
	public List<T> getDataList() {
		return dataList;
	}
 
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
 
	public long getPageNo() {
		return pageNo;
	}
 
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
 
	public long getPageSize() {
		return pageSize;
	}
 
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
 
	public long getTotal() {
		return total;
	}
 
	public void setTotal(long total) {
		this.total = total;
	}
 
	public long getPages() {
		return pages;
	}
 
	public void setPages(long pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "PagedResult:"+pageNo+"&&"+pages+"&&"+pageSize+"&&"+total;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public boolean getIsfirstPage() {
		return isfirstPage;
	}

	public void setIsfirstPage(boolean isFirstPage) {
		this.isfirstPage = isFirstPage;
	}

	public boolean getIslastPage() {
		return islastPage;
	}

	public void setIslastPage(boolean isLastPage) {
		this.islastPage = isLastPage;
	}
}
