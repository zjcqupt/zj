package common;

import java.util.List;
/*
 * 自己封装的分页类
 * 也可以使用现成的插件pageinfo
 * 继承类暂时不需要
 */
public class PagedResult <T> {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
 
	private List<T> dataList;//数据
	
	private long pageNo;//当前页
	
	private long pageSize;//条数
	
	private long total;//总条数
	
	private long pages;//总页面数目
	
	//添加的原pageinfo类中的参数，方便分页时调用
	
	private int firstPage;
	
	private int lastPage;
	
	private int nextPage;
	
	//所有导航页号,仍然借助pageinfo内部实现，在beanutil中只是调用而已
    private int[] navigatepageNums;
	
	private int prePage;
	
	 //是否为第一页
    private boolean isfirstPage = false;
    //是否为最后一页
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
